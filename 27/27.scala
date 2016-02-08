 @deprecated("use newShinyMethod() instead") 
 def veryBigMistake = {
	// @tailrec def yo = "a"
}

//   (e: @unchecked) match {
//     // non-exhaustive cases...
// }

// @serial(1234)

import annotation._

class strategy(arg: Annotation) extends Annotation

class delayed extends Annotation

//prohibited due to inability to use annotationions inside one another 
// @strategy(@delayed) def f(){}
@strategy(new delayed) def f(){}

// @volatile
//  @serializable
//  @SerialVersionUID(1234)
//  @transient

class Some {
	@BeanProperty val crazy = "11"
}

@native
        def beginCountdown() { }
