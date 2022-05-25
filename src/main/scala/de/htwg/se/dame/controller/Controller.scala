package de.htwg.se.dame.controller

import de.htwg.se.dame.util.{Observable, UndoManager}
import de.htwg.se.dame.model.*
import scala.Nothing
import scala.util.{Try,Success,Failure}

class Controller(var matrix: Option[Matrix]) extends Observable {
  val undoManager: UndoManager[Matrix] = new UndoManager


  def getMatrix(): Option[Matrix] = {
    matrix match {
      case Some(m) => Some(m)
      case None => None
    }
  }

  def niceGame(): Unit = {
    matrix match {
      case Some(s) => s.data.foreach(println) 
      case None => println("No Matrix")
    }
  }



    
  def play(dir: String, row: Int, col: Int): Unit= {
    val a = playtest(dir,row,col)
    a match {
      case Success(s) => matrix = Some(s)
      case Failure(s) => 
    }
  }

  def currentPlayer(): String= {
    matrix match {
      case Some(m) => m.getPlayer()
    }
  }
    
  def playtest(dir: String, row: Int, col: Int): Try[Matrix]= {
    Try(
    matrix  match {
      case Some(m) => m.move(dir,row,col)
    }
    )
  }



  def startGame(boardname: String="dev", name1 : String="A",name2 : String="B"):Controller= {
      Controller(Some(Board(boardname,name1,name2)))
  }






  //def undo: Matrix = undoManager.undoStep(matrix)
  //def redo: Matrix = undoManager.redoStep(matrix)

}

