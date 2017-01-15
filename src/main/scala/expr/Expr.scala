package expr

object Expr {

  def palindrome(word: String): Boolean = if (word.reverse == word) true else false

  def greet(name: String): String = s"Hello $name"

  def factorial(num: Int): Int = {
    if (num == 1) {
      num
    } else {
      num * factorial(num - 1)
    }
  }
}

object Main extends App {

  import Expr._

  println( """palindrome("taco") == """ + palindrome("taco"))
  println( """greet("Earthlings") == """ + greet("Earthlings"))
  println( """factorial(10) == """ + factorial(10))
}
