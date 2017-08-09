package toonbrew

import scala.util.{Random, Try}

trait Choose {
  def choose[T](ts: Seq[T]): Option[T] = Try(ts(Random.nextInt(ts.size))).toOption
  def oneOf[T](ts: Seq[T]): T = choose(ts).get
}
