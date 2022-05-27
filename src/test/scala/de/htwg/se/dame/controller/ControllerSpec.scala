package de.htwg.se.dame.Controller

import org.scalatest.matchers.should.Matchers._
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.model.Matrix
import de.htwg.se.dame.util.Observer
import de.htwg.se.dame.model.Board
import de.htwg.se.dame.model.*
import org.scalatest.matchers.must.Matchers

class ControllerSpec extends AnyWordSpec with Matchers {
  "The Controller" should {
    val board = Board()
    val matrix = Matrix().initFill()
    val controller = Controller(None)
    val testController = Controller(Some(matrix))

    "getMatrix returns the uderlying Matrix" in {
      controller.getMatrix() should be(None)
      testController.getMatrix().get should be(matrix)
    }

    "print the matrix" in {
      testController.getPrintData() should be(
        modBoardWrapped(1, matrix.cells / 2, matrix.tup())
      )
    }
    "get the current player" in {
      testController.currentPlayer() should be("Player1")
    }

    "call a move on the current board" in {
      testController.playtest("left", 1, 0).get should be(
        matrix.replaceCell(1, 0, 0).replaceCell(2, 1, 1).changePlayer()
      )
    }

    "notify its observers on change" in {
      class TestObserver(controller: Controller) extends Observer:
        controller.add(this)
        var bing = false
        def update = bing = true
      val testObserver = TestObserver(controller)
      testObserver.bing should be(false)
    }
  }
}
