package de.htwg.se.dame.controller

import de.htwg.se.dame.util.{Observable, UndoManager}
import de.htwg.se.dame.model.*
import scala.Nothing

class Controller(matrix: Matrix) extends Observable {
  val undoManager: UndoManager[Matrix] = new UndoManager

  def doAndPublish(doThis: Unit => Matrix, string: String): Unit = {
    //matrix = doThis()
    notifyObservers
  }

  def doAndNotify(doThis: () =>Controller): Controller = {
    val matrix_ = doThis()
    notifyObservers
    return Controller(matrix_)
  }

  def getMatrix(): Matrix = matrix

  def tup(): Unit = {
    val matrix = new Matrix().initFill()
  }

  def startGame(boardname: String="dev", name1 : String="A",name2 : String="B"):Controller= {
      Controller(Board(boardname,name1,name2))
  }

  //def put(matrix: Matrix): Matrix =
   // undoManager.doStep(matrix, PutCommand(move))

  def undo: Matrix = undoManager.undoStep(matrix)
  def redo: Matrix = undoManager.redoStep(matrix)

  //override def toString = matrix.toString

}

