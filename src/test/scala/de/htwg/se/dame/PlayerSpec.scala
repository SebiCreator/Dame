package de.htwg.se.dame

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class PlayerSpec extends AnyWordSpec {
  "A Player" when {
    "new" should {
      val player = Player("John Doe")
      "have a name" in {
        player.name should be("John Doe")
      }
      "have a String representation" in {
        player.toString should be("John Doe")
      }
    }
  }
}
