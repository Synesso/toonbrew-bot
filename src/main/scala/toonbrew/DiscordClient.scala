package toonbrew

import sx.blah.discord.api.events.IListener
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent
import sx.blah.discord.handle.obj.{IChannel, IMessage}
import sx.blah.discord.util.MessageBuilder

import scala.util.{Random, Try}

class DiscordClient(client: IDiscordClient) {

  private val BrewCommand = """/brew(.*)""".r
  private val RandRange = """/random (\d+) (\d+)""".r
  private val RandZero = """/random (\d+)""".r
  private val Rand = "/random"

  client.getDispatcher.registerListener(new IListener[MessageReceivedEvent] {
    override def handle(event: MessageReceivedEvent): Unit = {
      val channel = event.getMessage.getChannel
      if (channel.getName == "general") {
        event.getMessage.getContent.trim match {
          case "/brew" =>
            brew(channel, by = RaceFirst)
          case BrewCommand(method) =>
            BrewMethod.forName(method.trim).map(brew(channel, _)).getOrElse(printUsage(channel))
          case RandRange(low, high) =>
            Try((low.toInt, high.toInt)).foreach { case (l, h) =>
              printRoll(channel, event.getMessage.getAuthor.getName, l, h)
            }
          case RandZero(high) =>
            Try(high.toInt).foreach { h =>
              printRoll(channel, event.getMessage.getAuthor.getName, 1, h)
            }
          case Rand =>
            printRoll(channel, event.getMessage.getAuthor.getName, 1, 100)
          case _ =>
        }
      }
    }
  })

  private def brew(channel: IChannel, by: BrewMethod): IMessage = {
    val toon = Toon.random
    val toonDesc = s"${toon.race} ${toon.clazz}"
    new MessageBuilder(client).withChannel(channel).withContent(toonDesc).build
  }

  // from low, inclusive to high, inclusive. e.g. 1-100 can give 1 or 100
  private def rng(low: Int, high: Int): Int = Random.nextInt(high + 1 - low) + low

  private def printRoll(channel: IChannel, name: String, low: Int, high: Int): IMessage = {
    val msg = s"$name rolls a number between $low and $high. It's ${rng(low, high)}."
    print(channel, msg)
  }

  private def print(channel: IChannel, msg: String): IMessage = {
    new MessageBuilder(client).withChannel(channel).withContent(msg).build
  }

  private def printUsage(channel: IChannel): IMessage = {
    print(channel, s"Acceptable brew methods: [${BrewMethod.acceptedValues.mkString(",")}]")
  }
}

object DiscordClient {
  def apply(token: String): DiscordClient = {
    new DiscordClient(new ClientBuilder().withToken(token).login)
  }
}
