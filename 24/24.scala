val li = List(1,2,3,4)
val l = li.partition(_<3)

println(l)

println(li.flatMap{case 3 => "!"; case _ => ""})
println(li.map{case 3 => "!"; case _ => ""})
