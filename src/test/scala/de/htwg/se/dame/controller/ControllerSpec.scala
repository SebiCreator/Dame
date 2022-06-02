package de.htwg.se.dame.controllerComponent.controllerBaseImpl

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Lines.modBoardWrapped
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Board
import de.htwg.se.dame.util.Observer

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
        modBoardWrapped(1, matrix.getCells() / 2, matrix.tup())
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
