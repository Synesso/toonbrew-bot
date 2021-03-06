package toonbrew

import toonbrew.Enums._
import toonbrew.names.Name

case class Toon(name: String, race: Race, clazz: Clazz, gender: Gender, city: City, belief: Belief) {
  def describeSuccinctly = s"$race $clazz"
  def describeFully: String = {
    val (beliefPre, beliefPost) = belief match {
      case Agnostic => ("an agnostic,", "")
      case deity => ("a", s" Follower of $deity.")
    }
    s"$name, $beliefPre ${gender.toString.toLowerCase} **$race $clazz** of $city.$beliefPost"
  }
}

object Toon extends Choose {

  def random(raceOpt: Option[Race] = None, cities: Option[Set[City]] = None): Option[Toon] = {
    val options = permittedCombos.filter{ case (r, _, _, c) =>
      (raceOpt.isEmpty || raceOpt.contains(r)) &&
      (cities.isEmpty || cities.exists(_.contains(c)))
    }

    val restrictToClass = {
      val clazz = choose(options.map(_._2).distinct)
      options.filter(o => clazz.contains(o._2))
    }

    val restrictToRace = {
      val race = choose(restrictToClass.map(_._1).distinct)
      restrictToClass.filter(o => race.contains(o._1))
    }

    val restrictToCity = {
      val city = choose(restrictToRace.map(_._4).distinct)
      restrictToRace.filter(o => city.contains(o._4))
    }

    choose(restrictToCity).map { case (race, clazz, belief, city) =>
      val gender: Gender = choose(List(Female, Male)).get
      val name = Name.generate(gender, race)
      Toon(name, race, clazz, gender, city, belief)
    }
  }

