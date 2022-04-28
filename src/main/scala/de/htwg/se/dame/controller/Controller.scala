package de.htwg.se.dame.controller

//import de.htwg.se.sudoku.model
import de.htwg.se.dame.util.Observable
import de.htwg.se.dame.model.Matrix

class Controller(var matrix: Matrix[String]) extends Observable {
  def initFill(filling: String): Unit = {
    val matrix = new Matrix[String](Nil, 8, "X", "O")
    notifyObservers
  }

  def tup(): Unit = {
    val matrix = new Matrix[String].initFill() // :/
    notifyObservers
  }

  def fullBoardWrapped2(cellsize: Int, nFields: Int, symbol: String): Unit = {
    val matrix = new Matrix[String].initFill().tup()
    fullBoardWrapped2(cellsize, nFields, symbol)
    notifyObservers

  }

}
