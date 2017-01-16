

class Person(val name: String, age: Int, val phone: String = "") {


  def this(name: String) = this(name, age = 31)

  val greeting: String = "Hi there!"

  def getAge = age

  def greet: String = {
    s"$greeting, I'm $name and I'm $age years old."
  }


  def older(other: Person): Boolean = {
    if (other.getAge < age) {
      true
    } else {
      false
    }
  }
}


val jan = new Person(name = "jan", age = 33)

jan.name

jan.greet

jan.greeting

val hans = new Person("hans", 23)
jan.older(hans)


object Person {

  def apply(name: String, age: Int) = new Person(name, age)

  def apply(name: String) = new Person(name, age = 31)
}


val someone = Person(name = "Someone", age = 27)

val sometwo = Person(name = "Sometwo")

// traits named