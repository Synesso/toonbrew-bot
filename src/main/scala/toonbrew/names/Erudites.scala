package toonbrew.names
import toonbrew.Enums.{Female, Gender, Male}

import scala.util.Random

object Erudites extends Names {

  private val generators: Seq[(Gender) => String] = List(wow)

  def name(gender: Gender): String = {
    choose(generators)(gender)
  }

  private def wow(gender: Gender) = {
    val nm1 = Array("Aer", "Aeri", "Al", "Ala", "Ba", "Bac", "Bae", "Baem", "Baema", "Be", "Bem", "Bema", "Bi", "Bit", "Ca", "Cae", "Caem", "Cam", "Dra", "Drae", "Du", "Duy", "Er", "Eri", "Ha", "Hat", "He", "Her", "In", "Ine", "Inet", "It", "Je", "Jen", "Kee", "Keel", "Kre", "Lo", "Lor", "Ma", "Mat", "Matha", "Me", "Mel", "No", "Nor", "Norae", "Oni", "Pa", "Par", "Pe", "Per", "Qu", "Qui", "Ra", "Rah", "Sa", "Sae", "Saet", "Sat", "So", "Ta", "Tan", "Vy", "Vya", "We", "Wel", "Wele", "Wi", "Win", "Ya", "Yat", "Za", "Zae", "Zan", "Ze", "Zel")
    val nm2 = Array("h", "ha", "hae", "hea", "l", "la", "lae", "le", "m", "ma", "mae", "me", "n", "na", "nae", "ne", "r", "ra", "rae", "re", "t", "th", "", "", "", "", "", "", "", "", "", "", "", "", "")
    val nm3 = Array("'thema", "'themar", "'theas", "'danas", "'daras", "'thul", "'thas", "'thaes", "aen", "aesh", "aeth", "ald", "an", "anis", "aris", "arrin", "as", "ash", "ath", "beron", "den", "dis", "dron", "en", "ean", "eath", "eon", "eron", "esh", "haen", "hean", "hein", "hen", "hin", "iel", "il", "ilan", "illan", "in", "ir", "is", "ith", "laen", "lath", "laeth", "len", "leron", "ma", "mae", "na", "nis", "ren", "rim", "rin", "ris", "ron", "rus", "saen", "sen", "thaen", "than", "us", "ven", "veth", "vaen", "ten", "nae", "neas", "theas", "lae", "laen", "azen", "azhen", "zaen", "zen", "uzen")
    val nm4 = Array("Ael", "Aela", "Aele", "Al", "Ala", "Ale", "Am", "Amo", "Amor", "An", "Az", "Aza", "Azae", "Bel", "Bele", "Ca", "Cae", "Cai", "Cay", "Ce", "Cea", "Cee", "Cel", "Da", "Dae", "Daen", "Dan", "Dar", "Day", "De", "Der", "Dey", "El", "Ela", "Ele", "Em", "Fae", "Fe", "Fey", "Il", "Ile", "Jo", "Jovi", "Ka", "Kal", "Ke", "Keal", "Kee", "Kel", "Ky", "Lae", "Lea", "Li", "Lia", "Ly", "Lyn", "Na", "Nar", "Nat", "No", "Novi", "Ol", "Oli", "Se", "Sed", "Sha", "Sy", "Sye", "Syl", "Ta", "Tal", "Tali", "Tan", "Te", "Tel", "Teli", "Ty", "Tye", "Tyn", "Ve", "Vel", "Vela", "Za", "Zae", "Zan", "Zar", "Zat", "Ze", "Zea", "Zy", "Zya")
    val nm5 = Array("h", "ha", "hae", "hea", "l", "la", "lae", "le", "m", "ma", "mae", "me", "n", "na", "nae", "ne", "r", "ra", "rae", "re", "t", "th", "", "", "", "", "", "", "", "", "", "", "", "", "")
    val nm6 = Array("aena", "alda", "alle", "ana", "anae", "andra", "anea", "ann", "anna", "anne", "anni", "ara", "da", "dine", "dori", "dra", "drae", "drea", "drel", "drin", "drine", "eda", "elda", "eli", "elly", "enna", "era", "erae", "erea", "estra", "iah", "ice", "inda", "ine", "inne", "inth", "ise", "le", "lean", "leane", "len", "lenn", "lenne", "li", "lia", "ly", "na", "nia", "nice", "onia", "ori", "ra", "rae", "rea", "rel", "riah", "rin", "rine", "rise", "vea", "via", "vie", "wae", "we", "wea", "yn", "yna", "ynna")

    gender match {
      case Female if Random.nextBoolean() => s"${choose(nm4)}${choose(nm5)}${choose(nm6)}"
      case Female => s"${choose(nm4)}${choose(nm6)}"
      case Male if Random.nextBoolean() => s"${choose(nm1)}${choose(nm2)}${choose(nm3)}"
      case Male => s"${choose(nm1)}${choose(nm3)}"
    }
  }
}
