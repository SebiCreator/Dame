package de.htwg.se.dame.controllerComponent

import scala.util.Try
import scala.swing.Publisher
import de.htwg.se.dame.model.gameComponent.MatrixInterface
import de.htwg.se.dame.util.*

trait ControllerInterface extends Publisher with Observable {

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
