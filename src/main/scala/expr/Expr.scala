package expr

import scala.annotation.tailrec

object Expr {

  // TODO: Implement methods

  // Advanced: recursion, fibonacci, nested

  def fibonacci(n:Int, prev:Int, cur:Int):Int = ???

  def palindrome(input: String): Boolean = if(input.toLowerCase.reverse == input.toLowerCase) {true} else {false}

  //@tailrec
  def factorial(input:Int): Int = if(input == 0){1} else {input * factorial(input - 1)}

}

object Main extends App {
  import Expr._

  // Variables, Standard Types, Inference, Vars, lazy, OOP
  val x = 5

  val tuple2 = "Jan" -> 33

  //val tuple3 = ("Jan", "Scala", 33)

  //val (name, email) = tuple2

  //tuple2._1
  //tuple2._2

  // println("""palindrome("taco") == """ + palindrome("taco"))
  // println("""greet("Earthlings") == """ + greet("Earthlings"))
  // println("""factorial(10) == """ + factorial(10))
}
