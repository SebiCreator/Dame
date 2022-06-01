package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MatrixSpec extends AnyWordSpec with Matchers {
  formatText(
    "A Matrix is a tailored Data Structure to capture Board coordinate it"
  ) should {
    val default = new Matrix()
    default.player1 should be(Player1())
    default.player1.toString should be("X")
    default.player2 should be(Player2())
    default.player2.toString should be("X")
    val test = new Matrix()
    test.cells should be(6)
    test.data should be(Nil)
    val normalBoard = new Matrix(Nil, 8, Player1("X"), Player2("O"))
    normalBoard.cells should be(8)
    normalBoard.player1 should be(Player1("X"))
    normalBoard.player2 should be(Player2("O"))
    val internationBoard = new Matrix(Nil, 10, Player1("A"), Player2("B"))
    internationBoard.cells should be(10)
  }
  formatText("Init Fill initializes the StartBoard it") should {
    val default = new Matrix().initFill()
    default.data(1) should be(List(1, 0, 1, 0, 1, 0))
    default.data(3) should be(List(0, 0, 0, 0, 0, 0))
    default.data(5) should be(List(2, 0, 2, 0, 2, 0))
  }
  formatText(
    "numToPlayer assigns every int the corresponding Player Symbol it"
  ) should {
    val default = new Matrix().initFill()
    val player1 = default.numToPlayer(1)
    player1 should be("X")
    val player2 = default.numToPlayer(2)
    player2 should be("X")
  }
  formatText("tup returns the Board Data as tuples for printing and") should {
    val default = new Matrix().initFill()
    val tuple = default.tup()
    tuple(1) should be(List(("X", " "), ("X", " "), ("X", " ")))
  }
  formatText(
    "replace cell changes the instance on the given coordinate and"
  ) should {
    val default = new Matrix().initFill()
    val replaced = default.replaceCell(0, 0, 2)
    replaced.data(0) should be(List(2, 1, 0, 1, 0, 1))
    val replaced1 = default.replaceCell(1, 1, 9)
    replaced1.data(1) should be(List(1, 9, 1, 0, 1, 0))
    val replaced2 = default.replaceCell(2, 4, 4)
    replaced2.data(2) should be(List(0, 0, 0, 0, 4, 0))
  }
  formatText(
    "cellIsEmpty returns a boolean value if cell is empty or not and"
  ) should {
    val default = new Matrix().initFill()
    default.cellIsEmpty(0, 0) should be(true)
    default.cellIsEmpty(5, 0) should be(false)
  }

  formatText(
    "rightMovePossibleL returns if lower player can move left given the arg coordinates it"
  ) should {
    val default = new Matrix().initFill()
    default.rightMovePossibleL(4, 0) should be(true)
    default.rightMovePossibleL(1, 0) should be(true)
  }

  formatText(
    "rightMovePossibleU returns if upper player can move left given the arg coordinates it"
  ) should {
    val default = new Matrix().initFill()
    default.rightMovePossibleU(1, 3) should be(true)
    default.rightMovePossibleU(1, 0) should be(false)
  }

  formatText(
    "leftMovePossibleL returns if lower player can move left given the arg coordinates it"
  ) should {
    val default = new Matrix().initFill()
    default.leftMovePossibleL(4, 3) should be(true)
    default.leftMovePossibleL(4, 0) should be(false)
  }

  formatText(
    "leftMovePossibleU returns if upper player can move left given the arg coordinates it"
  ) should {
    val default = new Matrix().initFill()
    default.leftMovePossibleU(2, 2) should be(true)
    default.leftMovePossibleU(4, 0) should be(true)
  }

  formatText(
    "moveLeftL if possible moves the lower player to the left"
  ) should {
    val matrix = new Matrix().initFill()
    matrix.moveLeftL(4, 1).data(4) should be(List(0, 0, 0, 2, 0, 2))
  }

  formatText(
    "moveLeftU if possible moves the upper player to the left"
  ) should {
    val matrix = new Matrix().initFill()
    matrix.moveLeftU(1, 1).data(1) should be(List(1, 0, 1, 0, 1, 0))
  }

  formatText(
    "moveLeftU if possible moves the upper player to the right"
  ) should {
    val matrix = new Matrix().initFill()
    matrix.moveRightU(1, 1).data(2) should be(List(0, 0, 0, 0, 0, 0))
  }
  formatText(
    "moveLeftU if possible moves the upper player to the right"
  ) should {
    val matrix = new Matrix().initFill()
    matrix.moveRightL(4, 2).data(3) should be(List(0, 0, 0, 0, 0, 0))
  }

  formatText(
    "movePossible checks if there are possible move for the according figure"
  ) should {
    val m = Matrix().initFill()
    m.movePossible("upper", "left", 1, 1) should be(true)
    m.movePossible("upper", "right", 1, 1) should be(true)
    m.movePossible("lower", "right", 4, 2) should be(true)
    m.movePossible("lower", "left", 4, 1) should be(true)
  }

  formatText(
    "whichFigure provides the Figure at a given position"
  ) in {
    val test = Matrix().initFill()
    val dame1 = test.replaceCell(0, 0, 3)
    val dame2 = test.replaceCell(1, 1, 4)

    dame1.whichFigure(0, 0) should be("dame")
    dame2.whichFigure(1, 1) should be("dame")
    test.whichFigure(1, 0) should be("farmer")
    test.whichFigure(4, 1) should be("farmer")
    test.whichFigure(3, 3) should be("leer")
  }

  formatText(
    "the killPossible commands return a bool if its possible" +
      "and do the move"
  ) in {
    val testMatrix =
      Matrix()
        .initFill()
        .replaceCell(2, 1, 2)
        .replaceCell(3, 1, 1)
        .replaceCell(3, 4, 1)

    testMatrix.rightKillPossibleU(2, 3) should be(false)
    testMatrix.rightKillPossibleU(1, 2) should be(true)

    testMatrix.leftKillPossilbeU(1, 0) should be(true)
    testMatrix.leftKillPossilbeU(1, 2) should be(false)

    testMatrix.leftKillPossilbeL(3, 2) should be(false)
    testMatrix.leftKillPossilbeL(4, 2) should be(true)

    testMatrix.rightKillPossibleL(4, 3) should be(true)
    testMatrix.rightKillPossibleL(4, 1) should be(false)

    val killMatrixRU =
      testMatrix.killRightU(1, 2).data(2) should be(List(0, 0, 0, 0, 0, 0))

    val killMatrixLU =
      testMatrix.killLeftU(1, 0).data(2) should be(List(0, 0, 0, 0, 0, 0))

    val killMatrixLL =
      testMatrix.killLeftL(4, 5).data(3) should be(List(0, 1, 0, 0, 0, 0))

    val killMatrixRL =
      testMatrix.killRightL(4, 3).data(4) should be(List(0, 2, 0, 0, 0, 2))
  }

}
