package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FigureSpec extends AnyWordSpec {
  formatHead("A Farmer") when {
    "created" should {
      val farmer = new Farmer_Figure
      val matrix = new Matrix().initFill()
      farmer.onBoard should be(true)
    }
    "gets a command" should {
      val farmer = new Farmer_Figure
      val matrix = new Matrix().initFill()
      farmer.command(matrix, "right", "Player1", 2, 2) should be(
        matrix.moveRightU(2, 2)
      )
      farmer.command(matrix, "left", "Player1", 1, 2) should be(
        matrix.moveRightU(1, 2)
      )
      farmer.command(matrix, "left", "Player2", 3, 3) should be(
        matrix.moveLeftL(3, 3)
      )
      farmer.command(matrix, "right", "Player2", 4, 5) should be(
        matrix.moveRightL(4, 5)
      )
    }
  }
  "object Figure " when {
    "applied" should {
      val matrix = new Matrix().initFill()
      val fig = Figure.apply("Dame").command(matrix, "right", "Player2", 4, 5)
      val fig2 = Figure.apply("Farmer").command(matrix, "left", "Player1", 4, 5)
      "be" in {
        fig should be(Dame_Figure().command(matrix, "right", "Player2", 4, 5))
        fig2 should be(Farmer_Figure().command(matrix, "left", "Player1", 4, 5))
      }

    }

  }
}
