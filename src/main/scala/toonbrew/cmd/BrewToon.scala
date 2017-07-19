package toonbrew.cmd

import sx.blah.discord.handle.obj.{IChannel, IUser}
import toonbrew.Enums.Race
import toonbrew.Toon
import toonbrew.cmd.ChatCommand.acceptableChannels

import scala.annotation.tailrec

object BrewToon {
  def apply(args: Seq[String]): Option[BrewToon] = {
    @tailrec
    def loop(bt: BrewToon, args: Seq[String]): Option[BrewToon] = {
      args match {
        case Nil => Some(bt)
        case ("--full" | "-f") +: tail => loop(bt.copy(full = true), tail)
        case ("--race" | "-r") +: raceString +: tail =>
          Toon.racesMap.get(raceString.toLowerCase) match {
            case Some(race) => loop(bt.copy(race = Some(race)), tail)
            case None => None
          }
        case _ => None
      }
    }
    loop(BrewToon(), args)
  }
}

case class BrewToon(race: Option[Race] = None, full: Boolean = false) extends ChatCommand {
  override def response(author: IUser, channel: IChannel): Option[Message] = {
    if (acceptableChannels.contains(channel.getName)) {
      val toon = race.map(r => Toon.random(r)).getOrElse(Toon.random)
      val text = if (full) toon.describeFully else toon.describeSuccinctly
      Some(Message(channel, text))
    } else None
  }
}