  private val permittedCombos: Seq[(Race, Clazz, Belief, City)] = List(
    (Human, Warrior, Agnostic, Freeport),
    (Human, Warrior, Agnostic, Qeynos),
    (Human, Warrior, Bertoxxulous, Qeynos),
    (Human, Warrior, ErollisiMarr, Freeport),
    (Human, Warrior, Innoruuk, Freeport),
    (Human, Warrior, Karana, Qeynos),
    (Human, Warrior, MithanielMarr, Freeport),
    (Human, Warrior, RallosZek, Freeport),
    (Human, Warrior, RallosZek, Qeynos),
    (Human, Warrior, RodcetNife, Qeynos),
    (Human, Necromancer, Bertoxxulous, Qeynos),
    (Human, Necromancer, Innoruuk, Freeport),
    (Human, Wizard, Agnostic, Freeport),
    (Human, Wizard, Agnostic, Qeynos),
    (Human, Wizard, Bertoxxulous, Qeynos),
    (Human, Wizard, ErollisiMarr, Freeport),
    (Human, Wizard, Innoruuk, Freeport),
    (Human, Wizard, Karana, Qeynos),
    (Human, Wizard, MithanielMarr, Freeport),
    (Human, Wizard, RodcetNife, Qeynos),
    (Human, Wizard, SolusekRo, Freeport),
    (Human, Wizard, SolusekRo, Qeynos),
    (Human, Magician, Agnostic, Freeport),
    (Human, Magician, Agnostic, Qeynos),
    (Human, Magician, Bertoxxulous, Qeynos),
    (Human, Magician, ErollisiMarr, Freeport),
    (Human, Magician, Innoruuk, Freeport),
    (Human, Magician, Karana, Qeynos),
    (Human, Magician, MithanielMarr, Freeport),
    (Human, Magician, RodcetNife, Qeynos),
    (Human, Enchanter, Agnostic, Freeport),
    (Human, Enchanter, Agnostic, Qeynos),
    (Human, Enchanter, Bertoxxulous, Qeynos),
    (Human, Enchanter, ErollisiMarr, Freeport),
    (Human, Enchanter, Innoruuk, Freeport),
    (Human, Enchanter, Karana, Qeynos),
    (Human, Enchanter, MithanielMarr, Freeport),
    (Human, Enchanter, RodcetNife, Qeynos),
    (Human, Cleric, Bertoxxulous, Qeynos),
    (Human, Cleric, ErollisiMarr, Freeport),
    (Human, Cleric, Innoruuk, Freeport),
    (Human, Cleric, Karana, Qeynos),
    (Human, Cleric, MithanielMarr, Freeport),
    (Human, Cleric, RodcetNife, Qeynos),
    (Human, Paladin, ErollisiMarr, Freeport),
    (Human, Paladin, Karana, Qeynos),
    (Human, Paladin, MithanielMarr, Freeport),
    (Human, Paladin, RodcetNife, Qeynos),
    (Human, Ranger, Karana, Qeynos),
    (Human, Ranger, Tunare, Qeynos),
    (Human, ShadowKnight, Bertoxxulous, Qeynos),
    (Human, ShadowKnight, Innoruuk, Freeport),
    (Human, Druid, Karana, Qeynos),
    (Human, Druid, Tunare, Qeynos),
    (Human, Monk, Agnostic, Qeynos),
    (Human, Monk, Quellious, Freeport),
    (Human, Bard, Agnostic, Freeport),
    (Human, Bard, Agnostic, Qeynos),
    (Human, Bard, BrellSerilis, Freeport),
    (Human, Bard, BrellSerilis, Qeynos),
    (Human, Bard, Bristlebane, Freeport),
    (Human, Bard, Bristlebane, Qeynos),
    (Human, Bard, ErollisiMarr, Freeport),
    (Human, Bard, Karana, Qeynos),
    (Human, Bard, MithanielMarr, Freeport),
    (Human, Bard, Prexus, Freeport),
    (Human, Bard, Prexus, Qeynos),
    (Human, Bard, Quellious, Freeport),
    (Human, Bard, Quellious, Qeynos),
    (Human, Bard, RallosZek, Freeport),
    (Human, Bard, RallosZek, Qeynos),
    (Human, Bard, RodcetNife, Qeynos),
    (Human, Bard, SolusekRo, Freeport),
    (Human, Bard, SolusekRo, Qeynos),
    (Human, Bard, TheTribunal, Freeport),
    (Human, Bard, TheTribunal, Qeynos),
    (Human, Bard, Tunare, Freeport),
    (Human, Bard, Tunare, Qeynos),
    (Human, Bard, Veeshan, Freeport),
    (Human, Bard, Veeshan, Qeynos),
    (Human, Rogue, Agnostic, Freeport),
    (Human, Rogue, Agnostic, Qeynos),
    (Human, Rogue, Bertoxxulous, Qeynos),
    (Human, Rogue, Bristlebane, Freeport),
    (Human, Rogue, Bristlebane, Qeynos),
    (Human, Rogue, ErollisiMarr, Freeport),
    (Human, Rogue, Innoruuk, Freeport),
    (Human, Rogue, Karana, Qeynos),
    (Human, Rogue, RodcetNife, Qeynos),
    (Ogre, Warrior, Agnostic, Oggok),
    (Ogre, Warrior, CazicThule, Oggok),
    (Ogre, Warrior, RallosZek, Oggok),
    (Ogre, Shaman, RallosZek, Oggok),
    (Ogre, ShadowKnight, CazicThule, Oggok),
    (Ogre, ShadowKnight, RallosZek, Oggok),
    (Halfling, Warrior, Agnostic, Rivervale),
    (Halfling, Warrior, BrellSerilis, Rivervale),
    (Halfling, Warrior, RallosZek, Rivervale),
    (Halfling, Cleric, Bristlebane, Rivervale),
    (Halfling, Druid, Karana, Rivervale),
    (Halfling, Rogue, Agnostic, Rivervale),
    (Halfling, Rogue, BrellSerilis, Rivervale),
    (Halfling, Rogue, Bristlebane, Rivervale),
    (Gnome, Warrior, Agnostic, AkAnon),
    (Gnome, Warrior, Bertoxxulous, AkAnon),
    (Gnome, Warrior, BrellSerilis, AkAnon),
    (Gnome, Warrior, RallosZek, AkAnon),
    (Gnome, Necromancer, Bertoxxulous, AkAnon),
    (Gnome, Wizard, Agnostic, AkAnon),
    (Gnome, Wizard, Bertoxxulous, AkAnon),
    (Gnome, Wizard, BrellSerilis, AkAnon),
    (Gnome, Wizard, SolusekRo, AkAnon),
    (Gnome, Magician, Agnostic, AkAnon),
    (Gnome, Magician, Bertoxxulous, AkAnon),
    (Gnome, Magician, BrellSerilis, AkAnon),
    (Gnome, Enchanter, Agnostic, AkAnon),
    (Gnome, Enchanter, Bertoxxulous, AkAnon),
    (Gnome, Enchanter, BrellSerilis, AkAnon),
    (Gnome, Cleric, Bertoxxulous, AkAnon),
    (Gnome, Cleric, BrellSerilis, AkAnon),
    (Gnome, Cleric, Bristlebane, AkAnon),
    (Gnome, Rogue, Agnostic, AkAnon),
    (Gnome, Rogue, Bertoxxulous, AkAnon),
    (Gnome, Rogue, BrellSerilis, AkAnon),
    (Gnome, Rogue, Bristlebane, AkAnon),
    (Barbarian, Warrior, Agnostic, Halas),
    (Barbarian, Warrior, RallosZek, Halas),
    (Barbarian, Warrior, TheTribunal, Halas),
    (Barbarian, Shaman, TheTribunal, Halas),
    (Barbarian, Rogue, Agnostic, Halas),
    (Barbarian, Rogue, Bristlebane, Halas),
    (Barbarian, Rogue, TheTribunal, Halas),
    (Erudite, Necromancer, CazicThule, Paineel),
    (Erudite, Wizard, Agnostic, Erudin),
    (Erudite, Wizard, Prexus, Erudin),
    (Erudite, Wizard, Quellious, Erudin),
    (Erudite, Wizard, SolusekRo, Erudin),
    (Erudite, Magician, Agnostic, Erudin),
    (Erudite, Magician, Prexus, Erudin),
    (Erudite, Magician, Quellious, Erudin),
    (Erudite, Enchanter, Agnostic, Erudin),
    (Erudite, Enchanter, Prexus, Erudin),
    (Erudite, Enchanter, Quellious, Erudin),
    (Erudite, Cleric, CazicThule, Paineel),
    (Erudite, Cleric, Prexus, Erudin),
    (Erudite, Cleric, Quellious, Erudin),
    (Erudite, Paladin, Prexus, Erudin),
    (Erudite, Paladin, Quellious, Erudin),
    (Erudite, ShadowKnight, CazicThule, Paineel),
    (WoodElf, Warrior, Agnostic, Kelethin),
    (WoodElf, Warrior, Karana, Kelethin),
    (WoodElf, Warrior, RallosZek, Kelethin),
    (WoodElf, Warrior, Tunare, Kelethin),
    (WoodElf, Ranger, Tunare, Kelethin),
    (WoodElf, Druid, Tunare, Kelethin),
    (WoodElf, Bard, Agnostic, Kelethin),
    (WoodElf, Bard, BrellSerilis, Kelethin),
    (WoodElf, Bard, Bristlebane, Kelethin),
    (WoodElf, Bard, ErollisiMarr, Kelethin),
    (WoodElf, Bard, Karana, Kelethin),
    (WoodElf, Bard, MithanielMarr, Kelethin),
    (WoodElf, Bard, Prexus, Kelethin),
    (WoodElf, Bard, Quellious, Kelethin),
    (WoodElf, Bard, RallosZek, Kelethin),
    (WoodElf, Bard, RodcetNife, Kelethin),
    (WoodElf, Bard, SolusekRo, Kelethin),
    (WoodElf, Bard, TheTribunal, Kelethin),
    (WoodElf, Bard, Tunare, Kelethin),
    (WoodElf, Bard, Veeshan, Kelethin),
    (WoodElf, Rogue, Agnostic, Kelethin),
    (WoodElf, Rogue, Bristlebane, Kelethin),
    (WoodElf, Rogue, Karana, Kelethin),
    (WoodElf, Rogue, Tunare, Kelethin),
    (HighElf, Wizard, Agnostic, Felwithe),
    (HighElf, Wizard, ErollisiMarr, Felwithe),
    (HighElf, Wizard, Karana, Felwithe),
    (HighElf, Wizard, MithanielMarr, Felwithe),
    (HighElf, Wizard, SolusekRo, Felwithe),
    (HighElf, Wizard, Tunare, Felwithe),
    (HighElf, Magician, Agnostic, Felwithe),
    (HighElf, Magician, ErollisiMarr, Felwithe),
    (HighElf, Magician, Karana, Felwithe),
    (HighElf, Magician, MithanielMarr, Felwithe),
    (HighElf, Magician, Tunare, Felwithe),
    (HighElf, Enchanter, Agnostic, Felwithe),
    (HighElf, Enchanter, ErollisiMarr, Felwithe),
    (HighElf, Enchanter, Karana, Felwithe),
    (HighElf, Enchanter, MithanielMarr, Felwithe),
    (HighElf, Enchanter, Tunare, Felwithe),
    (HighElf, Cleric, Tunare, Felwithe),
    (HighElf, Paladin, Tunare, Felwithe),
    (DarkElf, Warrior, Agnostic, Neriak),
    (DarkElf, Warrior, Innoruuk, Neriak),
    (DarkElf, Warrior, RallosZek, Neriak),
    (DarkElf, Necromancer, Innoruuk, Neriak),
    (DarkElf, Wizard, Agnostic, Neriak),
    (DarkElf, Wizard, Innoruuk, Neriak),
    (DarkElf, Wizard, SolusekRo, Neriak),
    (DarkElf, Magician, Agnostic, Neriak),
    (DarkElf, Magician, Innoruuk, Neriak),
    (DarkElf, Enchanter, Agnostic, Neriak),
    (DarkElf, Enchanter, Innoruuk, Neriak),
    (DarkElf, Cleric, Innoruuk, Neriak),
    (DarkElf, ShadowKnight, Innoruuk, Neriak),
    (DarkElf, Rogue, Agnostic, Neriak),
    (DarkElf, Rogue, Bristlebane, Neriak),
    (DarkElf, Rogue, Innoruuk, Neriak),
    (HalfElf, Warrior, Agnostic, Freeport),
    (HalfElf, Warrior, Agnostic, Kelethin),
    (HalfElf, Warrior, Agnostic, Qeynos),
    (HalfElf, Warrior, Bertoxxulous, Qeynos),
    (HalfElf, Warrior, ErollisiMarr, Freeport),
    (HalfElf, Warrior, Innoruuk, Freeport),
    (HalfElf, Warrior, Karana, Qeynos),
    (HalfElf, Warrior, MithanielMarr, Freeport),
    (HalfElf, Warrior, Prexus, Freeport),
    (HalfElf, Warrior, Prexus, Kelethin),
    (HalfElf, Warrior, Prexus, Qeynos),
    (HalfElf, Warrior, RallosZek, Freeport),
    (HalfElf, Warrior, RallosZek, Kelethin),
    (HalfElf, Warrior, RallosZek, Qeynos),
    (HalfElf, Warrior, RodcetNife, Qeynos),
    (HalfElf, Warrior, TheTribunal, Freeport),
    (HalfElf, Warrior, TheTribunal, Kelethin),
    (HalfElf, Warrior, TheTribunal, Qeynos),
    (HalfElf, Warrior, Tunare, Kelethin),
    (HalfElf, Paladin, ErollisiMarr, Freeport),
    (HalfElf, Paladin, Karana, Qeynos),
    (HalfElf, Paladin, MithanielMarr, Freeport),
    (HalfElf, Paladin, RodcetNife, Qeynos),
    (HalfElf, Paladin, Tunare, Felwithe),
    (HalfElf, Ranger, Karana, Qeynos),
    (HalfElf, Ranger, Tunare, Kelethin),
    (HalfElf, Ranger, Tunare, Qeynos),
    (HalfElf, Druid, Karana, Qeynos),
    (HalfElf, Druid, Tunare, Kelethin),
    (HalfElf, Druid, Tunare, Qeynos),
    (HalfElf, Bard, Agnostic, Freeport),
    (HalfElf, Bard, Agnostic, Kelethin),
    (HalfElf, Bard, Agnostic, Qeynos),
    (HalfElf, Bard, BrellSerilis, Freeport),
    (HalfElf, Bard, BrellSerilis, Kelethin),
    (HalfElf, Bard, BrellSerilis, Qeynos),
    (HalfElf, Bard, Bristlebane, Freeport),
    (HalfElf, Bard, Bristlebane, Kelethin),
    (HalfElf, Bard, Bristlebane, Qeynos),
    (HalfElf, Bard, ErollisiMarr, Freeport),
    (HalfElf, Bard, Karana, Qeynos),
    (HalfElf, Bard, MithanielMarr, Freeport),
    (HalfElf, Bard, Prexus, Freeport),
    (HalfElf, Bard, Prexus, Kelethin),
    (HalfElf, Bard, Prexus, Qeynos),
    (HalfElf, Bard, Quellious, Freeport),
    (HalfElf, Bard, Quellious, Kelethin),
    (HalfElf, Bard, Quellious, Qeynos),
    (HalfElf, Bard, RallosZek, Freeport),
    (HalfElf, Bard, RallosZek, Kelethin),
    (HalfElf, Bard, RallosZek, Qeynos),
    (HalfElf, Bard, RodcetNife, Qeynos),
    (HalfElf, Bard, SolusekRo, Freeport),
    (HalfElf, Bard, SolusekRo, Kelethin),
    (HalfElf, Bard, SolusekRo, Qeynos),
    (HalfElf, Bard, TheTribunal, Freeport),
    (HalfElf, Bard, TheTribunal, Kelethin),
    (HalfElf, Bard, TheTribunal, Qeynos),
    (HalfElf, Bard, Tunare, Freeport),
    (HalfElf, Bard, Tunare, Kelethin),
    (HalfElf, Bard, Tunare, Qeynos),
    (HalfElf, Bard, Veeshan, Freeport),
    (HalfElf, Bard, Veeshan, Kelethin),
    (HalfElf, Bard, Veeshan, Qeynos),
    (HalfElf, Rogue, Agnostic, Freeport),
    (HalfElf, Rogue, Agnostic, Kelethin),
    (HalfElf, Rogue, Agnostic, Qeynos),
    (HalfElf, Rogue, Bertoxxulous, Qeynos),
    (HalfElf, Rogue, Bristlebane, Freeport),
    (HalfElf, Rogue, Bristlebane, Kelethin),
    (HalfElf, Rogue, Bristlebane, Qeynos),
    (HalfElf, Rogue, ErollisiMarr, Freeport),
    (HalfElf, Rogue, Karana, Qeynos),
    (HalfElf, Rogue, RodcetNife, Qeynos),
    (HalfElf, Rogue, Tunare, Kelethin),
    (Dwarf, Warrior, Agnostic, Kaladim),
    (Dwarf, Warrior, BrellSerilis, Kaladim),
    (Dwarf, Cleric, BrellSerilis, Kaladim),
    (Dwarf, Paladin, BrellSerilis, Kaladim),
    (Dwarf, Rogue, Agnostic, Kaladim),
    (Dwarf, Rogue, BrellSerilis, Kaladim),
    (Dwarf, Rogue, Bristlebane, Kaladim),
    (Troll, Warrior, Agnostic, Grobb),
    (Troll, Warrior, CazicThule, Grobb),
    (Troll, Warrior, Innoruuk, Grobb),
    (Troll, Warrior, RallosZek, Grobb),
    (Troll, Shaman, CazicThule, Grobb),
    (Troll, Shaman, Innoruuk, Grobb),
    (Troll, ShadowKnight, CazicThule, Grobb),
    (Troll, ShadowKnight, Innoruuk, Grobb),
    (Iksar, Warrior, CazicThule, Cabilis),
    (Iksar, Shaman, CazicThule, Cabilis),
    (Iksar, Necromancer, CazicThule, Cabilis),
    (Iksar, ShadowKnight, CazicThule, Cabilis),
    (Iksar, Monk, CazicThule, Cabilis)
  )

