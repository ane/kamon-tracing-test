package foo

import akka.actor.{Actor, ActorSystem, Props}
import akka.pattern.ask
import com.typesafe.scalalogging.StrictLogging
import kamon.Kamon
import kamon.context.Key

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

case object Prut
case object Prat

class Persetti extends Actor with StrictLogging {
  override def receive: Receive = {
    case Prut =>
      logger.info(s"KEKEKE! Key is: ${Kamon.currentContext().get(Main.Dumb)}")
      sender() ! Prat
  }
}

object Main extends App with StrictLogging {
  val Dumb = Key.broadcastString("ruma")

  override def main(args: Array[String]): Unit = {
    val system = ActorSystem("pieru")
    import system.dispatcher
    implicit val timeout = akka.util.Timeout(3.seconds)
    val bokke = system.actorOf(Props[Persetti], "kaivaja")
    val span = Kamon.buildSpan("send-message").start()

    Kamon.withSpan(span) {
      Kamon.withContextKey(Dumb, Some("1234")) {
        val foo = Future {
          logger.info(s"Logging inside future: ${Kamon.currentContext().get(Dumb)}")
        }

        foo flatMap { _ =>
          (bokke ? Prut) map {
            case Prat =>
              logger.info(s"Got an answer: ${Kamon.currentContext().get(Dumb)}")
          }
        }
      }
    }

    Await.ready(system.whenTerminated, Duration.Inf)
  }
}
