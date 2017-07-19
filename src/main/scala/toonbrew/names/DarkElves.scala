package toonbrew.names

import toonbrew.Enums.{Female, Gender, Male}

object DarkElves extends Names {

  private val generators: Seq[(Gender) => String] = List(warhammer _)

  def name(gender: Gender): String = {
    choose(generators)(gender)
  }

  private def warhammer(gender: Gender) = {
    val nm1 = List("c", "d", "g", "k", "l", "m", "n", "q", "r", "t", "v")
    val nm2 = List("a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "ou", "au")
    val nm3 = List("c", "cc", "cr", "ch", "g", "gh", "gr", "gn", "k", "kh", "kr", "kk", "kz", "l", "ll", "lk", "lc", "lg", "n", "nn", "nk", "r", "rv", "rk", "rc", "rg", "rz", "rl", "tr", "th", "vr", "v", "c", "g", "k", "l", "n", "r", "v", "c", "g", "k", "l", "n", "r", "v", "c", "g", "k", "l", "n", "r", "v")
    val nm4 = List("c", "k", "l", "n", "r", "s", "t", "th")
    val nm5 = List("c", "f", "h", "l", "m", "n", "r", "s", "sh", "th", "v")
    val nm6 = List("a", "e", "i", "o")
    val nm7 = List("b", "bh", "c", "ch", "gh", "gg", "h", "hh", "kh", "l", "ll", "lr", "ln", "lv", "r", "rr", "rt", "rl", "rs", "rn", "rv", "s", "ss", "sh", "t", "tt", "th", "v", "vh", "b", "c", "h", "l", "r", "s", "t", "v", "kh", "b", "c", "h", "l", "r", "s", "t", "v", "kh")
    val nm8 = List("h", "n", "l", "sh", "s", "th", "", "", "", "", "")

    gender match {
      case Female => choose(List(
        () => s"${choose(nm5)}${choose(nm6)}${choose(nm7)}${choose(nm6)}${choose(nm8)}",
        () => s"${choose(nm5)}${choose(nm6)}${choose(nm7)}${choose(nm6)}${choose(nm7)}${choose(nm6)}${choose(nm8)}"
      ))()
      case Male => choose(List(
          () => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm4)}",
          () => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm4)}"
        ))()
    }
  }

}
