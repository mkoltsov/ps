def append(ls1:List[Int], ls2:List[Int]):List[Int] = 
	ls1 match {
		case List() => ls2
		case x::ys =>x :: append(ys, ls2)
		
	}

println(append(1::2::3::Nil, 5::6::7::Nil))

def msort[T](less:(T,T) =>Boolean)(xs:List[T]):List[T] = 
{
	def merge(xs:List[T], ys:List[T]):List[T] = 
		(xs, ys) match {
			case (Nil, _) => ys
			case (_, Nil) => xs
			case (x::xs1, y::ys1) => 
				if (less(x,y)) x :: merge(xs1, ys)
				else y :: merge(xs, ys1)
		}

	val n = xs.length /2
	if (n==0) xs
	else {
		val(ys, zs) = xs splitAt n
		merge(msort(less)(ys), msort(less)(zs))
	}

}

println(msort((x:Int, y:Int) => x < y)(List(3,4,1)))

println(List.range(1,10).flatMap(i=> (0 to i)))

println(List.fill(5,2)("a"))

println(List.tabulate(5)(n=> n*n))