package app

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class PropertyBasedSpec extends AnyFunSpec with Matchers with ScalaCheckPropertyChecks {

  describe("property based") {

    it("empty element addition") {
      forAll { (n: Int) =>
        n + 0 shouldEqual n
      }
    }

    it("associativity") {
      forAll { (n1: Int, n2: Int) =>
        n1 + n2 shouldEqual n2 + n1
      }
    }

  }

}
