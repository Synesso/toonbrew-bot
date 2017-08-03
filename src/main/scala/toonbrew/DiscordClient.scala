package toonbrew

import sx.blah.discord.api.events.IListener
import sx.blah.discord.api.{ClientBuilder, IDiscordClient}
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.util.MessageBuilder
import toonbrew.cmd.{ChatCommand, Message}

class DiscordClient(client: IDiscordClient) {

  client.getDispatcher.registerListener(new IListener[MessageReceivedEvent] {
    override def handle(event: MessageReceivedEvent): Unit = {
      val author = event.getAuthor
      val channel = event.getMessage.getChannel
      val command: Option[ChatCommand] = ChatCommand.parse(event.getMessage.getContent.trim)
      command.flatMap(_.response(author, channel)).foreach(print)
    }
  })

  private def print(msg: Message): IMessage = {
    new MessageBuilder(client).withChannel(msg.channel).withContent(msg.text).build
  }
}

object DiscordClient {
  def apply(token: String): DiscordClient = {
    new DiscordClient(new ClientBuilder().withToken(token).login)
  }
}
