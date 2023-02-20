package json

import io.circe.Encoder
import io.circe.Json
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.semiauto.deriveConfiguredEncoder
import io.circe.generic.semiauto.deriveEncoder
import io.circe.syntax.EncoderOps
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class SerializationSpec extends AnyFunSpec with Matchers {

  describe("serialization") {

    it("manual object creation") {
      val jo = Json.obj(
        "a"       -> 1.asJson,
        "b"       -> "Jim".asJson,
        "skills"  -> List("Java", "Scala").asJson,
        "address" -> Json.obj(
          "street" -> "Broadway".asJson,
          "house"  -> 120L.asJson
        )
      )

      jo.asJson.spaces2 shouldEqual
        """
          |{
          |  "a" : 1,
          |  "b" : "Jim",
          |  "skills" : [
          |    "Java",
          |    "Scala"
          |  ],
          |  "address" : {
          |    "street" : "Broadway",
          |    "house" : 120
          |  }
          |}
          |""".stripMargin.trim

    }

    it("automatic codec derivation") {
      Person("Jim", 33).asJson.spaces2 shouldEqual
        """
          |{
          |  "name" : "Jim",
          |  "age" : 33
          |}
          |""".stripMargin.trim
    }

    describe("fields naming") {

      it("encoder - default") {
        implicit val encoder: Encoder[Order] = deriveEncoder

        Order(33).asJson.noSpaces shouldEqual """{"orderNumber":33}"""
      }

      it("encoder - configured - snake") {

        implicit val c: Configuration = Configuration.default.withSnakeCaseMemberNames
        implicit val encoder: Encoder[Order] = deriveConfiguredEncoder

        Order(33).asJson.noSpaces shouldEqual """{"order_number":33}"""
      }

      it("encoder - configured - kebab") {
        implicit val c: Configuration = Configuration.default.withKebabCaseMemberNames
        implicit val encoder: Encoder[Order] = deriveConfiguredEncoder

        Order(33).asJson.noSpaces shouldEqual """{"order-number":33}"""
      }

    }
  }

}
