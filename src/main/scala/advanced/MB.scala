package advanced

sealed trait MB[A] {
  def hello: A
}

object MB {

  implicit val MBString = new MB[String] {
    def hello: String = "Hello, world"
  }

  def apply[A](implicit mb: MB[A]): MB[A] = mb
}

//MB[String].hello // "Hello, world"
