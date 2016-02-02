 // def map[U](f: T => U): List[U] =
 //          if (isEmpty) Nil
 //          else f(head) :: tail.map(f)

  def incAll(xs: List[Int]): List[Int] = xs match {
    case List() => List()
    case x :: xs1 => x + 1 :: incAll(xs1)
}

var result = List[Int]()    // a very inefficient approach
        for (x <- xs) result = result ::: List(x + 1)
        result

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]
        for (x <- xs) buf += x + 1
        buf.toList

final override def map[U](f: T => U): List[U] = {
  val b = new ListBuffer[U]
  var these = this
  while (!these.isEmpty) {
    b += f(these.head)
    these = these.tail
  }
b.toList }