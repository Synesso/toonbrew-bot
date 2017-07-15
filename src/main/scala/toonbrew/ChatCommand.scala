package toonbrew

import com.typesafe.config.ConfigFactory
import sx.blah.discord.handle.obj.{IChannel, IUser}
import toonbrew.ChatCommand.acceptableChannels
import toonbrew.Enums.{Agnostic, Female, Freeport, Race}

import scala.util.{Random, Try}

object ChatCommand {

  private val conf = ConfigFactory.load()

  def parse(msg: String): Option[_ <: ChatCommand] = {
    msg.split("\\s+").toSeq match {
      case Seq("/random") => Some(Randomize())
      case Seq("/random", high) => Try(high.toInt).toOption.map(h => Randomize(max = h))
      case Seq("/random", low, high) => for {
        h <- Try(high.toInt).toOption
        l <- Try(low.toInt).toOption
      } yield Randomize(l, h)
      case Seq("/brew") => Some(BrewToon())
      case "/brew" +: race =>
        val racename = race.mkString("").toLowerCase()
        Toon.races.foreach(r => println(r.getClass.getSimpleName))
        Toon.races.find(r => r.getClass.getSimpleName.equalsIgnoreCase(s"$racename$$"))
        .map(r => BrewToon(Some(r)))
      case _ => None
    }
  }

  private[toonbrew] val acceptableChannels = if (conf.getBoolean("testmode")) Set("bot-testing") else Set("roll-a-toon")
}

case class Message(channel: IChannel, text: String)

sealed trait ChatCommand {
  def response(author: IUser, channel: IChannel): Option[Message]
}

case class Randomize(min: Int = 1, max: Int = 100) extends ChatCommand {
  override def response(author: IUser, channel: IChannel): Option[Message] = {
    if (acceptableChannels.contains(channel.getName) && min < max && min >= 0) {
      Some(Message(channel, s"A magic die is rolled by ${author.getName}. " +
        s"It could have been any number from $min to $max, " +
        s"but this time it turned up a ${Random.nextInt(max + 1 - min) + min}."))
    } else None
  }
}

case class BrewToon(race: Option[Race] = None) extends ChatCommand {
  override def response(author: IUser, channel: IChannel): Option[Message] = {
    if (acceptableChannels.contains(channel.getName)) {
      val text = race match {
        case Some(r) => Toon.random(r).toString
        case None =>
          val toon = Toon.random
          s"${toon.race} ${toon.clazz}"
      }
      Some(Message(channel, text))
    } else None
  }
}
