package toonbrew.names

import toonbrew.Enums.{Female, Gender, Male}

object WoodElves extends Names {

  private val generators: Seq[(Gender) => String] = List(warhammer)

  def name(gender: Gender): String = {
    choose(generators)(gender)
  }

  def warhammer(gender: Gender): String = {

    val nm1 = Array("", "", "", "c", "d", "dh", "g", "k", "kh", "sc", "str", "t", "th", "tr", "v", "z")
    val nm2 = Array("a", "i", "o", "u", "a", "i", "o", "u", "a", "i", "o", "u", "a", "a", "o", "o", "a", "o", "o", "a", "io", "aa", "ae", "ia")
    val nm3 = Array("c", "d", "k", "l", "r", "c", "d", "k", "l", "r", "c", "cc", "cr", "dr", "d", "k", "kk", "lc", "lg", "lk", "ll", "lt", "lv", "l", "r", "rl", "rt", "rc", "rg", "rn", "sc", "sr", "st", "sl", "th", "tr", "tt", "zc", "zk", "zl")
    val nm4 = Array("", "", "", "c", "n", "s", "t", "th")
    val nm5 = Array("", "", "", "", "", "d", "dh", "dr", "f", "h", "l", "m", "n", "ph", "q", "s", "th", "v", "y")
    val nm6 = Array("a", "e", "i", "y", "a", "e", "i", "y", "a", "e", "i", "y", "a", "e", "a", "a", "e", "e", "ie", "ae")
    val nm7 = Array("c", "cc", "ch", "d", "dd", "dr", "h", "hh", "lc", "ll", "lv", "ls", "lt", "lth", "ln", "lm", "l", "n", "nn", "nr", "nv", "nd", "ph", "r", "rl", "rr", "rv", "rl", "s", "ss", "sh", "st", "str", "sv", "t", "th", "tr", "v")
    val nm8 = Array("", "", "", "", "f", "h", "l", "n", "s", "th")

    gender match {
      case Female => choose(List(
        () => s"${choose(nm5)}${choose(nm6)}${choose(nm7)}${choose(nm6)}${choose(nm8)}",
        () => s"${choose(nm5)}${choose(nm6)}${choose(nm7)}${choose(nm6)}${choose(nm7)}${choose(nm8)}"
      ))()
      case Male => choose(List(
        () => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm4)}",
        () => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm4)}"
      ))()
    }
  }

}
