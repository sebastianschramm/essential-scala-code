class Adder(amount: Int) {

  def add(in: Int): Int = in + amount

  def apply(in: Int): Int = in + amount

  def apply(in1: Int, in2: Int): Int = in1 + in2 + amount
}

val incr = new Adder(1)

incr.add(10)
incr(6)

incr(2,3)


class Ad[E](amount: E) {

    def add: E = amount
}

val d = new Ad[Int](10)

d.add


class Timestamp private(val seconds:Long)
/*
{
  def this(hours:Int, minutes:Int, seconds:Int) =
    this(hours*60*60 + minutes*60 + seconds)
}
*/


object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp = {
    new Timestamp(60*(hours*60 + minutes) + seconds)
  }

  def apply(seconds: Int): Timestamp = {new Timestamp(seconds=seconds)}
}


val ts = Timestamp(1,1,1)
//val ts2 = new Timestamp(1,1,1)

val ts_seconds_only = Timestamp(1)

ts_seconds_only.toString

ts.seconds


class Person(val first_name: String, val last_name: String)

object Person
{

  def apply(name: String): Person = {
    val name_array = name.split(" ")
    val fn = name_array(0)
    new Person(first_name=fn, last_name=name_array(1))
  }
 }

//inlining Strg + Alt + n
//extraction


val ses = Person("Sebastian Schramm")

ses.first_name
ses.last_name

