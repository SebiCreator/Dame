package de.htwg.se.dame.controllerComponent.controllerBaseImpl

import com.google.inject.name.Names
import com.google.inject.Guice
import com.google.inject.Inject
import net.codingwell.scalaguice.InjectorExtensions._

import de.htwg.se.dame.DameModule
import de.htwg.se.dame.util.UndoManager
import de.htwg.se.dame.controllerComponent._
import de.htwg.se.dame.model.gameComponent.MatrixInterface
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.*
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.model.fileIOComponent.FileIOInterface

import de.htwg.se.dame.util.*

import scala.util.{Try, Success, Failure}

import scala.swing.Publisher
import de.htwg.se.dame.util.Observer

class Controller @Inject() (var matrix: Option[MatrixInterface])
    extends ControllerInterface {

  val undoManager: UndoManager = new UndoManager()

  // val injector = Guice.createInjector(new DameModule)
  // val fileIo = injector.instance[FileIOInterface]

  def getMatrix(): Option[MatrixInterface] = {
    matrix match {
      case Some(m) => Some(m)
      case None    => None
    }
  }

  def getSize(): Int = {
    matrix match {
      case Some(m) => {
        m.getCells()
      }
      case None => -1
    }
  }

  def getPrintData(): String = {
    val m = getMatrix()
    m match {
      case None    => ""
      case Some(s) => Lines.modBoardWrapped(1, s.getCells() / 2, s.tup())
    }
  }

  def niceGame(): Unit = {
    matrix match {
      case Some(s) => s.getData().foreach(println)
      case None    => println("No Matrix")
    }
  }

  def play(dir: String, row: Int, col: Int): Unit = {
    val a = playtest(dir, row, col)
    a match {
      case Success(s) => matrix = Some(s)
      case Failure(s) =>
    }
    notifyObservers

  }

  def currentPlayer(): String = {
    matrix match {
      case Some(m) => m.getPlayer()
      case None    => "NoPlayer"
    }
  }

  def getName(): String = {
    matrix match {
      case Some(m) => m.getName_()
      case None    => "NoPlayer"
    }
  }

  def playtest(dir: String, row: Int, col: Int): Try[MatrixInterface] = {
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
    notifyObservers

  }

  def doStep: Unit = {
    undoManager.doStep(matrix.get)
  }

  def undo: Unit = {
    val undo = undoManager.undoStep(matrix)
    if (undo.isDefined) matrix = undo
    notifyObservers

  }

  def redo: Unit = {
    val redo = undoManager.redoStep
    if (redo.isDefined) matrix = redo
    notifyObservers

  }

  def save: Unit = {
    matrix match
      case Some(m) =>
        Guice
          .createInjector(new DameModule)
          .getInstance(classOf[FileIOInterface])
          .save(m)
      case None => return
  }

  def load: Unit = {
    matrix = Some(
      Guice
        .createInjector(new DameModule)
        .getInstance(classOf[FileIOInterface])
        .load
    )
    notifyObservers
  }

}
