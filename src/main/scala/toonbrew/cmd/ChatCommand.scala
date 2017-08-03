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

  private[cmd] val acceptableChannels = if (conf.getBoolean("testmode")) Set("bot-testing") else Set("roll-a-toon")
}

case class Message(channel: IChannel, text: String)

trait ChatCommand {
  def response(author: IUser, channel: IChannel): Option[Message]
}
