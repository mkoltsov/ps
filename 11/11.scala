case class Chef(val name:String)
case class Pupa(name:String)

case class Holder(a:Chef, b:Pupa)

val a = Chef("chef")
val a1 = Chef("chef")
val b:Pupa = Pupa("pupa")
val b1:Pupa = Pupa("pupa")
val c = Pupa("pupa")

println(Holder(a, b) == Holder(a1, b1))
//println(a == c)

def isEqual(x:Any, y:Any) = x==y

println(isEqual(true, true))
println(isEqual(421, 421))
println(a == a1)
println(a eq a1)
println(a ne a1)

def error(s:String):Nothing = throw new Exception(s)

def div(a:Int) = if (a!= 0) 10/a else error("cant divide by zero")

//div(0)
 
