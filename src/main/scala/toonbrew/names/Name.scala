package toonbrew.names

import toonbrew.Enums._

object Name {
  def generate(gender: Gender, race: Race): String = race match {
    case Barbarian => Barbarians.name(gender).capitalize
    case _ => DarkElves.name(gender).capitalize
  }

}
