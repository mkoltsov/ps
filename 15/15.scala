case class Chef(a:String, b:String)

val d = Chef("fdf", "1111")

println(d.a) 

val c = d.copy(a="222")

println(c.a)

def m = c match {

  case _ => 
}

println(m)

val l = List(1,2,3,4)

val k = l match {
	case List(x,_*) if x==1 => "found it"
}

println(k)
println(k.isInstanceOf[String])

sealed abstract class Pupa

case class Bupa(a:String) extends Pupa

val withDefault:Option[Int] => Int = {
	case Some(x) => x
	case None => 0 
}

println(withDefault(Some(19)))
println(withDefault(None))