package adt.color

//final case class Color(r: Double, g: Double, b: Double)  // final makes it not extendable
case class Color(r: Double, g: Double, b: Double) {
  def lightness: Double = (r + g + b) / 3

  def lighterThan(color2: Color): Boolean = {
    if (lightness > color2.lightness) true
    else false
  }
}


object Main extends App {
  val color1 = Color(1.0, 0.5, 0.0)
  val color2 = Color(0.6, 0.7, 0.8)

  def mostlyRed(color: Color): Boolean = color match {
    case Color(r,g,b) => r > g && r<g
    //case Color(1,_,_) =>
    //case Color(0,_,_) => false
  }

  println("color1 " + color1)
  println("color2 " + color2)

  println("Lightness of color1 " + color1.lightness)
  println("Lightness of color2 " + color2.lightness)

  println("Is color1 mostly red? " + mostlyRed(color1))
  println("Is color2 mostly red? " + mostlyRed(color2))
}
