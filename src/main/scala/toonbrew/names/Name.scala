package toonbrew.names

import toonbrew.Enums._

object Name {
  def generate(gender: Gender, race: Race): String = {
    val generator: Names = race match {
      case Barbarian => Barbarians
      case DarkElf => DarkElves
      case Dwarf => Dwarves
      case Erudite => Erudites
      case Gnome => Gnomes
      case HalfElf => HalfElves
      case Halfling => Halflings
      case HighElf => HighElves
      case Human => Humans
      case Iksar => Iksars
      case Ogre => Ogres
      case Troll => Trolls
      case WoodElf => WoodElves
    }
    generator.name(gender).capitalize
  }
}
