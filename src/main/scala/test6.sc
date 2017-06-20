import scala.util.{Failure, Success, Try}

//sealed trait Result

//case class Success(value: Double) extends Result
//case class Failure(error_msg: String) extends Result

/*
def division(x: Double, y: Double): Result = y match {
  case 0 => Failure("Zero Division")
  case _ => Success(x/y)
}
*/


//division(1,2)
//division(0,2)
//division(9,0)


def division(x: Double, y: Double): Try[Double] = y match {
  case 0 => Failure(new Error("Zero Division"))
  case _ => Success(x/y)
}