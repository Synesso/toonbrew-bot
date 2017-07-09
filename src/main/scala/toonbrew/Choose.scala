package toonbrew

import scala.util.Random

trait Choose {
  def choose[T](ts: Seq[T]): T = ts(Random.nextInt(ts.size))
}
