package streaming

import cats.effect.{IO, _}
import cats.implicits._
import fansi.{Color => FG}
import fs2.{Stream, text}
import io.circe.parser.decode
import org.http4s._
import org.http4s.blaze.client.BlazeClientBuilder
import org.http4s.client.Client
import org.http4s.implicits._

import java.time._
import java.util.concurrent._
import scala.concurrent.ExecutionContext

object HttpConsumeStream extends IOApp.Simple {

  val request = Request[IO](uri = uri"http://localhost:8080/s")

  /** acquiring thread pool */
  def tpAcquire(nThreads: Int): IO[ExecutorService] = IO(Executors.newFixedThreadPool(nThreads))

  /** releasing thread pool */
  def tpRelease(pool: ExecutorService): IO[Unit] = IO(pool.shutdown())

  /** ExecutionContext as a resource */
  def mkEcResource(nThreads: Int): Resource[IO, ExecutionContext] =
    Resource
      .make(tpAcquire(nThreads))(tpRelease)
      .map(ExecutionContext.fromExecutorService)

  /** stream of one element = HttpClient, will run on the given ExecutionContext */
  def mkHttpClient(ec: ExecutionContext): Stream[IO, Client[IO]] = BlazeClientBuilder[IO]
    .withExecutionContext(ec)
    .stream

  def time: LocalTime = {
    val current = System.currentTimeMillis
    val instant = Instant.ofEpochMilli(current)
    val zdt = instant.atZone(ZoneId.of("GMT+3"))
    val lt = zdt.toLocalTime
    lt
  }

  def pad(s: String, width: Int) = String.format("%-"+width.toString+"s" , s)

  def representHeaders(rs: Response[IO]): String = {
    val prefix = FG.Blue("Headers:")
    val maxWidth = rs.headers.headers.maxBy(_.name.length).name.length
    val data = rs
      .headers
      .headers
      .map(h => FG.LightBlue(pad(h.name.toString, maxWidth)) + " : " + FG.LightBlue(h.value))
      .mkString("\n")
    s"$prefix\n$data"
  }

  def oneByOne =
    mkEcResource(8)
      .use { ec =>
        mkHttpClient(ec)
          .flatMap(_.stream(request))
          .evalTap { rs => IO.println(representHeaders(rs)) }
          .map(_.body)
          .flatMap(_.through(text.utf8.decode))
          .flatMap(raw =>  decode[Data](raw).fold(_ => Stream.empty, Stream.emit))
          .evalTap { x: Data =>
            IO {
              print(s"${Thread.currentThread().getName}: ")
              print(time)
              print(" : ")
              pprint.pprintln(x)
            }
              .evalOn(ec)
          }
          .compile
          .drain
      }

  override def run = oneByOne
}
