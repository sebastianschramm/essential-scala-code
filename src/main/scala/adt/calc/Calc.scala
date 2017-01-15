package adt.calc

sealed trait Calc

case class ValueExpr(element: Double) extends Calc

case class AddExpr(first: Calc, second: Calc) extends Calc

case class SubtrExpr(first:Calc, second:Calc) extends Calc

case class MultExpr(first: Calc, second: Calc) extends Calc



object Interpreter {

  def eval(expr: Calc): Double = expr match {
    case ValueExpr(element) => element
    case AddExpr(first, second) => eval(first) + eval(second)
    case SubtrExpr(first, second) => eval(first) - eval(second)
    case MultExpr(first, second) => eval(first) * eval(second)
  }

  def square(expr: Calc): Double = {
    val multExpr = MultExpr(expr, expr)
    eval(multExpr)
  }

  def pythagoras(width: Calc, height: Calc): Double = {
    val a2plusb2 = square(width) + square(height)
    Math.sqrt(a2plusb2)
  }

  def factorial(number: ValueExpr): Double = {

    def go(acc:Calc, current:Calc):Calc =
      if(eval(current) <= 1) {
        acc
      } else {
        go(MultExpr(acc, current), SubtrExpr(current,ValueExpr(1)))
      }

    eval(go(ValueExpr(1), number))
  }
}

object Main extends App {

  import Interpreter._
  // TODO:
  // - Calculate and print: 1.1 + 2.2 * 3.3
  // - Calculate and print: 1.1 * 2.2 + 3.3

  // TODO:
  // - Implement squaring a number using Calc
  // - Use your implementation to calculate 1.1 * 1.1

  // TODO:
  // - Implement pythagoras' theorem using Calc
  // - Use your implementation to calculate the hypotenuse of a 3x4 triangle

  // TODO:
  // - Implement factorials using Calc
  // - Use your implementation to calculate 10!
  println(factorial(ValueExpr(10)))
}
