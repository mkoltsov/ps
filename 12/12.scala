case class Rational(val a:Int, val b:Int) extends Ordered[Rational] {
	def compare(that:Rational) = (this.a * that.b) - (that.a * this.b)
}

val r1 = Rational(1,3)
val r3 = Rational(1,3)
val r2 = Rational(3,2)

println(r1>r2)
println(r1 == r2)
println(r1 == r3)

abstract class IntQueue {
	def get():Int
	def put(x:Int)
}

import scala.collection.mutable.ArrayBuffer
        class BasicIntQueue extends IntQueue {
          private val buf = new ArrayBuffer[Int]
          def get() = buf.remove(0)
          def put(x: Int) { buf += x }
}

trait Doubling extends IntQueue {
	abstract override def put(x:Int) = super.put(x*2) 
}

val d = new BasicIntQueue with Doubling

println(d.put(10))
println(d.get())

trait Incrementing extends IntQueue {
		abstract override def put(x:Int) = super.put(x+1) 
}

trait Filtering extends IntQueue {
		abstract override def put(x:Int) = if (x>0) super.put(x) 
}

val queue = new BasicIntQueue with Filtering with Incrementing with Doubling

queue.put(10)
println(queue.get())