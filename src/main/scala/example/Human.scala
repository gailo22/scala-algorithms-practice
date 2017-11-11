package example

trait Human {
    val name: String
    def say(msg: String) = println(s"$msg, $name")
}

class Person(val name: String) extends Human

class Dog(val name: String)

object Main {
    val john = new Person("John")
    val buddy = new Dog("Buddy") with Human
}