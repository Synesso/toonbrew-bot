package toonbrew.names

import toonbrew.Choose
import toonbrew.Enums.Gender

trait Names extends Choose {
  def name(gender: Gender): String
}
