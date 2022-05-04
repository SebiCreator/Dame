package de.htwg.se.dame.controller

import de.htwg.se.dame.util.Observable
import de.htwg.se.dame.model.*

class Controller(var matrix: Matrix) extends Observable {
  var field: String = ""
  def initFill(filling: String): Unit = {
    val matrix = new Matrix(Nil, 8, "X", "O")
    notifyObservers
  }

  def tup(): Unit = {
    val matrix = Matrix().initFill()
    notifyObservers
  }

  def startGame(cellsize: Int, n_Fields: Int): Unit = {
    field = fullBoardWrapped2(cellsize, n_Fields, " ")
    notifyObservers

  }

}
