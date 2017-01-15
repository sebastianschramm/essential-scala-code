package typeclass.times

object TimesImplicits {

  implicit class TimesInt(number:Int) {
    def times[A](fn : Int => A):List[A] = (for { i <- 1 to number } yield fn(i)).toList
  }
}

object Main extends App {
  import TimesImplicits._

  println("""5.times(_ * 10)  == """ + 5.times(_ * 10))
  println("""3.times(_ + "!") == """ + 3.times(_ + "!"))
}
