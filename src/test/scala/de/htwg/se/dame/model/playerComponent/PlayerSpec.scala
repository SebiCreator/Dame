package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

import de.htwg.se.dame.model.gameComponent._
import de.htwg.se.dame.model.figureComponent.figureBaseImpl._
import de.htwg.se.dame.model.playerComponent.playerBaseImpl._

class PlayerSpec extends AnyWordSpec {
  formatHead("A Person") when {
    "is a Player" should {
      val player1 = new Player1("John Doe")
      "have a name" in {
        player1.name should be("John Doe")
      }
      "have a String representation" in {
        player1.toString should be("Player1(John Doe)")
      }

      val name = "John Doe"
      val player2 = new Player2(name)
      "havei a name" in {
        player2.name should be("John Doe")
      }
      "havee a String representation" in {
        player2.toString should be("Player2(John Doe)")
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
