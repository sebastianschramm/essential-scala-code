package generic.mylist

sealed trait MyOption[A] {

  def map[B](fn: A => B):MyOption[B] = this match {
    case MySome(value) => MySome(fn(value))
    case MyNone() => MyNone()
  }

  def flatMap[B](fn: A => MyOption[B]):MyOption[B] = this match {
    case MySome(value) => fn(value)
    case MyNone() => MyNone()
  }
}
case class MySome[A](value:A) extends MyOption[A]
case class MyNone[A]() extends MyOption[A]

sealed trait MyList[A] {

  def exists(fn: A => Boolean): Boolean = this match {
    case MyPair(head, tail) => if (fn(head)) true else tail.exists(fn)
    case MyNil() => false
  }

  def filter(fn: A => Boolean): MyList[A] = this match {
    case MyPair(head, tail) => if (fn(head)) MyPair(head, tail.filter(fn)) else tail.filter(fn)
    case MyNil() => MyNil()
  }

  def find(fn: A => Boolean): MyOption[A] = this match {
    case MyPair(head, tail) => if (fn(head)) MySome(head) else tail.find(fn)
    case MyNil() => MyNone()
  }

  def map[B](fn: A => B): MyList[B] = this match {
    case MyPair(head, tail) => MyPair(fn(head), tail.map(fn))
    case MyNil() => MyNil()
  }

  def concat(other: MyList[A]): MyList[A] = this match {
    case MyPair(head, tail) => MyPair(head, tail.concat(other))
    case MyNil() => other
  }

  def flatten: MyList[Any] = flatMap {
    case ms: MyList[_] => ms.flatten
    case e => MyPair(e, MyNil())
  }

  def flatMap[B](fn: A => MyList[B]): MyList[B] = this match {
    case MyPair(head, tail) => fn(head).concat(tail.flatMap(fn))
    case _ => MyNil()
  }

  def foldLeft(init:A)(fn : (A,A) => A):A = this match {
    case MyNil() => init
    case MyPair(head, tail) => tail.foldLeft(fn(init,head))(fn)
  }

  def foldRight(init:A)(fn : (A,A) => A):A = this match {
    case MyNil() => init
    case MyPair(head, tail) => fn(head, tail.foldRight(init)(fn))
  }
}

case class MyPair[A](head: A, tail: MyList[A]) extends MyList[A]

case class MyNil[A]() extends MyList[A]


object Main extends App {
  val ints = MyPair(1, MyPair(3, MyPair(5, MyNil())))
  val strs = MyPair("foo", MyPair("bar", MyPair("baz", MyNil())))

  println(ints + """.exists(_ > 1)         == """ + ints.exists(_ > 1))
  println(ints + """.filter(_ > 1)         == """ + ints.filter(_ > 1))
  println(ints + """.find(_ > 1)           == """ + ints.find(_ > 1))

  println(strs + """.exists(_(0) == 'b')   == """ + strs.exists(_ (0) == 'b'))
  println(strs + """.filter(_(0) == 'b')   == """ + strs.filter(_ (0) == 'b'))
  println(strs + """.find(_(0) == 'b')     == """ + strs.find(_ (0) == 'b'))


  def add(ints: MyList[Int], num: Int): MyList[Int] =
    MyPair(num, ints)

  println( """add(""" + ints + """, 1))     == """ + add(ints, 1))
  println(strs + """.map(_ + "!"))         == """ + strs.map(_ + "!"))

  def processInt(x: Int): MyList[Int] =
    MyPair(x, MyPair(x * 10, MyNil()))

  def processStr(x: String): MyList[String] =
    MyPair(x, MyPair(x + "!", MyNil()))

  println(ints + """.flatMap(processInt)   == """ + ints.flatMap(processInt))
  println(strs + """.flatMap(processStr)   == """ + strs.flatMap(processStr))

  println(ints + """.foldLeft(0)(_ + _))   == """ + ints.foldLeft(0)(_ + _))
  println(ints + """.foldRight(0)(_ + _))  == """ + ints.foldRight(0)(_ + _))

  println(strs + """.foldLeft("")(_ + _))  == """ + strs.foldLeft("")(_ + _))
  println(strs + """.foldRight("")(_ + _)) == """ + strs.foldRight("")(_ + _))
}
