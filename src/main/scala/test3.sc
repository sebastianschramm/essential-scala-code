case class Person(firstName: String, lastName: String, a: Tuple2[String, Int])


val seb = Person("Sebastian", "Schramm", ("sad", 1))
val se = Person("Sebas", "Schramm", ("sad", 1))
val s = Person("John", "John", ("a", 2))
val st = Person("Marry", "John", ("a", 2))
val b = Person("Martin", "Odersky", ("d", 5))
val ab = Person("Martin", "", ("d", 5))


seb.firstName
s.lastName
seb.toString

seb == b
seb == s
seb == seb


seb.copy(firstName = "Sebastian", lastName = "sch").a

for {attribute <- seb.productIterator } println(attribute)


def saveToDb(person: Person) = println(s"saving $person")


//pattern matching
def spaceship(person: Person) = person match{
  case p @ Person(fn @ firstName, ln @ "Schramm", ("sad", 1)) =>
    saveToDb(p)
    println(fn)
    println(ln)
    s"Hallo $firstName"
  case Person(_, "John", _) => "OK"
  case Person(_, lastName, _) if lastName.isEmpty => "too bad"
  case _ =>
    "Whaaaat?"
}


spaceship(seb)
spaceship(s)
spaceship(st)
spaceship(b)
spaceship(ab)
spaceship(se)
spaceship(Person("","",("",0)))




