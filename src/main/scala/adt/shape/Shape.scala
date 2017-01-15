package adt.shape

final case class Color(r: Double, g: Double, b: Double)

sealed trait Shape

final case class Circle(radius: Int, color: Color) extends Shape

final case class Rect(width: Int, height: Int, color: Color) extends Shape

object Main extends App {
  val shape1 = Circle(10, Color(1, 0, 0))
  val shape2 = Rect(3, 5, Color(0, 1, 0))

  def area(shape: Shape): Double =
    shape match {
      case Circle(radius, color) => radius * radius * Math.PI
      case Rect(width,height,_) => width * height
    }

  println(shape1 + " " + area(shape1))
  println(shape2 + " " + area(shape2))
}
