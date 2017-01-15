package expr

import org.scalatest._

class ExprSpec extends FlatSpec with Matchers {
  import Expr._

  "tacocat" should "be a palindrome" in {
    palindrome("tacocat") should equal(true)
  }

  "tacobell" should "NOT be a palindrome" in {
    palindrome("tacobell") should equal(false)
  }

  "factorial" should "multiply some numbers and stuff" in {  
    factorial(5) should equal (5 * 4 * 3 * 2 * 1)
  }
}
