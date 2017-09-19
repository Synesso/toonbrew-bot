package toonbrew

import org.scalacheck.{Arbitrary, Gen}
import org.specs2.ScalaCheck
import toonbrew.Enums._

trait ArbitraryInput extends ScalaCheck {

  implicit val arbCity: Arbitrary[City] = Arbitrary(genCity)

  def genCity: Gen[City] = Gen.oneOf(Cabilis, Erudin, Felwithe, Freeport, Grobb, Halas, Kaladim, Kelethin, Neriak,
    Oggok, Paineel, Qeynos, Rivervale)

}
