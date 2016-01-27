import scala.collection.immutable.TreeSet
val tree = TreeSet[String]() ++ List("pupa","chef")

println(tree)

import scala.collection.mutable

val mutaSet = mutable.Set.empty ++= tree

val immutaSet = Set.empty ++ mutaSet

val muta = mutable.Map("i" -> 1, "ii" -> 2)

val immu = Map.empty ++ muta

def longestWord(words: Array[String]) = {
          var word = words(0)
          var idx = 0
          for (i <- 1 until words.length)
            if (words(i).length > word.length) {
              word = words(i)
              idx = i
}
(word, idx)
}

val longest =
                 longestWord("The quick brown fox".split(" "))

println(longest)                 
val(word, idx) = longest

println(s"$word -- $idx")

case class Data1(var chef:String)

val a = Data1("chef")
a.chef = "pupa"

println(a.chef)
