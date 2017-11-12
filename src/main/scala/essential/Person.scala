package essential

case class Person(firstName: String, lastName: String) {
    def name = firstName + " " + lastName
}

object Stormtrooper {
    def inspect(person: Person): String =
        person match {
            case Person("Luke", "Skywalker") => "Stop, rebel scum"
            case Person("Han", "Solo") => "Stop, rebel sum"
            case Person(fist, last) => s"Move along $fist"
        }
}