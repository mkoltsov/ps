	val greeting = new Array[String](3)

	greeting(0)="Chef"
	greeting(1)="Papa"
	greeting(2)="Pupa"

	for (i <- 0 to 2)
		println(greeting(i))

val ch = List(0,1,2)

val l1 = 6::ch
val l2 = 1::2::Nil
val l3 = l1 ::: l2
println(l3)

println(l3.drop(2))
println(l3.dropRight(2))
println(l3.exists(x=> x==6))
println(l3.filter(x=> x>5==true))
println(l3.forall(x=> x<5==true))
println(l3.foreach(x=> println(s"number is $x")))
println(l3.foreach(print))
println(l3.head)
println(l3.init)
println(l3.isEmpty)
println(l3.last)
println(l3.length)
println(l3.map(_.toString))
println(l3.mkString(","))
println(l3.reverse)
println(l3.tail)

val tpl = (0,1)

println(s"${tpl._1} - ${tpl._2}")

var jetSet = Set("Cessna", "Boeing")

jetSet+="Lear"

println(jetSet.contains("Aerobus"))

val treasureMap = Map(1->"Chef", 2->"Pupa")

import scala.io.Source

val lines = Source.fromFile(args(0)).getLines().toList
val longestLine = lines.reduceLeft((a, b)=> if (a.length>b.length) a else b)


println(longestLine)