/*sealed trait UserType {
  val isLoggedIn: Boolean
}

case object Anonymous extends UserType {
  override val isLoggedIn: Boolean = false
}

case class LoggedInUser(name: String, email: String)
  extends UserType
{
  override val isLoggedIn: Boolean = true
}


val a = Anonymous
a.isLoggedIn

val user1 = LoggedInUser(name="Sebastian", email="ses@gmail.com")
user1.name
user1.email
user1.isLoggedIn*/



sealed trait UserType {
  val isLoggedIn:Boolean = this match {
    case Anonymous => false
    case LoggedInUser(_,_) => true
  }
}

case object Anonymous extends UserType
case class LoggedInUser(name: String, email: String) extends UserType
