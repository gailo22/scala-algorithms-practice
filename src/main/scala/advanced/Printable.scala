package advanced

trait Printable[A] {
  def format(input: A): String
}

object PrintableInstances {
  implicit val stringPrintable = new Printable[String] {
    def format(input: String) = input
  }

  implicit val intPrintable = new Printable[Int] {
    def format(input: Int) = input.toString
  }
}

object Printable {
  def format[A](input: A)(implicit p: Printable[A]): String =
    p.format(input)

  def print[A](input: A)(implicit p: Printable[A]): Unit =
    println(format(input))
}

object PrintableSyntax {
  implicit class PrintOps[A](value: A) {
    def format(implicit p: Printable[A]): String =
      p.format(value)
    def print(implicit p: Printable[A]): Unit =
      println(p.format(value))
  }
}

object PrintableExample extends App {

  final case class Cat(name: String, age: Int, color: String)

  import PrintableInstances._
  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name = Printable.format(cat.name)
      val age = Printable.format(cat.age)
      val color = Printable.format(cat.color)
      s"$name is a $age year-old $color cat."
    }
  }

  val cat = Cat("Garfield", 35, "ginger and black")
  Printable.print(cat)

  import PrintableSyntax._
  cat.print

}