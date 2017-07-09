package toonbrew.names

import toonbrew.Choose
import toonbrew.Enums.Gender

import scala.util.Random

object DarkElves extends Choose {

  def name(gender: Gender): String = {
    warhammer
  }

  private def warhammer = {
    val nm1 = List("c", "d", "g", "k", "l", "m", "n", "q", "r", "t", "v")
    val nm2 = List("a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "ou", "au")
    val nm3 = List("c", "cc", "cr", "ch", "g", "gh", "gr", "gn", "k", "kh", "kr", "kk", "kz", "l", "ll", "lk", "lc", "lg", "n", "nn", "nk", "r", "rv", "rk", "rc", "rg", "rz", "rl", "tr", "th", "vr", "v", "c", "g", "k", "l", "n", "r", "v", "c", "g", "k", "l", "n", "r", "v", "c", "g", "k", "l", "n", "r", "v")
    val nm4 = List("c", "k", "l", "n", "r", "s", "t", "th")
    val nm5 = List("c", "f", "h", "l", "m", "n", "r", "s", "sh", "th", "v")
    val nm6 = List("a", "e", "i", "o")
    val nm7 = List("b", "bh", "c", "ch", "gh", "gg", "h", "hh", "kh", "l", "ll", "lr", "ln", "lv", "r", "rr", "rt", "rl", "rs", "rn", "rv", "s", "ss", "sh", "t", "tt", "th", "v", "vh", "b", "c", "h", "l", "r", "s", "t", "v", "kh", "b", "c", "h", "l", "r", "s", "t", "v", "kh")
    val nm8 = List("h", "n", "l", "sh", "s", "th", "", "", "", "", "")
    val nm9 = List("amber", "ash", "battle", "blood", "cinder", "dark", "dawn", "dead", "death", "doom", "dread", "dusk", "dust", "ember", "fall", "fallen", "fell", "fire", "flame", "gloom", "grim", "haze", "hell", "nether", "night", "pyre", "rage", "rain", "shade", "shadow", "silent", "skull", "steel", "storm", "thunder", "void", "war", "wild")
    val nm10 = List("arm", "arrow", "axe", "bane", "basher", "binder", "blade", "blaze", "bleeder", "blight", "breaker", "bringer", "caller", "cleaver", "crusher", "cutter", "eye", "eyes", "fall", "fury", "grip", "hand", "heart", "hunter", "mantle", "maul", "might", "more", "reaper", "reaver", "rider", "ripper", "runner", "scar", "seeker", "shade", "shadow", "shard", "slayer", "sorrow", "stalker", "stride", "strike", "striker", "surge", "taker")

    val i = Random.nextInt(10)
    val rnd = Random.nextInt(nm9.size)
    val rnd2 = Random.nextInt(nm10.size)
    val nameL = nm9(rnd) + nm10(rnd2)


    nameL
  }
  
  
}
