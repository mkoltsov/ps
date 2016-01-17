object Ch extends App {
class CheckSum {
	private var d =0 

	def add(a:Int) {d+=a}

	def checkSum:Int = ~ (d & 0xFF) +1

}

object CheckSum{
	def apply() = {val f = new CheckSum;f add 10; f.checkSum + f.d}
}

println(CheckSum())


	println("It Works")
	println(args)
}