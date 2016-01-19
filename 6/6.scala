class Rational(val n:Int, d:Int){
	println(s"new rational: $n/$d")
	def this(n:Int) = this(n,0)
	override def toString = s"$n/$d"

	def * (n:Int) = new Rational(this.n * n, 0)

	
}

implicit def doubleToInt(n:Double) = 3 

val ra = new Rational(3,4)

println(ra.n)
println(ra * 3)
println(ra * 3.0)