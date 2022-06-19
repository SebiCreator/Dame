package de.htwg.se.dame.model.gameComponent

trait MatrixInterface {

  def getCells(): Int

  def getData(): List[List[Int]]

  def getName_(): String

  def getplayerNames(i: Int):String

  def initFill1(n: Int): List[Int]

  def initFill2(n: Int): List[Int]

  def initFill(): MatrixInterface

  def numToPlayer(num: Int): String

  def tup(): List[List[(String, String)]]

  def replaceCell(row: Int, col: Int, symbol: Int): MatrixInterface

  def cellIsEmpty(row: Int, col: Int): Boolean

  def whichFigure(row: Int)(col: Int): String


  def move(direction: String, row: Int, col: Int): MatrixInterface

  def moveC(srow: Int,scol: Int,trow : Int,tcol: Int): MatrixInterface 

  def changePlayer(): MatrixInterface

  def checkDameU(): MatrixInterface

  def checkDameL(): MatrixInterface

  def getPlayer(): String

  def rightMovePossibleL(row: Int, col: Int): Boolean
  def rightMovePossibleU(row: Int, col: Int): Boolean
  def leftMovePossibleL(row: Int, col: Int): Boolean
  def leftMovePossibleU(row: Int, col: Int): Boolean

  def movePossible(pos: String, direction: String, row: Int, col: Int): Boolean

  def movePossibleLower(direction: String, row: Int, col: Int): Boolean

  def movePossibleUpper(direction: String, row: Int, col: Int): Boolean

  def moveLeftL(row: Int, col: Int): MatrixInterface

  def moveLeftU(row: Int, col: Int): MatrixInterface

  def moveRightL(row: Int, col: Int): MatrixInterface

  def moveRightU(row: Int, col: Int): MatrixInterface

  def rightKillPossibleU(row: Int, col: Int): Boolean

  def leftKillPossilbeU(row: Int, col: Int): Boolean

  def rightKillPossibleL(row: Int, col: Int): Boolean

  def leftKillPossilbeL(row: Int, col: Int): Boolean

  def killRightU(row: Int, col: Int): MatrixInterface

  def killLeftU(row: Int, col: Int): MatrixInterface

  def killRightL(row: Int, col: Int): MatrixInterface

  def killLeftL(row: Int, col: Int): MatrixInterface


}
