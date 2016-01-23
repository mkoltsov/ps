def func(a:Int)(b:Int => Int)(c:Int => String) = c(b(a))

val df = func(100) _

println(df{_/2}{_.toString})

//Composing operators are also often called combinators because they combine elements of some domain into new elements

import Element.elem
      abstract class Element {
        def contents:  Array[String]
        def width: Int = contents(0).length
        def height: Int = contents.length
        def above(that: Element): Element = {
          val this1 = this widen that.width
          val that1 = that widen this.width
          elem(this1.contents ++ that1.contents)
}
        def beside(that: Element): Element = {
          val this1 = this heighten that.height
          val that1 = that heighten this.height
          elem(
            for ((line1, line2) <- this1.contents zip that1.contents)
            yield line1 + line2)
        }
        def widen(w: Int): Element =
          if (w <= width) this
          else {
            val left = elem(' ', (w - width) / 2, height)
            var right = elem(' ', w - width - left.width, height)
            left beside this beside right
}
        def heighten(h: Int): Element =
          if (h <= height) this
          else {
            val top = elem(' ', width, (h - height) / 2)
            var bot = elem(' ', width, h - height - top.height)
            top above this above bot
}
        override def toString = contents mkString "\n"
      }

// It is encouraged style in Scala to define methods that take no parameters and have no side effects as parameterless methods, i.e., leaving off the empty parentheses. On the other hand, you should never define a
// method that has side-effects without parentheses, because then invocations of that method would look like a field selection

class ArrayElement(cont:Array[String]) extends Element {
	def contents = cont
}

class LineElement(s:String) extends ArrayElement(Array(s)) {
	override def width = s.length
	override def height = 1
	
}

class UniformElement(
	ch:Char,
	override val height:Int,
	override val width:Int
	) extends Element {
	private val line = ch.toString * width
	val contents = Array.fill(height)(line	)
}

object Element {
  private class ArrayElement(
    val contents: Array[String]
  ) extends Element
  private class LineElement(s: String) extends Element {
    val contents = Array(s)
    override def width = s.length
    override def height = 1
}
  private class UniformElement(
    ch: Char,
    override val width: Int,
    override val height: Int
  ) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
  }
  def elem(contents:  Array[String]): Element =
    new ArrayElement(contents)
  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)
  def elem(line: String): Element =
    new LineElement(line)
}

final class Demo {
  final	private def demo1() = println("demo")
}

object Demo {
	def apply() = (new Demo).demo1()
}

val d = Demo()

import Element.elem
object Spiral {
  val space = elem(" ")
  val corner = elem("+")
  def spiral(nEdges: Int, direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
val sp = spiral(nEdges - 1, (direction + 3) % 4) 
def verticalBar = elem('|', 1, sp.height)
def horizontalBar = elem('-', sp.width, 1)
if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
else
        (verticalBar above corner) beside (space above sp)
    }
}
  def main(args: Array[String]) {
    val nSides = 6
    println(spiral(nSides, 0))
} }

