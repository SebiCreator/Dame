package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FigureSpec extends AnyWordSpec {
  formatHead("A Farmer") when {
    "created" should {
      val farmer = Farmer_Figure
      val matrix = new Matrix().initFill()
      farmer.onBoard should be(true)
    }
    "gets a command" should {
      val farmer = Farmer_Figure
      val matrix = new Matrix().initFill()

      farmer(matrix, "right", "Player1", 2, 2) should be(
        matrix.moveRightU(2, 2)
      )

      farmer(matrix, "left", "Player1", 1, 2) should be(
        matrix.moveLeftU(1, 2)
      )

      farmer(matrix, "left", "Player2", 3, 3) should be(
        matrix.moveLeftL(3, 3)
      )
      farmer(matrix, "right", "Player2", 4, 5) should be(
        matrix.moveRightL(4, 5)
      )

      farmer.command_upper(matrix, "left", 3, 3) should be(
        matrix.moveLeftU(3, 3)
      )
      farmer.command_upper(matrix, "right", 4, 4) should be(
        matrix.moveRightU(4, 4)
      )
      farmer.command_upper(matrix, "right-kill", 3, 3) should be(
        matrix.killRightU(3, 3)
      )
      farmer.command_upper(matrix, "left-kill", 3, 3) should be(
        matrix.killLeftU(3, 3)
      )

      farmer.command_lower(matrix, "left", 2, 2) should be(
        matrix.moveLeftL(2, 2)
      )
      farmer.command_lower(matrix, "right", 2, 2) should be(
        matrix.moveRightL(2, 2)
      )
      farmer.command_lower(matrix, "right-kill", 3, 3) should be(
        matrix.killRightL(3, 3)
      )
      farmer.command_lower(matrix, "left-kill", 3, 3) should be(
        matrix.killLeftL(3, 3)
      )
    }
  }
  formatHead("A Dame") when {
    "created" in {
      val dame = Dame_Figure
      val matrix = new Matrix()
        .initFill()
        .replaceCell(2, 1, 4)
        .replaceCell(3, 1, 4)
        .replaceCell(3, 4, 4)

      dame.onBoard should be(true)
      dame(matrix, "right-kill", "Player2", 4, 3) should be(
        matrix.killRightL(4, 3)
      )

      dame(matrix, "left-kill", "Player2", 4, 5) should be(
        matrix.killLeftL(4, 5)
      )

      dame(matrix, "right-kill", "Player1", 1, 2) should be(
        matrix.killRightU(1, 2)
      )
      dame(matrix, "left-kill", "Player1", 1, 0) should be(
        matrix.killLeftU(1, 0)
      )
    }
  }

}
