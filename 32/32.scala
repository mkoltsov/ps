import scala.actors._
        object SillyActor extends Actor {
          def act() {
            for (i <- 1 to 5) {
              println("I'm acting!")
              Thread.sleep(1000)
} }
}

SillyActor.start()

import scala.actors.Actor._
val seriousActor2 = actor {
                  for (i <- 1 to 5)
                    println("That is the question.")
                  Thread.sleep(1000)
}

val echoActor = actor {
          while (true) {
            receive {
              case msg =>
                println("received message: "+ msg)
            }
} }

echoActor ! "hi there"
echoActor ! 15

self ! "hello"
self.receive { case x => println(x) }
// self.receiveWithin(1000){case x=>}

object NameResolver extends Actor {
          import java.net.{InetAddress, UnknownHostException}
          def act() {
            react {
              case (name: String, actor: Actor) =>
                actor ! getIp(name)
                act()
              case "EXIT" =>
                println("Name resolver exiting.")
                // quit
              case msg =>
                println("Unhandled message: "+ msg)
                act()
} }
          def getIp(name: String): Option[InetAddress] = {
            try {
              Some(InetAddress.getByName(name))
            } catch {
              case _:UnknownHostException => None
            }
} }

NameResolver.start()

NameResolver ! ("www.scala-lang.org", self)

self.receiveWithin(0) { case x => x }

NameResolver ! ("wwwwww.scala-lang.org", self)

self.receiveWithin(0) { case x => x }