package streaming

import io.circe.syntax.EncoderOps

object DeserializePlayground extends App {

  val raw = "33"
  val json = raw.asJson.noSpaces

  println(raw)
  println(json)

  pprint.pprintln(io.circe.parser.decode[Data](json))

}
