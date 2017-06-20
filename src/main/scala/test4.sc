//interface
trait Name {
  def name: String

}

trait Age {
  def age: Int = 14
}

trait Gender {
  def gender: String = "bird"
}

class Person(override val name:String)

  extends Name
    with Age
    with Gender
{
  //override def name: String = "sadasd"
  //override def age: Int = super.age
}


val s: Name with Age with Gender = new Person(name="Blu")
s.name
s.age
s.gender


sealed trait Shape {
  def area: Double
  def perimeter: Double
  val sides: Int
}

class Rectangle(a: Double, b: Double)
  extends Shape
{
  override def area: Double = a*b
  override def perimeter: Double = 2 * (a+b)
  override val sides: Int = 4

}

val rechteck = new Rectangle(a=2, b=2)
rechteck.area
rechteck.perimeter
rechteck.sides

class Triangle(a: Double, b: Double)
  extends Shape
{
  override def area: Double = (a * b)/2
  override def perimeter: Double = a + b + Math.sqrt(a*a + b*b)
  override val sides: Int = 3

}

val t1 = new Triangle(a=1, b=2)
t1.sides
t1.area
t1.perimeter

class Circle(r: Double)
  extends Shape
{
  override def area: Double = Math.PI*r*r
  override def perimeter: Double = 2*r*Math.PI
  override val sides: Int = 1

}

val c1 = new Circle(r=1)
c1.sides
c1.area
c1.perimeter


// is a -> sealed trait
// has a -> class