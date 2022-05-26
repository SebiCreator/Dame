package de.htwg.se.dame.controller

import de.htwg.se.dame.util.{Observable, UndoManager}
import de.htwg.se.dame.model.*
import scala.Nothing
import de.htwg.se.dame.util.*
import scala.util.{Try,Success,Failure}

class Controller(var matrix: Option[Matrix]) extends Observable {
  val undoManager: UndoManager = new UndoManager()


  def getMatrix(): Option[Matrix] = {
    matrix match {
      case Some(m) => Some(m)
      case None => None
    }
  }

  def getPrintData(): String =  {
    val m = getMatrix()
    m match {
      case None => ""
      case Some(s) => modBoardWrapped(1,s.cells/2,s.tup())
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
    notifyObservers
  }

  def currentPlayer(): String= {
    matrix match {
      case Some(m) => m.getPlayer()
      case None => "NoPlayer"
    }
  }
    
  def playtest(dir: String, row: Int, col: Int): Try[Matrix]= {
    Try(
    matrix  match {
      case Some(m) => m.move(dir,row,col)
      case None => throw new NoSuchElementException
    }
    )
  }

  def startGame(boardname: String="dev", name1 : String="A",name2 : String="B"): Unit= {
      matrix = Some(Board(boardname,name1,name2))
      notifyObservers
  }

  def undo: Unit={
    undoManager.undoStep
    notifyObservers
  } 
  def redo: Unit= {
    undoManager.redoStep()
    notifyObservers
  }
}

