package fn.firstorder

object FirstOrder {
  val sumSquares : (Int,Int) => Int = (a,b) => a * a + b * b

  val longer = (a:String,b:String) => if(a.length > b.length) a else b

  val factorial: Int => Int = acc => if(acc == 1) {
    acc
  } else {
    acc * factorial(acc - 1)
  }
}

object Main extends App {
  import FirstOrder._

  println("""sumSquares(3, 4) == """ + sumSquares(3, 4))
  println("""longer("fooo", "bar") == """ + longer("fooo", "bar"))
  println("""factorial(5) == """ + factorial(5))
}
