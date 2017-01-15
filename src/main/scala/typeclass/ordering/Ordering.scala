package typeclass.ordering

final case class Email(address: String)
final case class Person(name: String, email: Email)

object OrderingImplicits {
  import scala.math.Ordering

  implicit val emailOrdering: Ordering[Email] =
    new Ordering[Email] {
      def compare(x: Email, y: Email): Int =
        if(x.address < y.address) -1
        else if(x.address > y.address) +1
        else 0
    }

  implicit val personOrdering: Ordering[Person] =
    new Ordering[Person] {
      override def compare(x: Person, y: Person): Int =
        if(x.name < y.name) -1
        else if(x.name > y.name) +1
        else 0
    }

  val personOrderingByEmail: Ordering[Person] =
    new Ordering[Person] {
      override def compare(x: Person, y: Person) =
        emailOrdering.compare(x.email,y.email)
    }
}

object Main extends App {
  import OrderingImplicits._

  val email1 = Email("alice@cool.com")
  val email2 = Email("charlie@excellent.com")
  val email3 = Email("bob@awesome.com")
  val emails = List(email1, email2, email3)

  val person1 = Person("Alice",   Email("alice@cool.com"))
  val person2 = Person("Charlie", Email("charlie@excellent.com"))
  val person3 = Person("Bob",     Email("bob@awesome.com"))
  val people = List(person1, person2, person3)

  println("""emailOrdering.compare(email1, email2)    == """ + emailOrdering.compare(email1, email2))
  println("""personOrdering.compare(person1, person2) == """ + personOrdering.compare(person1, person2))

  println("""emails.sorted == """ + emails.sorted)
  println("""people.sorted == """ + people.sorted)
}
