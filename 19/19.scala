 class Queue[+T](
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
    def enqueue[U>: T](x: U) =
      new Queue[U](leading, x :: trailing)
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

trait Queue1[T] {
  def head: T
  def tail: Queue1[T]
  def enqueue(x: T): Queue1[T]
}
object Queue1 {
  def apply[T](xs: T*): Queue1[T] =
    new QueueImpl[T](xs.toList, Nil)
  private class QueueImpl[T](
    private val leading: List[T],
    private val trailing: List[T]
  ) extends Queue1[T] {
    def mirror =
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
this
    def head: T = mirror.leading.head
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
}
    def enqueue(x: T) =
      new QueueImpl(leading, x :: trailing)
} }

val f = Queue1(List(1,2,3))

def doesCompile(d:Queue1[AnyRef]) = println(d)

//doesCompile(f)
// The new definition gives enqueue a type parameter U, and with the syntax, “U >: T”,
 // defines T as the lower bound for U. As a result, U is required to be a supertype of T
class Cell[T](init: T) {
    private[this] var current = init
    def get = current
    def set(x: T) { current = x }
}

trait OutputChannel[-T] {
  def write(x:T)
}

class SomeChannel[U] extends OutputChannel[U] {
  def write(x:U) = println(x)
}

val fg = new SomeChannel[AnyRef]

fg.write("fdf")
fg.write(new Object)
// fg.write(new Object)

class Person(val firstName: String, val lastName: String)
            extends Ordered[Person] {
          def compare(that: Person) = {
            val lastNameComparison =
              lastName.compareToIgnoreCase(that.lastName)
            if (lastNameComparison != 0)
              lastNameComparison
else
              firstName.compareToIgnoreCase(that.firstName)
          }
          override def toString = firstName +" "+ lastName
        }
// With the “T <: Ordered[T]” syntax, you indicate that the type parameter, T, has an upper bound, Ordered[T].
// This means that the element type of the list passed to orderedMergeSort must be a subtype of Ordered
def orderedMergeSort[T <: Ordered[T]](xs: List[T]): List[T] = {
        def merge(xs: List[T], ys: List[T]): List[T] =
          (xs, ys) match {
            case (Nil, _) => ys
            case (_, Nil) => xs
            case (x :: xs1, y :: ys1) =>
              if (x < y) x :: merge(xs1, ys)
              else y :: merge(xs, ys1)
          }
        val n = xs.length / 2
        if (n == 0) xs
        else {
          val (ys, zs) = xs splitAt n
          merge(orderedMergeSort(ys), orderedMergeSort(zs))
        }
}

val people = List(
                 new Person("Larry", "Wall"),
                 new Person("Anders", "Hejlsberg"),
                 new Person("Guido", "van Rossum"),
                 new Person("Alan", "Kay"),
                 new Person("Yukihiro", "Matsumoto")
)

println(orderedMergeSort(people))        