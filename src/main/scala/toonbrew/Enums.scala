package toonbrew

object Enums {

  sealed trait Race
  case object Barbarian extends Race
  case object DarkElf extends Race { override def toString = "Dark Elf" }
  case object Dwarf extends Race
  case object Erudite extends Race
  case object Gnome extends Race
  case object HalfElf extends Race { override def toString = "Half Elf" }
  case object Halfling extends Race
  case object HighElf extends Race { override def toString = "High Elf" }
  case object Human extends Race
  case object Iksar extends Race
  case object Ogre extends Race
  case object Troll extends Race
  case object WoodElf extends Race { override def toString = "Wood Elf" }

  sealed trait Clazz
  case object Bard extends Clazz
  case object Cleric extends Clazz
  case object Druid extends Clazz
  case object Enchanter extends Clazz
  case object Magician extends Clazz
  case object Monk extends Clazz
  case object Necromancer extends Clazz
  case object Paladin extends Clazz
  case object Ranger extends Clazz
  case object Rogue extends Clazz
  case object ShadowKnight extends Clazz { override def toString = "Shadow Knight"}
  case object Shaman extends Clazz
  case object Warrior extends Clazz
  case object Wizard extends Clazz

  sealed trait City
  case object AkAnon extends City { override def toString = "Ak'Anon"}
  case object Cabilis extends City
  case object Erudin extends City
  case object Felwithe extends City
  case object Freeport extends City
  case object Grobb extends City
  case object Halas extends City
  case object Kaladim extends City
  case object Kelethin extends City
  case object Neriak extends City
  case object Oggok extends City
  case object Paineel extends City
  case object Qeynos extends City
  case object Rivervale extends City

  sealed trait Area
  case object Faydwer extends Area
  case object East extends Area
  case object West extends Area
  case object Kunark extends Area
  case object Odin extends Area

  sealed trait Gender
  case object Female extends Gender
  case object Male extends Gender

  sealed trait Belief
  case object Agnostic extends Belief
  case object Bertoxxulous extends Belief
  case object BrellSerilis extends Belief { override def toString = "Brell Serilis"}
  case object Bristlebane extends Belief
  case object CazicThule extends Belief { override def toString = "Cazic Thule"}
  case object ErollisiMarr extends Belief { override def toString = "Erollisi Marr"}
  case object Innoruuk extends Belief
  case object Karana extends Belief
  case object MithanielMarr extends Belief { override def toString = "Mithaniel Marr"}
  case object Prexus extends Belief
  case object Quellious extends Belief
  case object RallosZek extends Belief { override def toString = "Rallos Zek"}
  case object RodcetNife extends Belief { override def toString = "Rodcet Nife"}
  case object SolusekRo extends Belief { override def toString = "Solusek Ro"}
  case object TheTribunal extends Belief { override def toString = "The Tribunal"}
  case object Tunare extends Belief
  case object Veeshan extends Belief

}
