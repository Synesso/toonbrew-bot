package toonbrew.names

import toonbrew.Enums.{Female, Gender, Male}

object HighElves extends Names {

  private val generators: Seq[(Gender) => String] = List(dnd, rift)

  def name(gender: Gender): String = {
    oneOf(generators)(gender)
  }

  def dnd(gender: Gender): String = {
    gender match {
      case Female =>
        val n1 = Array("Ael", "Aem", "Aer", "Aern", "Aest", "Ag", "Aghn", "Ail", "Aiy", "Alis", "Am", "Amay", "Aoib", "Awen", "Brian", "Brig", "Cael", "Caen", "Cainn", "Ceall", "Cear", "Chey", "Daer", "Deir", "Don", "Eab", "Ead", "Eil", "Eist", "Eor", "Eten", "Faen", "Fen", "Fin", "Finn", "Gael", "Gel", "Hat", "Kim", "Kol", "Laen", "Leen", "Lenm", "Maed", "Maen", "Maer", "Maev", "Mag", "Mair", "Med", "Mig", "Moir", "Mor", "Muir", "Naem", "Nam", "Nual", "On", "Onid", "Orl", "Ros", "Saen", "Shan", "Sib", "Sor", "Taer", "Tak", "Ter", "Wak", "Wik", "Yok")
        val n2 = Array("aela", "aelah", "aena", "aene", "aenon", "aid", "aigen", "aimh", "aine", "aith", "ala", "alae", "alasa", "ane", "angwa", "ania", "anne", "anon", "aoin", "aoine", "athla", "auma", "awa", "eal", "eala", "eamhna", "eann", "ear", "earca", "eekoni", "een", "eine", "eis", "enda", "enia", "enna", "iav", "ighid", "ilahi", "ilin", "ine", "inita", "inka", "inn", "iona", "ionn", "irin", "irne", "is", "ise", "ish", "ita", "odhna", "oise", "oma", "ona", "oni", "onora", "ose", "ovi", "uala", "uanee", "ulah", "unia", "uoia")
        s"${oneOf(n1)}${oneOf(n2)}"
      case Male =>
        val n1 = Array("Ad", "Ae", "Bal", "Bei", "Car", "Cra", "Dae", "Dor", "El", "Ela", "Er", "Far", "Fen", "Gen", "Glyn", "Hei", "Her", "Ian", "Ili", "Kea", "Kel", "Leo", "Lu", "Mira", "Mor", "Nae", "Nor", "Olo", "Oma", "Pa", "Per", "Pet", "Qi", "Qin", "Ralo", "Ro", "Sar", "Syl", "The", "Tra", "Ume", "Uri", "Va", "Vir", "Waes", "Wran", "Yel", "Yin", "Zin", "Zum")
        val n2 = Array("balar", "beros", "can", "ceran", "dan", "dithas", "faren", "fir", "geiros", "golor", "hice", "horn", "jeon", "jor", "kas", "kian", "lamin", "lar", "len", "maer", "maris", "menor", "myar", "nan", "neiros", "nelis", "norin", "peiros", "petor", "qen", "quinal", "ran", "ren", "ric", "ris", "ro", "salor", "sandoral", "toris", "tumal", "valur", "ven", "warin", "wraek", "xalim", "xidor", "yarus", "ydark", "zeiros", "zumin")
        s"${oneOf(n1)}${oneOf(n2)}"
    }
  }
  
  def rift(gender: Gender): String = {
    gender match {
      case Female =>
        val n1 = Array("Ael", "Aem", "Aer", "Aern", "Aest", "Ag", "Aghn", "Ail", "Aiy", "Alis", "Am", "Amay", "Aoib", "Awen", "Brian", "Brig", "Cael", "Caen", "Cainn", "Ceall", "Cear", "Chey", "Daer", "Deir", "Don", "Eab", "Ead", "Eil", "Eist", "Eor", "Eten", "Faen", "Fen", "Fin", "Finn", "Gael", "Gel", "Hat", "Kim", "Kol", "Laen", "Leen", "Lenm", "Maed", "Maen", "Maer", "Maev", "Mag", "Mair", "Med", "Mig", "Moir", "Mor", "Muir", "Naem", "Nam", "Nual", "On", "Onid", "Orl", "Ros", "Saen", "Shan", "Sib", "Sor", "Taer", "Tak", "Ter", "Wak", "Wik", "Yok")
        val n2 = Array("aela", "aelah", "aena", "aene", "aenon", "aid", "aigen", "aimh", "aine", "aith", "ala", "alae", "alasa", "ane", "angwa", "ania", "anne", "anon", "aoin", "aoine", "athla", "auma", "awa", "eal", "eala", "eamhna", "eann", "ear", "earca", "eekoni", "een", "eine", "eis", "enda", "enia", "enna", "iav", "ighid", "ilahi", "ilin", "ine", "inita", "inka", "inn", "iona", "ionn", "irin", "irne", "is", "ise", "ish", "ita", "odhna", "oise", "oma", "ona", "oni", "onora", "ose", "ovi", "uala", "uanee", "ulah", "unia", "uoia")
        s"${oneOf(n1)}${oneOf(n2)}"
      case Male =>
        val n1 = Array("Adh", "Ag", "Ahm", "Ail", "Ain", "An", "Aodh", "Apen", "Ar", "Bair", "Baol", "Bean", "Beol", "Cadh", "Cail", "Caim", "Caol", "Ceall", "Cean", "Cher", "Cill", "Col", "Con", "Dak", "Deam", "Dels", "Din", "Each", "Eam", "Ear", "Earn", "Eimh", "Eir", "Eirn", "Eog", "Fael", "Fear", "Fer", "Fin", "Finn", "Greag", "Hahn", "Hint", "Hon", "Kel", "Lans", "Maed", "Mael", "Maodh", "Maoil", "Mis", "Mok", "Muat", "Muir", "Niadh", "Ohan", "PAid", "Pead", "Raem", "Saem", "Seam", "Sen", "Taim", "Tas", "Tok", "Wak", "Wan", "Yis", "Yum")
        val n2 = Array("amh", "in", "onn", "ear", "ach", "aire", "ithir", "ileas", "os", "amcha", "uan", "oine", "ionn", "alach", "eart", "ainn", "aon", "easal", "eall", "adh", "air", "eidigh", "obhar", "uil", "ionan", "uimin", "eaglan", "ang", "ead", "eal", "aidh", "earn", "onn", "anan", "ainin", "iarn", "ainm", "iachna", "ias", "asan", "uaire", "erian", "airian", "ainn", "aoilin", "ios", "each", "eamas", "eanan", "amh", "anu", "ando", "imon", "oki", "eyo", "unta", "oda", "otah", "osan", "emin", "abaoo", "omemah", "ahome", "aneo", "on", "otah", "oton", "ehew", "aska", "enam", "iye", "achme", "opka", "etu", "ahton")
        s"${oneOf(n1)}${oneOf(n2)}"
    }
    
  }

}
