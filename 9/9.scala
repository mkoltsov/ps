def someFun(func:(Int, Int) => Int) = func(10, 10)

println(someFun(_*_))
println(someFun(_-_))
println(someFun(_+_))
println(someFun(_/_))

def curryMe(x:Int)(y:Int) = x+y

val c = curryMe(10) _
println(c(4))

def first(x:Int) = (y:Int) => x+y

val f = first(19)

println(f(100))

def twice(f:Double => Double,x:Double) = f(f(x))
def twiceAndDo(f:Double => Double,x:Double)(doS:Double => Unit) = doS(f(f(x)))
println(twice(_+1, 5.0))
twiceAndDo(_+1, 5.0){x:Double => println(x)}

var assertionEnabled = true

def myAssert(predicate:()=>Boolean) = if (assertionEnabled && !predicate()) throw new AssertionError

myAssert(()=> 5>3)

def myAssert2(predicate: =>Boolean) = if (assertionEnabled && !predicate) throw new AssertionError

myAssert2(5>3)