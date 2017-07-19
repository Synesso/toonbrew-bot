package toonbrew.names
import toonbrew.Enums.Gender

object Ogres extends Names {
  private val generators: Seq[(Gender) => String] = List(fantasy)

  def name(gender: Gender): String = {
    choose(generators)(gender)
  }

  def fantasy(gender: Gender): String = {
    val nm1 = Array("B", "Bl", "Br", "D", "Dr", "G", "Gl", "Gr", "K", "Kl", "Kr", "M", "N", "T", "Tr", "V", "Vr", "W", "X", "Y", "Z", "", "", "", "")
    val nm2 = Array("e", "i", "u", "o", "a")
    val nm3 = Array("b", "d", "g", "k", "l", "m", "n", "r", "s", "t", "w", "x", "z", "", "", "", "", "", "", "", "", "")
    val nm4 = Array("g", "k", "rug", "rog", "rag", "ruk", "rok", "kag", "rth", "rub", "rob", "rig", "kohr", "kuhr", "kor", "kur", "ret", "rut", "rot", "kug", "kog", "kig", "keg", "reg", "rek", "rg", "rk", "zar", "zug", "zor", "zag", "zig", "zir", "zur", "nk", "gut", "grut", "grot", "gruk", "grok", "rok", "ruk", "rag", "gark", "gork", "gurk", "kur", "kurk", "kurg", "kor", "kork", "korg", "zog", "zug", "zig", "zrog", "zrug")

    choose(List(
      () => s"${choose(nm1)}${choose(nm2)}${choose(nm4)}",
      () => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}${choose(nm2)}${choose(nm4)}"
    ))()
  }
}
