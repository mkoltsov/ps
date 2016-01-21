val mult = (i:Int) => i*i
val str = (i:Int) => i.toString
val g = str compose mult

val f =(0 to 10).map{x=>Some(x)}
scala> f.map{case n@Some(_)=>n}
res3: scala.collection.immutable.IndexedSeq[Some[Int]] = Vector(Some(0), Some(1), Some(2), Some(3), Some(4), Some(5), Some(6), Some(7), Some(8), Some(9), Some(10))

scala> f.flatMap{case n@Some(_)=>n}
res4: scala.collection.immutable.IndexedSeq[Int] = Vector(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)