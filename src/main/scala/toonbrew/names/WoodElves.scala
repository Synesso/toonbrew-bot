package toonbrew.names

import toonbrew.Enums.{Female, Gender, Male}

object WoodElves extends Names {

  private val generators: Seq[(Gender) => String] = List(warhammer)

  def name(gender: Gender): String = {
    oneOf(generators)(gender)
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
      case Female => oneOf(List(
        () => s"${oneOf(nm5)}${oneOf(nm6)}${oneOf(nm7)}${oneOf(nm6)}${oneOf(nm8)}",
        () => s"${oneOf(nm5)}${oneOf(nm6)}${oneOf(nm7)}${oneOf(nm6)}${oneOf(nm7)}${oneOf(nm8)}"
      ))()
      case Male => oneOf(List(
        () => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm4)}",
        () => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm4)}"
      ))()
    }
  }

}
