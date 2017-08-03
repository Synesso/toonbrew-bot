package toonbrew.cmd

import sx.blah.discord.handle.obj.{IChannel, IUser}
import toonbrew.cmd.ChatCommand.acceptableChannels

import scala.util.{Random, Try}

object Randomize {
  def apply(args: Seq[String]): Option[Randomize] = {
    args match {
      case Nil => Some(Randomize())
      case Seq(high) => Try(high.toInt).toOption.map(h => Randomize(max = h))
      case Seq(low, high) => for {
        h <- Try(high.toInt).toOption
        l <- Try(low.toInt).toOption
      } yield Randomize(l, h)
    }
  }
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
