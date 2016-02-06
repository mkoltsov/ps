val li = List(1,2,3,4)
val l = li.partition(_<3)

println(l)

println(li.flatMap{case 3 => "!"; case _ => ""})
println(li.map{case 3 => "!"; case _ => ""})

val se = Seq(1,2,3,4)

println(se.lengthCompare(2))

var s1 = Set(1, 2, 3)
// val s1 = collection.mutable.Set(1, 2, 3)

val myOrdering = Ordering.fromLessThan[String](_ > _)

import scala.collection.immutable.TreeSet
TreeSet.empty(myOrdering)

//default ordering
val treeseet = TreeSet.empty[String]

val s = treeseet+("one","two","three","four")

println(s)
println(s range ("one", "two"))
println(s from "three")

val pair = 1->"one"

def f(x: String) = {
               println("taking my time."); Thread.sleep(100)
               x.reverse }

val cache = collection.mutable.Map[String, String]()


def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))

 cachedF("abc")

 cachedF("abc")
import scala.collection.mutable.{SynchronizedMap, HashMap}
 val syncMap = new HashMap[String, String] with SynchronizedMap[String, String]()

import scala.collection.mutable.{Map,
            SynchronizedMap, HashMap}
        object MapMaker {
          def makeMap: Map[String, String] = {
              new HashMap[String, String] with
                  SynchronizedMap[String, String] {
                override def default(key: String) =
                  "Why do you want to know?"
} }
}

val capital = MapMaker.makeMap

capital ++= List("US" -> "Washington",
              "France" -> "Paris", "Japan" -> "Tokyo")

println(capital("Japan"))
println(capital("Australia"))

val str = 1 #:: 2 #:: 3 #:: Stream.empty

def fibFrom(a: Int, b: Int): Stream[Int] =
                 a #:: fibFrom(b, a + b)
val fibs = fibFrom(1, 1).take(7)

println(fibs.toList)

val vec = scala.collection.immutable.Vector.empty

val vec2 = vec :+ 1 :+ 2

val vec3 = 100 +: vec2

println(vec3(0))

println(5 to 14 by 3)

val map = collection.immutable.ListMap(
                 1 -> "one", 2 -> "two")

val buf = new StringBuilder

buf += 'a'

buf ++= "bcdef"

println(List(1, 2, 3) == Vector(1, 2, 3))
// println(HashSet(1, 2) == TreeSet(2, 1))

 def lazyMap[T, U](coll: Iterable[T], f: T => U) =
          new Iterable[U] {
            def iterator = coll.iterator map f
          }

val v = Vector(1 to 10: _*)

println(v map (_ + 1) map (_ * 2))    

println((v.view map (_ + 1) map (_ * 2)).force)      
val vv = v.view map (_ + 1) map (_ * 2)

println(vv)
println(vv.force)

val seque = Seq(1,2,3,4,5)

println(seque take 2)

val arr = (0 to 9).toArray	

val subarr = arr.view.slice(3, 6)

def negate(xs: collection.mutable.Seq[Int]) = for (i <- 0 until xs.length) xs(i) = -xs(i)

negate(subarr)

println(arr)

val it = Iterator("a", "number", "of", "words")
it.map(_.length) foreach println

val it1 = Iterator("a", "number", "of", "words")
             
println(it1 dropWhile (_.length < 2) next)
val (it1, it2) = it.duplicate
Traversable()
List()
List(1.0, 2.0)
Vector(1.0, 2.0)
Iterator(1, 2, 3)
Set(dog, cat, bird)
HashSet(dog, cat, bird)
Map('a' -> 7, 'b' -> 0)
// An empty traversable object
// The empty list
// A list with elements 1.0, 2.0
// A vector with elements 1.0, 2.0
// An iterator returning three integers.
// A set of three animals
// A hash set of the same animals
// A map from characters to integers