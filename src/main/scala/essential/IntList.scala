package essential

sealed trait IntList
final case object End1 extends IntList
final case class Pair1(head: Int, tail: IntList) extends IntList


object IntList {

    def sum(list: IntList): Int =
        list match {
            case End1 => 0 
            case Pair1(hd, tl) => hd + sum(tl)
        }

}
