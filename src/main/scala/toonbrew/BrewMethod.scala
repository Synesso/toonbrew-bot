package toonbrew

sealed trait BrewMethod
case object ClassFirst extends BrewMethod
case object RaceFirst extends BrewMethod
//case object D100 extends BrewMethod

object BrewMethod {
  private val byName = List(ClassFirst, RaceFirst)
    .map(m => m.toString.replace("First", "").toLowerCase -> m).toMap

  def forName(n: String): Option[BrewMethod] = byName.get(n)

  def acceptedValues: Seq[String] = byName.keys.toList.sorted

}
