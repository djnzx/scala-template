package app

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CalcSpec extends AnyFunSpec with Matchers {

  describe("calc module") {

    it("should add") {
      Calc.add(1, 2) shouldEqual 3
    }

    it("should throw an exception") {
      an[ArithmeticException] shouldBe thrownBy {
        Calc.div(5, 0)
      }
    }

    it("should throw an exception with proper getMessage text") {
      (the[ArithmeticException] thrownBy {
        Calc.div(5, 0)
      }).getMessage should include ("/ by zero")
    }

    it("should throw an exception with proper field getMessage") {
      (the[ArithmeticException] thrownBy {
        Calc.div(5, 0)
      }) should have message("/ by zero")
    }

  }

}
