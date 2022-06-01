package de.htwg.se.dame.ControllerComponent

import de.htwg.se.dame.ControllerInterface

class Controller(var matrix: Option[Matrix]) extends ControllerInterface {

  def getMatrix(): Option[Matrix]

  def getPrintData(): String

  def niceGame(): Unit

  def play(dir: String, row: Int, col: Int): Unit

  def currentPlayer(): String

  def playtest(dir: String, row: Int, col: Int): Try[Matrix]

  def startGame(
      boardname: String = "dev",
      name1: String = "A",
      name2: String = "B"
  ): Unit

  def doStep: Unit

  def undo: Unit

  def redo: Unit
}
