package toonbrew

import org.scalacheck.Gen
import org.specs2.mutable.Specification
import toonbrew.Enums.City

class ToonSpec extends Specification with ArbitraryInput {

  "city limited toons" should {
    "never have results outside the provided cities" >> prop { cities: Set[City] =>
      Toon.random(None, Some(cities)) must beSome[Toon].like { case toon: Toon =>
        cities must contain(toon.city)
      }
    }.setGen(Gen.nonEmptyListOf(genCity).map(_.toSet))
  }

}
