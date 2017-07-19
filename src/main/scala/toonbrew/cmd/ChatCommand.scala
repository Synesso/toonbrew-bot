package toonbrew.cmd

import com.typesafe.config.ConfigFactory
import sx.blah.discord.handle.obj.{IChannel, IUser}
import toonbrew._

import scala.util.Try

object ChatCommand {

  private val conf = ConfigFactory.load()

  def parse(msg: String): Option[_ <: ChatCommand] = msg.split("\\s+").toSeq match {
    case "/brew" +: args => BrewToon(args)
    case ("/random" | "/rand" | "/roll") +: args => Randomize(args)
    case _ => None
  }

  def parse_(msg: String): Option[_ <: ChatCommand] = {
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
        Toon.races.find(r => r.getClass.getSimpleName.equalsIgnoreCase(s"$racename$$"))
        .map(r => BrewToon(Some(r)))
      case _ => None
    }
  }

  private[cmd] val acceptableChannels = if (conf.getBoolean("testmode")) Set("bot-testing") else Set("roll-a-toon")
}

case class Message(channel: IChannel, text: String)

trait ChatCommand {
  def response(author: IUser, channel: IChannel): Option[Message]
}
