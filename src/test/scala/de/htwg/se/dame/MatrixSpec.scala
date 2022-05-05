package de.htwg.se.dame.model


import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class MatrixSpec extends AnyWordSpec with Matchers {
  formatText("A Matrix is a tailored Data Structure to capture Board coordinate it") should {
    val default= new Matrix()
    default.player1 should be ("O")
    default.player2 should be ("X")
    val test= new Matrix()
    test.cells should be (6)
    test.data should be (Nil)
    val normalBoard = new Matrix(Nil,8,"X","O")
    normalBoard.cells should be (8)
    normalBoard.player1 should be ("X")
    normalBoard.player2 should be ("O")
    val internationBoard= new Matrix(Nil,10,"A","B")
    internationBoard.cells should be (10)
    internationBoard.player1 should be ("A")
    internationBoard.player2 should be ("B")

  }
  formatText("Init Fill initializes the StartBoard it") should{
    val default= new Matrix().initFill()
    default.data(1) should be (List(1, 1, 1, 1, 1, 1))
    default.data(3) should be (List(0, 0, 0, 0, 0, 0))
    default.data(5) should be (List(2, 2, 2, 2, 2, 2))
  }
  formatText("numToPlayer assigns every int the corresponding Player Symbol it") should {
    val default= new Matrix().initFill()
    val player1 = default.numToPlayer(1)
    player1 should be ("O")
    val player2 = default.numToPlayer(2)
    player2 should be ("X")
  }
  formatText("tup returns the Board Data as tuples for printing and") should {
    val default= new Matrix().initFill()
    val tuple = default.tup()
    tuple(1) should be (List(("O","O"), ("O","O"), ("O","O")))
  }
  formatText("replace cell changes the instance on the given coordinate and") should {
    val default= new Matrix().initFill()
    val replaced = default.replaceCell(0,0,2)
    replaced.data(0) should be (List(2, 1, 1, 1, 1, 1))
    val replaced1 = default.replaceCell(1,1,9)
    replaced1.data(1) should be (List(1,9,1,1,1,1))
    val replaced2 = default.replaceCell(2,4,4)
    replaced2.data(2) should be (List(0,0,0,0,4,0))
  } 
}
