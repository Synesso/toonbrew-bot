package toonbrew.cmd

import sx.blah.discord.handle.obj.{IChannel, IUser}
import toonbrew.Enums.{Area, City, Race}
import toonbrew.Toon
import toonbrew.cmd.ChatCommand.acceptableChannels

import scala.annotation.tailrec

object BrewToon {
  def apply(args: Seq[String]): Option[BrewToon] = {

    @tailrec
    def loop(bt: BrewToon, args: Seq[String]): Option[BrewToon] = {
      args match {
        case Nil => Some(bt)
        case ("--name" | "-n") +: tail => loop(bt.copy(nameOnly = true), tail)
        case ("--full" | "-f") +: tail => loop(bt.copy(full = true), tail)
        case ("--race" | "-r") +: raceString +: tail =>
          Toon.racesMap.get(raceString.toLowerCase) match {
            case Some(race) => loop(bt.copy(race = Some(race)), tail)
            case None => None
          }
        case ("--area" | "-a") +: areaString +: tail =>
          Toon.areasMap.get(areaString) match {
            case Some(cities) => loop(bt.copy(cities = Some(cities)), tail)
            case None => None
          }
        case _ => None
      }
    }
    loop(BrewToon(), args)
  }
}

case class BrewToon(race: Option[Race] = None,
                    full: Boolean = false,
                    nameOnly: Boolean = false,
                    cities: Option[Set[City]] = None) extends ChatCommand {

  override def response(author: IUser, channel: IChannel): Option[Message] = {
    if (acceptableChannels.contains(channel.getName)) {
      Toon.random(race, cities).map { toon =>
      val text =
        if (full) toon.describeFully
        else if (nameOnly && race.isDefined) s"${toon.name} the ${toon.clazz}"
        else if (nameOnly) toon.name
        else toon.describeSuccinctly
        Message(channel, text)
      }
    } else None
  }
}
