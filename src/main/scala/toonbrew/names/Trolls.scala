package toonbrew.names

import toonbrew.Enums.{Female, Gender, Male}

object Trolls extends Names {
  private val generators: Seq[(Gender) => String] = List(fantasy, wow)

  def name(gender: Gender): String = {
    oneOf(generators)(gender)
  }

  def fantasy(gender: Gender): String = {
    val male = Array("Ditid", "Quivilt", "Mohanlal", "Sollix", "Equinus", "Gamjee", "Matuna", "Kurzol", "Erodjan", "Alwan", "Anje", "Azibo", "Ajin", "Ekon", "Erasto", "Haijen", "Hamedi", "Hokima", "Jaafan", "Jabir", "Jalai", "Javyn", "Jijel", "Juma", "Jumoke", "Kaijin", "Kazko", "Maalik", "Makas", "Malak", "Nyabingi", "Rahjin", "Rakash", "Rashi", "Razi", "Reji", "Rujabu", "Rujin", "Seji", "Senwe", "Seshi", "Teshi", "Tzane", "Tzuljin", "Voyambi", "Vuzashi", "Vuzembi", "Yamike", "Yavo", "Yawan", "Zaejin", "Zallah", "Zebajin", "Zelaji", "Zevrij", "Zinjo", "Zufem", "Alzim", "Ayagi", "Ayargajin", "Dorkuraz", "Hakalai", "Halasuwa", "Hokajin", "Hoodah", "Hyptu", "Jaryaya", "Jayunya", "Jinjin", "Jojin", "Kelraz", "Kuroji", "Lakjin", "Laojin", "Melkree", "Mezilkree", "Napokue", "Nuenvan", "Paikei", "Rapshider", "Rhazin", "Shaktilar", "Shengis", "Sligo", "Tanjin", "Tazingo", "Tedar", "Trezzahn", "Trolgar", "Ttarmek", "Ugoki", "Vekuzz", "Venjo", "Vulzal", "Wanjin", "Wonjin", "Xukundi", "Yetu", "Zengu", "Zoljin", "Zulabar", "Zulbaljin", "Zulgeteb", "Zulkaz", "Zulkis", "Zulrajas", "Zulyafi", "Zunabar")
    val female = Array("Gilta", "Vitchen", "Tirezi", "Fefeya", "Aradya", "Nepita", "Damari", "Meenah", "Kenaya", "Vriska", "Ajia", "Aketa", "Altoa", "Aszea", "Atae", "Azra", "Ecia", "Ejie", "Eleja", "Esha", "Illa", "Kea", "Keja", "Kina", "Kiya", "Kizi", "Moza", "Oyana", "Raca", "Rasha", "Seshia", "Suja", "Suli", "Talisa", "Tasiya", "Tayo", "Teja", "Teza", "Tezzi", "Tizali", "Xia", "Yaci", "Yajdna", "Yashi", "Yera", "Yeree", "Yesha", "Yishi", "Zara", "Zashi", "Zea", "Zelea", "Zesa", "Zeti", "Zola", "Zoti", "Zujia", "Zyra", "Alunja", "Anji", "Arany", "Bajin", "Baliaja", "Benni", "Bie", "Boonoo", "Bunjin", "Csini", "Feylin", "Girisha", "Hailith", "Ithra", "Javilla", "Javinda", "Jezemalu", "Jinthaiya", "Jiranty", "Jozala", "Jubukraa", "Juljin", "Kanjin", "Katanja", "Katzine", "Khelynn", "Khijazi", "Khuwei", "Kululu", "Lujin", "Makali", "Mandula", "Meimei", "Melelea", "Nelina", "Prerrahar", "Pujati", "Rangi", "Renjai", "Renji", "Ronjaty", "Saedmara", "Saonji", "Segawa", "Senzala", "Shadrala", "Shakawatha", "Shaktila", "Shamra", "Sharimara", "Shubre", "Soniya", "Sonja", "Suliya", "Sulynn", "Titamor", "Tsaijo", "Usitutie", "Valja", "Vanjin", "Venmara", "Vinji", "Vinjin", "Vonjai", "Vujii", "Vulzala", "Watu", "Yuhai", "Zalma", "Zalmea", "Zenma", "Zhonya", "Zhoumai", "Ziataaman", "Ziataima", "Ziataja", "Ziatajie", "Ziatakraa", "Zonraja", "Zulja", "Zulja", "Zuljah", "Zuljin", "Zulkraa", "Zulmara", "Zulraja", "Zulrea", "Zulwatha")
    gender match {
      case Female => oneOf(female)
      case Male => oneOf(male)
    }
  }

