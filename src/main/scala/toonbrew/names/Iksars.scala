package toonbrew.names

import toonbrew.Enums.Gender

object Iksars extends Names {

  private val generators: Seq[(Gender) => String] = List(warhammer)

  def name(gender: Gender): String = {
    oneOf(generators)(gender)
  }

  def warhammer(gender: Gender): String = {

    val nm = Array("c", "cr", "ch", "g", "h", "kr", "m", "n", "q", "qr", "t", "tl", "x", "xlt", "y", "z")
    val nm1 = Array("", "", "", "", "", "c", "cr", "ch", "g", "h", "kr", "m", "n", "q", "qr", "t", "tl", "x", "xlt", "y", "z")
    val nm2 = Array("a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "oa", "aui", "a'u", "o'e", "o'a", "u'a", "a'e", "e'a")
    val nm3 = Array("c", "cc", "ch", "cht", "chtl", "cn", "ct", "ctl", "d", "h", "hc", "hg", "hp", "ht", "htl", "htz", "k", "kt", "l", "lch", "lh", "ll", "lm", "ln", "lp", "lt", "lx", "m", "n", "nd", "nh", "nq", "nt", "ntl", "p", "q", "r", "szc", "t", "tl", "tt", "tz", "tzc", "tzp", "tzt", "x", "xc", "xch", "xt", "xtl", "xy", "y", "z", "zc", "zd", "zq", "ztl")
    val nm4 = Array("", "", "", "c", "ch", "cl", "k", "l", "n", "p", "r", "tl", "x")
    val nm5 = Array("c", "ch", "cl", "k", "l", "n", "p", "r", "tl", "x")

    oneOf(List(
      () => s"${oneOf(nm)}${oneOf(nm2)}${oneOf(nm5)}${oneOf(nm)}${oneOf(nm2)}${oneOf(nm3)}",
      () => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm4)}",
      () => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm3)}",
      () => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}${oneOf(nm2)}${oneOf(nm4.drop(3))}"
    ))()
  }

}
