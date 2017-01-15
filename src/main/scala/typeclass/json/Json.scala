package typeclass.json

final case class Email(address: String)
final case class Person(name: String, email: Email)

sealed trait JsValue
case object JsNull extends JsValue
final case class JsString(value: String) extends JsValue
final case class JsNumber(value: Double) extends JsValue
final case class JsBoolean(value: Boolean) extends JsValue
final case class JsArray(values: Seq[JsValue]) extends JsValue
final case class JsObject(values: Seq[(String, JsValue)]) extends JsValue

trait JsonWriter[A] {
  def write(value: A): JsValue
}

object JsonImplicits {
  def jsonify[A](value: A)(implicit writer: JsonWriter[A]): JsValue =
    writer.write(value)

  implicit val intWriter: JsonWriter[Int] =
    new JsonWriter[Int] {
      def write(value: Int): JsValue =
        JsNumber(value)
    }

  implicit val stringWriter: JsonWriter[String] =
    new JsonWriter[String] {
      def write(value: String): JsValue =
        JsString(value)
    }

  implicit val emailWriter: JsonWriter[Email] =
    new JsonWriter[Email] {
      override def write(email: Email) =
        JsString(email.address)
    }

  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      override def write(email: Person) = JsObject(
       List(
         "name" -> jsonify(email.name),
         "email" -> jsonify(email.email)
       )
      )
    }

  def listWriter[A](writer: JsonWriter[A]): JsonWriter[List[A]] =
    new JsonWriter[List[A]] {
      override def write(elements: List[A]) = JsArray(
        elements.map(writer.write)
      )
    }

  implicit val emailsWriter: JsonWriter[List[Email]] = listWriter(emailWriter)
  implicit val personsWriter: JsonWriter[List[Person]] = listWriter(personWriter)
}

object Main extends App {
  import JsonImplicits._

  val email1 = Email("alice@cool.com")
  val email2 = Email("charlie@excellent.com")
  val email3 = Email("bob@awesome.com")
  val emails = List(email1, email2, email3)

  val person1 = Person("Alice",   Email("alice@cool.com"))
  val person2 = Person("Charlie", Email("charlie@excellent.com"))
  val person3 = Person("Bob",     Email("bob@awesome.com"))
  val people = List(person1, person2, person3)

  println("""jsonify(email1)  == """ + jsonify(email1))
  println("""jsonify(email2)  == """ + jsonify(email2))
  println("""jsonify(email3)  == """ + jsonify(email3))

  println("""jsonify(person1) == """ + jsonify(person1))
  println("""jsonify(person2) == """ + jsonify(person2))
  println("""jsonify(person3) == """ + jsonify(person3))

  println("""jsonify(emails)  == """ + jsonify(emails))
  println("""jsonify(people)  == """ + jsonify(people))
}