  def wow(gender: Gender): String = {
    val nm1 = Array("Al", "An", "Azi", "Dru", "Druk", "Hai", "Hak", "Haka", "Haku", "Ham", "Han", "Hana", "Hok", "Hoki", "Huka", "Ja", "Jal", "Jan", "Jar", "Jes", "Jin", "Ju", "Jum", "Jun", "Kai", "Kaz", "Kel", "Ko", "Kor", "Ku", "Kur", "Kuz", "Li", "Lin", "Maal", "Mal", "Muz", "Mul", "Mal", "Pel", "Pele", "Rah", "Rak", "Rap", "Ras", "Raz", "Rej", "Reji", "Rhaz", "Rhuz", "Ruja", "Ruz", "Seji", "Sen", "Ses", "Sesh", "Sez", "Sha", "Shak", "She", "Shen", "Sin", "Shun", "Tan", "Taz", "Tes", "Tesh", "Traz", "Trez", "Tun", "Tzal", "Tzan", "Tzul", "Tzun", "Ugo", "Um", "Un", "Ur", "Uthel", "Ven", "Vol", "Vu", "Vul", "Vuz", "Vuza", "Vuze", "Wan", "Won", "Wun", "Xan", "Xen", "Xon", "Xu", "Xuk", "Xun", "Za", "Zae", "Zaej", "Zal", "Zan", "Zando", "Zax", "Zeb", "Zel", "Zela", "Zen", "Zendo", "Zes", "Zil", "Zilzi", "Zin", "Zol", "Zon", "Zu", "Zub", "Zuba", "Zuf", "Zul", "Zula", "Zulya", "Zun", "Zuva", "Zux", "Val", "Van", "Vun", "Vin", "Von", "Kan", "Kun", "Kuz", "Jam", "Jama", "Jum", "Juma", "Jun", "Jan", "Juna", "Zal", "Sal", "Zala", "Zula", "Zalu", "Gol", "Gul", "Gal", "Mug", "Mig", "Ros", "Rus")
    val nm2 = Array("aj", "uj", "ij", "az", "uz", "iz", "ah", "uh", "an", "un", "on", "ajin", "ujin", "ijin", "nan", "nun", "non", "mun", "mon", "ju", "ji", "za", "zu", "zul", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
    val nm3 = Array("'Ahjen", "'Ahjin", "'Anjin", "'Aya", "'Cha", "'Do", "'Gan", "'Ghan", "'Ijen", "'Jabu", "'Jian", "'Jin", "'Keiki", "'Kyo", "'Mak", "'Mon", "'Nanji", "'Nanju", "'Nay", "'Oji", "'Ojin", "'Rimon", "'Shalay", "'Sora", "'Thuwa", "'Tish", "'To", "'Uljin", "'Ulkaz", "'Umijo", "'Unjin", "'Unya", "'Zan", "abar", "agi", "ahjen", "ahjin", "aji", "ajin", "akijin", "akjin", "alai", "alik", "ambi", "amijo", "amike", "ane", "anjin", "anjo", "armek", "ash", "ashi", "asuwa", "avo", "awan", "aya", "azin", "azko", "bin", "bir", "bu", "cha", "do", "ejin", "embi", "engu", "eshi", "ga", "gajin", "gan", "ghan", "gu", "hjin", "ijen", "ima", "ingi", "injo", "jabu", "jel", "jian", "jin", "ju", "kalai", "keiki", "kima", "kuraz", "kyo", "lai", "laji", "lak", "ma", "mak", "mbu", "medi", "mok", "mon", "nanji", "nanju", "nay", "odah", "oji", "ojin", "oku", "raz", "rimon", "ru", "shalay", "sora", "thal", "thil", "thul", "thuwa", "tish", "to", "ulabar", "uljin", "ulkaz", "umijo", "umike", "ungu", "unjin", "unjo", "unya", "uraz", "wan", "yambi", "ypto", "yptu", "zahn", "zan", "zibin", "zibo", "zim")
    val nm4 = Array("Aj", "Aji", "Ak", "Ake", "Al", "Alu", "Alun", "An", "Anji", "Anju", "Ar", "Ara", "As", "Asze", "At", "Ate", "Ba", "Baji", "Bal", "Bala", "Bali", "Balli", "Ben", "Beni", "Benni", "Bi", "Bie", "Bo", "Boo", "Boon", "Bul", "Bula", "Buli", "Bulli", "Bulu", "Bun", "Dei", "Eci", "Eji", "El", "Ele", "Fey", "Gir", "Ha", "Hai", "Hola", "Hula", "Il", "Ila", "Illa", "Jam", "Jama", "Jan", "Jav", "Java", "Juv", "Juva", "Ka", "Kai", "Kan", "Kat", "Kata", "Katu", "Ke", "Kea", "Kej", "Khel", "Khij", "Khuj", "Khul", "Khuw", "Ki", "Kin", "Kiya", "Kiz", "Kizi", "Kulu", "Kuz", "Luj", "Luji", "Maka", "Man", "Mei", "Mele", "Mo", "Moz", "Nele", "Neli", "Puj", "Puja", "Ra", "Rac", "Ran", "Rash", "Ren", "Ron", "Sae", "Saen", "Saj", "Sal", "Saon", "Sega", "Sen", "Sesh", "Sha", "Shak", "Shaka", "Sham", "Shari", "Sia", "Sian", "Son", "Soni", "Suj", "Sul", "Suli", "Suly", "Tal", "Tas", "Tay", "Tayo", "Tazzi Tizzi", "Te", "Tej", "Teja", "Tez", "Teza", "Tezzi", "Tiz", "Tiza", "Tul", "Tus", "Un", "Unji", "Vaj", "Val", "Van", "Ve", "Veh", "Vehe", "Ven", "Vin", "Von", "Vuj", "Vul", "Vun", "Xi", "Xia", "Xu", "Ya", "Yah", "Yash", "Yashi", "Ye", "Yer", "Yera", "Yi", "Yishi", "Yu", "Yuh", "Za", "Zael", "Zaj", "Zal", "Zam", "Zar", "Zara", "Zashi", "Ze", "Zea", "Zeal", "Zel", "Zele", "Zen", "Zesa", "Zeti", "Zhon", "Zia", "Zir", "Zola", "Zolla", "Zoti", "Zu", "Zuj", "Zul", "Zula", "Zulla", "Zur", "Zyr")
    val nm6 = Array("'Anji", "'Aya", "'Dur", "'Enji", "'Eza", "'Jen", "'Jin", "'Jun", "'Kelah", "'Mahi", "'Tsu", "'Ujia", "'Unji", "'Unna", "'Zali", "'Zula", "'Zuli", "aca", "aci", "ajia", "ajie", "ajin", "ala", "alae", "alu", "amja", "amor", "andi", "ani", "anja", "anji", "any", "ara", "ari", "asha", "ashi", "atha", "aty", "aya", "ayo", "azae", "azea", "azi", "azra", "di", "dur", "eja", "ejie", "elea", "emalu", "ena", "enji", "era", "esa", "esha", "eshia", "eta", "eti", "eza", "ezzi", "hena", "ia", "iaja", "ijazi", "ijo", "ila", "ilith", "ina", "inda", "ini", "ino", "isa", "ishi", "ixia", "iya", "izali", "izi", "ja", "jari", "jin", "kelah", "lynn", "mahi", "mei", "ola", "ona", "onji", "onna", "onoo", "oti", "oza", "ra", "raa", "shia", "siya", "toa", "uja", "ujia", "ujin", "ukraa", "ula", "ulae", "ulea", "uli", "ulli", "ullu", "ulu", "una", "unja", "unjin", "unna", "usah", "usha", "utie", "uwei", "uxia", "uzzi", "watha", "ylin", "yra", "zae", "zali", "zari", "zea", "zula", "zuli")
    gender match {
      case Female => s"${oneOf(nm4)}${oneOf(nm2)}${oneOf(nm6)}"
      case Male => s"${oneOf(nm1)}${oneOf(nm2)}${oneOf(nm3)}"
    }
  }
}
