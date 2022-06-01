package de.htwg.se.dame.ControllerComponent.ControllerBaseImpl

import de.htwg.se.dame.util.UndoManager
import de.htwg.se.dame.ControllerComponent._

import de.htwg.se.dame.model.*
import scala.Nothing
import de.htwg.se.dame.util.*
import scala.util.{Try, Success, Failure}
import de.htwg.se.dame.ControllerComponent
import scala.swing.Publisher

class Controller(var matrix: Option[Matrix])
    extends ControllerInterface
    with Publisher {
  val undoManager: UndoManager = new UndoManager()

  def getMatrix(): Option[Matrix] = {
    matrix match {
      case Some(m) => Some(m)
      case None    => None
    }
  }

  def getPrintData(): String = {
    val m = getMatrix()
    m match {
      case None    => ""
      case Some(s) => modBoardWrapped(1, s.cells / 2, s.tup())
    }
  }

  def niceGame(): Unit = {
    matrix match {
      case Some(s) => s.data.foreach(println)
      case None    => println("No Matrix")
    }
  }

  def play(dir: String, row: Int, col: Int): Unit = {
    val a = playtest(dir, row, col)
    a match {
      case Success(s) => matrix = Some(s)
      case Failure(s) =>
    }
    publish()
  }

  def currentPlayer(): String = {
    matrix match {
      case Some(m) => m.getPlayer()
      case None    => "NoPlayer"
    }
  }

  def playtest(dir: String, row: Int, col: Int): Try[Matrix] = {
    doStep
    Try(
      matrix match {
        case Some(m) => m.move(dir, row, col)
        case None    => throw new NoSuchElementException
      }
    )
  }

  def startGame(
      boardname: String = "dev",
      name1: String = "A",
      name2: String = "B"
  ): Unit = {
    matrix = Some(Board(boardname, name1, name2))
    publish()
  }

  def doStep: Unit = {
    undoManager.doStep(matrix.get)
  }

  def undo: Unit = {
    val undo = undoManager.undoStep(matrix)
    if (undo.isDefined) matrix = undo
    publish()

  }

  def redo: Unit = {
    val redo = undoManager.redoStep
    if (redo.isDefined) matrix = redo
    publish()
  }

}
