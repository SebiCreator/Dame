package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class PlayerSpec extends AnyWordSpec {
  formatHead("A Person") when {
    "is a Player" should {
      val player = new Player("John Doe")
      "have a name" in {
        player.name should be("John Doe")
      }
      "have a String representation" in {
        player.toString should be("John Doe")
      }
      "have a counting winningStreak" in {
        player.wins should be(0)
      }
      "which will increase at each win" in {
        player.increaseWinningStreak().wins should be(1)
      }
    }
  }
  formatHead("A Spectator") when {
    "is present " should {
      val spec = new Spectator("Hansele")
      "have a name" in {
        spec.name should be("Hansele")
      }
    }
  }
}
