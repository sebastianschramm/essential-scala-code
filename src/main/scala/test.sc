import typeclass.json.Person

object Calc {
  def square(a: Double): Double =  a*a

  def sq2(b: Double): Double = Math.pow(b, 2)

  def abs(input: Double): Double = if(input <= 0){
    -input
  } else {
    input
  }

  def fibonacci(n: Int): Int = {
    def go(counter: Int, current: Int, previous: Int): Int =
      if(counter <= 1){
        current
      } else {
        go(counter -1, current + previous, current)
      }

    go(n, 1, 1)

  }

}


Calc.fibonacci(5)




class Person (val first_name: String = "E", val last_name: String = "R") {
  //val first_name = "Sebastian"
  //val last_name = "Schramm"
  //import Person.age
  val json =
    """{"a": 1,
      | "b": 2}""".stripMargin

  def name = s"$first_name || $last_name"  //String interpolation

  def age: Int = Person.age

  //def name: String = first_name + " " +  last_name

  override def toString: String = last_name
}


object Person {
  val age = 20
}

val ses = new Person


Person.age

ses.name

ses.first_name
ses.last_name
ses.age



object alien {
  def greet(person: Person): String = {
    s"Hello ${person.first_name} ${person.last_name}"
  }
}

alien.greet(ses)


/*final case*/ class Film(
                           val name: String,
                           val yearOfRelease: Int,
                           val imdbRating: Double
                         ) {


  def copy(name: String=name, yearOfRelease:  Int = yearOfRelease, imdbRating: Double = imdbRating): Film = {
    new Film(name, yearOfRelease, imdbRating)
  }
}

val s = new Film(name="Seb", yearOfRelease = 1992, imdbRating = 9.0)
s.name
s.yearOfRelease
s.imdbRating

val d = s.copy(imdbRating = 1.2)
d.name
d.yearOfRelease
d.imdbRating


class Counter(val count: Int) {

  def inc: Counter =  new Counter(count + 1)
  def red: Counter =  new Counter(count - 1)
}

val c = new Counter(10)

c.red.count
c.inc.red.red.red.count
