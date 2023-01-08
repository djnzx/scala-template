package json

import io.circe.Encoder
import io.circe.generic.semiauto.deriveEncoder

case class Person(name: String, age: Int)

object Person {
  implicit val encoder: Encoder[Person] = deriveEncoder
}
