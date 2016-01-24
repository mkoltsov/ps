// package chef.cockpit {
// 	class Chef 
// }

 // In file launch.scala
 package launch {
   class Booster3
}
 // In file bobsrockets.scala
 package bobsrockets {
   package navigation {
     package launch {
       class Booster1
     }
     class MissionControl {
       val booster1 = new launch.Booster1
       val booster2 = new bobsrockets.launch.Booster2
       val booster3 = new _root_.launch.Booster3
} }
   package launch {
     class Booster2
} 
}



package bobsrockets
        package navigation {
          private[bobsrockets] class Navigator {
            protected[navigation] def useStarChart() {}
            class LegOfJourney {
              private[Navigator] val distance = 100
            }
            private[this] var speed = 200
          }
        }
        package launch {
          import navigation._
          object Vehicle {
            private[launch] val guide = new Navigator
          }
}

no access modifier -- public access
private[bobsrockets] -- access within outer package
private[navigation] -- same as package visibility in Java 
private[Navigator] -- same as private in Java
private[LegOfJourney] - same as private in Scala
private[this] -- access only from same object