  val clazzes: Seq[Clazz] = permittedCombos.map(_._2).distinct

  val racesByClazz: Map[Clazz, Seq[Race]] = permittedCombos.foldLeft(Map.empty[Clazz, Seq[Race]]) {
    case (map, (race, clazz, _, _)) => map.updated(clazz, race +: map.getOrElse(clazz, Nil))
  }

  val clazzesByRace: Map[Race, Seq[Clazz]] = permittedCombos.foldLeft(Map.empty[Race, Seq[Clazz]]) {
    case (map, (race, clazz, _, _)) => map.updated(race, clazz +: map.getOrElse(race, Nil))
  }

  val citiesByRaceClazz: Map[(Race, Clazz), Seq[City]] =
    permittedCombos.foldLeft(Map.empty[(Race, Clazz), Seq[City]]) {
      case (map, (race, clazz, _, city)) => map.updated((race, clazz), city+: map.getOrElse((race, clazz), Nil))
    }

  val beliefsByRaceClazzCity: Map[(Race, Clazz, City), Seq[Belief]] =
    permittedCombos.foldLeft(Map.empty[(Race, Clazz, City), Seq[Belief]]) {
      case (map, (race, clazz, belief, city)) =>
        map.updated((race, clazz, city), belief +: map.getOrElse((race, clazz, city), Nil))
    }

  val races: Seq[Race] = permittedCombos.map(_._1).distinct

  val racesMap: Map[String, Race] = races.map(r => r.getClass.getSimpleName.replaceAllLiterally("$", "").toLowerCase -> r).toMap

  val areasMap: Map[String, Set[City]] = Map(
    Faydwer.toString.toLowerCase -> Set(Kelethin, Kaladim, Felwithe, AkAnon),
    East.toString.toLowerCase -> Set(Grobb, Oggok, Freeport, Neriak, Rivervale),
    West.toString.toLowerCase -> Set(Qeynos, Halas),
    Odus.toString.toLowerCase -> Set(Erudin, Paineel),
    Kunark.toString.toLowerCase -> Set(Cabilis)
  )

}
