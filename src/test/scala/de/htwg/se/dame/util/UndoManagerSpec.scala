package de.htwg.se.dame.util
import de.htwg.se.dame.model.{Board, Matrix}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class UndoManagerSpec extends AnyWordSpec with Matchers {
  "The UndoManager" should {
    val manager = new UndoManager
    var matrix = Board()
    val testMatrix = Board()
    testMatrix.move("left", 1, 0)

    "doStep should add a move on the Stack" in {
      manager.doStep(matrix)
      manager.undoStep(Some(testMatrix)).get should be(matrix)
    }
    "redo should remove the last move off the stack" in {
      manager.redoStep.get should be(testMatrix)
    }
  }
}
