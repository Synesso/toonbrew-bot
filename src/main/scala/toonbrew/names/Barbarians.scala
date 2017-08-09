package toonbrew.names


import toonbrew.Enums.{Female, Gender, Male}

import scala.util.Random

object Barbarians extends Names {

  private val nm1 = List("ae", "au", "ei", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
  private val nm2 = List("", "", "", "b", "bl", "br", "bh", "d", "dr", "dh", "f", "fr", "g", "gh", "gr", "gl", "h", "hy", "hr", "j", "k", "kh", "kr", "l", "ll", "m", "n", "p", "pr", "r", "rh", "s", "sk", "sg", "sm", "sn", "st", "t", "th", "thr", "ty", "v", "y")
  private val nm3 = List("bl", "br", "d", "db", "dbr", "dd", "ddg", "dg", "dl", "dm", "dr", "dv", "f", "fd", "fgr", "fk", "fl", "fn", "fr", "fst", "fv", "g", "gb", "gd", "gf", "gg", "ggv", "gl", "gn", "gr", "gss", "gv", "k", "kk", "l", "lb", "lc", "ld", "ldr", "lf", "lfr", "lg", "lgr", "lk", "ll", "llg", "llk", "llv", "lm", "ln", "lp", "lr", "ls", "lsk", "lsn", "lst", "lsv", "lt", "lv", "m", "md", "mk", "ml", "mm", "ms", "n", "nb", "nd", "ndr", "ng", "nl", "nn", "nng", "nr", "nsk", "nt", "nv", "nw", "p", "pl", "pp", "pr", "r", "rb", "rd", "rdg", "rf", "rg", "rgr", "rk", "rkm", "rl", "rls", "rm", "rn", "rng", "rngr", "rnh", "rnk", "rns", "rnv", "rr", "rst", "rt", "rth", "rtm", "rv", "s", "sb", "sbr", "sg", "sgr", "sk", "sl", "sm", "sn", "sr", "ssk", "st", "stm", "str", "sv", "t", "tg", "th", "thg", "thn", "thr", "thv", "tm", "tr", "tt", "ttf", "tv", "v", "yv", "z", "zg", "zl", "zn")
  private val nm4 = List("d", "dr", "f", "g", "kr", "k", "l", "ld", "lf", "lk", "ll", "lr", "m", "mm", "n", "nd", "nn", "r", "rd", "rn", "rr", "s", "th", "t")
  private val nm5 = List("", "", "", "b", "br", "bh", "ch", "d", "dh", "f", "fr", "g", "gh", "gr", "gw", "gl", "h", "j", "k", "kh", "m", "n", "r", "rh", "s", "sh", "st", "sv", "t", "th", "thr", "tr", "v", "w")
  private val nm6 = List("ae", "ea", "ie", "ei", "io", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
  private val nm7 = List("bj", "c", "d", "dd", "df", "dl", "dr", "f", "ff", "fl", "fn", "fr", "fth", "g", "gd", "gm", "gn", "gnh", "gr", "h", "hh", "k", "l", "ld", "lf", "lfh", "lg", "lgr", "lh", "lk", "ll", "lm", "lr", "ls", "lv", "m", "mm", "n", "nd", "ndr", "ng", "ngr", "ngv", "nh", "nl", "nn", "nnh", "nr", "ns", "nt", "nv", "r", "rd", "rf", "rg", "rgh", "rgr", "rh", "rk", "rl", "rm", "rn", "rnd", "rng", "rr", "rst", "rt", "rth", "rtr", "rv", "s", "sb", "sd", "sg", "sh", "sl", "st", "stn", "str", "sv", "t", "thr", "tk", "tr", "tt", "tth", "v", "y", "yj", "ym", "yn")
  private val nm8 = List("", "", "", "", "f", "g", "h", "l", "n", "nn", "s", "sh", "th", "y")

  def name(gender: Gender): String = {
    val i = Random.nextInt(10)
    gender match {
      case Female =>
        val rnd = Random.nextInt(nm2.size)
        val rnd2 = Random.nextInt(nm1.size)
        if (i < 3) {
          nm2(rnd) + nm1(rnd2) + oneOf(nm4) + nm1(rnd2) + oneOf(nm4)
        } else if (i < 8) {
          nm2(rnd) + nm1(rnd2) + oneOf(nm3) + oneOf(if (rnd < 3) nm1.drop(3) else nm1) + oneOf(nm4)
        } else {
          val rnd4 = if (rnd < 3) Random.nextInt(nm1.size - 3) + 3 else Random.nextInt(nm1.size - 3)
          nm2(rnd) + nm1(rnd2) + oneOf(nm3) + nm1(rnd4) + oneOf(nm3) +
            oneOf(if (rnd < 3 || rnd4 < 3) nm1.drop(3) else nm1) + oneOf(nm4)
        }
      case Male =>
        val rnd2 = Random.nextInt(nm6.size)
        val rnd4 = Random.nextInt(nm6.size)
        if (i < 3) {
          oneOf(nm5.filterNot(_.isEmpty)) + oneOf(nm6) + oneOf(nm2) + oneOf(nm6) + oneOf(nm8)
        } else if (i < 8) {
          oneOf(nm5) + nm6(rnd2) + oneOf(nm7) + oneOf(if (rnd2 < 5) nm6.drop(5) else nm6) + oneOf(nm8)
        } else {
          oneOf(nm5) + nm6(rnd2) + oneOf(nm7) + nm6(rnd4) + oneOf(nm7) + oneOf(if (rnd2 < 5 || rnd4 < 5) nm6.drop(5) else nm6)
        }
    }
  }

}
