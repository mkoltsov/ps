val col = (0 to 10).filter(_>2)

println(col)

val f = (_:Int) + (_:Int)

println(f(5,10))

def sum = (a:Int,b:Int,c:Int) => a+b+c

println(sum(1,3,4))

def sum2(a:Int,b:Int,c:Int) = a+b+c
def partiallyAppliedFunc = sum2 _

val b = sum2(1,_:Int,4)
println(b(4))

println(partiallyAppliedFunc(1,3,4))

def makeIncreaser(more:Int) = (x:Int) => x+more

val inc10 = makeIncreaser(10)

println(inc10(100))

def echo(s:String*) = for (i<-s) println(i)

echo("dfsd","fdsfdsf","4")

val arr = Array("dfsd","fdsfdsf","4")

echo(arr:_*)