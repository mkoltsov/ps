 class Queue[T](
    private val leading: List[T],
    private val trailing: List[T]
){
private def mirror =
      if (leading.isEmpty)
        new Queue(trailing.reverse, Nil)
else this
    def head = mirror.leading.head
    def tail = {
      val q = mirror
      new Queue(q.leading.tail, q.trailing)
}
    def enqueue(x: T) =
      new Queue(leading, x :: trailing)
    override def toString = s"$leading::$trailing"
}

class HiddenQueue[T] private (
          private val leading: List[T],
          private val trailing: List[T]) {
  def this() = this(Nil, Nil)
  def this(elems:T*) = this(elems.toList, Nil)
}

val y = new HiddenQueue
val z = new HiddenQueue(List(1,3,4,5))

class HiddenQueue2[T] private(private val leading: List[T],
          private val trailing: List[T])

object HiddenQueue2 {
  def apply[T](elems:T*) = new HiddenQueue2(elems.toList, Nil)
}           

val xy = HiddenQueue2(List("chef","pupa"))
val x = new Queue(List(1,3,4), Nil)

println(x.enqueue(8))