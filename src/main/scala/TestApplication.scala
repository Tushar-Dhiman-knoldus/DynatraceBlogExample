import akka.actor.{Actor, ActorSystem, PoisonPill, Props}
import org.apache.logging.log4j.{LogManager, Logger}

object TestApplication extends App {

  val log: Logger = LogManager.getLogger(getClass)

  class PoisonPillExample extends Actor {

    def receive: Receive = {
      case "start" =>
        log.info("Actor started")
      case "process" =>
        log.error("Error Message Log")
      case "stop" =>
        self ! PoisonPill
    }
  }
  val system = ActorSystem("MySystem")
  val actor = system.actorOf(Props[PoisonPillExample], "PoisonPillExample")

  actor ! "start"
  for (_ <- 1 to 100) {
    actor ! "process"
    Thread.sleep(10000)
  }
  actor ! "stop"
}
