package de.htwg.se.dame.ControllerComponent

import scala.Nothing
import scala.util.{Try, Success, Failure}
import scala.swing.Publisher

trait ControllerInterface extends Publisher {

  def getMatrix(): Option[MatrixInterface]

  def getPrintData(): String

  def niceGame(): Unit

  def play(dir: String, row: Int, col: Int): Unit

  def currentPlayer(): String

  def playtest(dir: String, row: Int, col: Int): Try[MatrixInterface]

  def startGame(
      boardname: String = "dev",
      name1: String = "A",
      name2: String = "B"
  ): Unit

  def doStep: Unit

  def undo: Unit

  def redo: Unit

}
