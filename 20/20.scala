trait Abstract {
	type T

	def trasform(x:T):T

	val initial:T

	var current:T
	
}

class Concrete extends Abstract {
	type T = String

	def trasform(x:String):String = x+x

	val initial = "hi"

	var current = initial
}

trait Rational {
	val numer:Int
	val denumer:Int
}

val r = new Rational{val numer = 1;val denumer=2}

println(r.denumer)

trait RationalTrait {
          val numerArg: Int
          val denomArg: Int
          require(denomArg != 0)
          private val g = gcd(numerArg, denomArg)
          val numer = numerArg / g
          val denom = denomArg / g
          private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b) 
          override def toString = numer +"/"+ denom
}

val r2 = new {val numerArg = 1; val denomArg =2} with RationalTrait

println(r2.denomArg)

object twoThirds extends {
    val numerArg = 2
    val denomArg = 3
} with RationalTrait

object Demo {
	{println("Chef")}

	lazy val x = {println("initializing"); "done"}
}

val d = Demo
println(d.x)

 trait LazyRationalTrait {
          val numerArg: Int
          val denomArg: Int
          lazy val numer = numerArg / g
          lazy val denom = denomArg / g
          override def toString = numer +"/"+ denom
          private lazy val g = {
            require(denomArg != 0)
            gcd(numerArg, denomArg)
          }
private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

val df = new LazyRationalTrait{
	val numerArg = 1
	val denomArg =2
}

println(df)

class Food

abstract class Animal{
	type SuitableFood <: Food

	def eat(x:SuitableFood)
}

class Grass extends Food

class Cow extends Animal {
	type SuitableFood = Grass
	override def eat(x:Grass) ={}
}

   class DogFood extends Food
        class Dog extends Animal {
          type SuitableFood = DogFood
          override def eat(food: DogFood) {}
   }
 class Pasture {
          var animals: List[Animal { type SuitableFood = Grass }] = Nil
}

def using[T<: {def close():Unit}, S](obj:T)(operation:T => S) {
	val result = operation(obj)
	obj.close()
	result
}

object Color extends Enumeration {

val red = Value("RED")

val green = Value("Green")	
}

println(Color.red)
println(Color(1))

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency
  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    def + (that: Currency): Currency =
      make(this.amount + that.amount)
    def * (x: Double): Currency =
      make((this.amount * x).toLong)
    def - (that: Currency): Currency =
      make(this.amount - that.amount)
    def / (that: Double) =
      make((this.amount / that).toLong)
    def / (that: Currency) =
      this.amount.toDouble / that.amount
    def from(other: CurrencyZone#AbstractCurrency): Currency =
      make(math.round(
        other.amount.toDouble * Converter.exchangeRate
          (other.designation)(this.designation)))
    private def decimals(n: Long): Int =
      if (n == 1) 0 else 1 + decimals(n / 10)
    override def toString =
      ((amount.toDouble / CurrencyUnit.amount.toDouble)
formatted ("%."+ decimals(CurrencyUnit.amount) +"f")
       +" "+ designation)
  }
  val CurrencyUnit: Currency
}

  object Europe extends CurrencyZone {
    abstract class Euro extends AbstractCurrency {
      def designation = "EUR"
    }
    type Currency = Euro
    def make(cents: Long) = new Euro {
      val amount = cents
    }
    val Cent = make(1)
    val Euro = make(100)
    val CurrencyUnit = Euro
}
  object Japan extends CurrencyZone {
    abstract class Yen extends AbstractCurrency {
      def designation = "JPY"
    }
    type Currency = Yen
    def make(yen: Long) = new Yen {
      val amount = yen
    }
    val Yen = make(1)
    val CurrencyUnit = Yen
  }

    object Converter {
    var exchangeRate = Map(
      "USD" -> Map("USD" -> 1.0   , "EUR" -> 0.7596,
                   "JPY" -> 1.211 , "CHF" -> 1.223),
      "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0   ,
                   "JPY" -> 1.594 , "CHF" -> 1.623),
      "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
                   "JPY" -> 1.0   , "CHF" -> 1.018),
      "CHF" -> Map("USD" -> 0.8108, "EUR" -> 0.6160,
                   "JPY" -> 0.982 , "CHF" -> 1.0  )
) }

    println(Converter.exchangeRate("USD"))