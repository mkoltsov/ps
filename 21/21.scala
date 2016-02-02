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

case class MyWrapper(name:String){
	def doSomething() = println(s"$name did something")
}

val wr = MyWrapper("wrap")

implicit class WrapperImprovements(s: MyWrapper) {
    def didSomething() = println("did")
}

// Restrictions
// ImplicRestrictions
// Implicit classes have the following restrictions:

// 1. They must be defined inside of another trait/class/object.


// 2. They may only take one non-implicit argument in their constructor.


// 3. There may not be any method, member or object in scope with the same name as the implicit class.it classes have the following restrictions:

wr.doSomething()

wr.didSomething()

 object Predef1 {
          class ArrowAssoc(x: Int) {
            def -+ (y: Int): Tuple2[Int, Int] = Tuple2(x, y)
          }
          implicit def any2ArrowAssoc(x: Int): ArrowAssoc =
            new ArrowAssoc(x)
}

import Predef1._

val a = 10 -+ 10

println(a)

wr.doSomething()

wr.didSomething()

// type Param = String

// implicit val pi:Param = "31337"
implicit val pInt = 31337

case class Worker(implicit par:Int) {
	def doSomething() = println(par)
	def greet(implicit a:String) = println(s"got an implicit value here, equal to $a")
}



val fa = new Worker


fa.doSomething()
fa.greet

class PreferredPrompt(val preference: String)
      class PreferredDrink(val preference: String)
      object Greeter {
        def greet(name: String)(implicit prompt: PreferredPrompt,
            drink: PreferredDrink) {
          println("Welcome, "+ name +". The system is ready.")
          print("But while you work, ")
          println("why not enjoy a cup of "+ drink.preference +"?")
          println(prompt.preference)
		} 
}
      object JoesPrefs {
        implicit val prompt = new PreferredPrompt("Yes, master> ")
        implicit val drink = new PreferredDrink("tea")
	  }

import JoesPrefs._

Greeter.greet("Joe")(prompt, drink)
Greeter.greet("Joe")

def maxListImpParm[T](elements: List[T])
              (implicit orderer: T => Ordered[T]): T =
          elements match {
            case List() =>
              throw new IllegalArgumentException("empty list!")
            case List(x) => x
            case x :: rest =>
              // val maxRest = maxListImpParm(rest)(orderer)
               val maxRest = maxListImpParm(rest)
              // if (orderer(x) > maxRest) x
              if (x > maxRest) x
              else maxRest
}

println(maxListImpParm(List(1,5,10,3)))

println(maxListImpParm(List(1.5, 5.2, 10.7, 3.14159)))

println(maxListImpParm(List("one", "two", "three")))

// A style rule for implicit parameters As a style rule, it is best to use a custom named type in the types of implicit parameters.
// println(doSomething(5)) 

def maxList[T <% Ordered[T]](elements: List[T]): T = elements match {
      case List() =>
        throw new IllegalArgumentException("empty list!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxList(rest)  // (orderer) is implicit
        if (x > maxRest) x           // orderer(x) is implicit
        else maxRest
}

// To be more precise, one implicit conversion is more specific than another if one of the following applies:
// • The argument type of the former is a subtype of the latter’s.
// • Both conversions are methods, and the enclosing class of the former extends the enclosing class of the latter.

// The -Xprint:typer option to the compiler is useful for this.