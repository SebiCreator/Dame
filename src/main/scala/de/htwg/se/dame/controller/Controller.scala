package de.htwg.se.dame.controller

import de.htwg.se.dame.util.{Observable, UndoManager}
import de.htwg.se.dame.model.*

class Controller(var matrix: Matrix) extends Observable {
  var field: String = ""
  val undoManager: UndoManager[Matrix] = new UndoManager

  def doAndPublish_Fill(doThis: Unit => Matrix, string: String): Unit = {
    //matrix = doThis()
    notifyObservers
  }

  def tup(): Unit = {
    val matrix = new Matrix().initFill()
  }

  def startGame(boardname: String="dev", name1 : String="A",name2 : String="B"): Matrix = {
    Board(boardname,name1,name2)
  }

  //def put(matrix: Matrix): Matrix =
   // undoManager.doStep(matrix, PutCommand(move))

  def undo: Matrix = undoManager.undoStep(matrix)
  def redo: Matrix = undoManager.redoStep(matrix)

  //override def toString = matrix.toString

}
