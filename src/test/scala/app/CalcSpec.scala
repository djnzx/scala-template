package app

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class CalcSpec extends AnyFunSpec with Matchers {

  describe("calc module") {

    it("should add") {
      Calc.add(1, 2) shouldEqual 3
    }

  }

}
