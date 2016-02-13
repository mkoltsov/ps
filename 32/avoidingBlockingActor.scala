import scala.actors._
val sillyActor2 = actor {
    def emoteLater() {
      val mainActor = self
      actor {
        Thread.sleep(1000)
        mainActor ! "Emote"
      }
}
    var emoted = 0
    emoteLater()
loop { react {
        case "Emote" =>
          println("I'm acting!")
          emoted += 1
          if (emoted < 5)
            emoteLater()
        case msg =>
          println("Received: "+ msg)
      }
} }

sillyActor2 ! "hi there"

import scala.actors.Actor._
        import java.net.{InetAddress, UnknownHostException}
        case class LookupIP(name: String, respondTo: Actor)
        case class LookupResult(
          name: String,
          address: Option[InetAddress]
        )
        object NameResolver2 extends Actor {
          def act() {
            loop {
              react {
                case LookupIP(name, actor) =>
                  actor ! LookupResult(name, getIp(name))
              }
} }
          def getIp(name: String): Option[InetAddress] = {
            // As before (in Listing 30.3)
} }
