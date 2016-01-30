import scala.language.implicitConversions

implicit def stringToInt(x:String) = Integer.parseInt(x)

println(5 - "3")

implicit val f = "Chef"

def chef(implicit x:String) = println(x)

chef

class Chef {
	println(5 - "3")
}

object Chef{
	implicit def stringToInt(x:String) = Integer.parseInt(x)
}


// Marking Rule: Only definitions marked implicit are available.

//Scope Rule: An inserted implicit conversion must be in scope as a single identifier,
// or be associated with the source or target type of the conver- sion.

// One-at-a-time Rule: Only one implicit is tried.

// Explicits-First Rule: Whenever code type checks as it is written, no implicits are attempted.

// Naming an implicit conversion.
object MyConversions {
          implicit def stringWrapper(s: String):
              IndexedSeq[Char] = ???
          implicit def intToString(x: Int): String = ???
}

import MyConversions.stringWrapper

implicit def doubleToInt(x:Double) = x.toInt

val i:Int = 3.4



// println(doSomething(5)) 