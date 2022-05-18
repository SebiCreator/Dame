package de.htwg.se.dame.controller

import de.htwg.se.dame.util.Observable
import de.htwg.se.dame.model.*

class Controller(var matrix: Matrix) extends Observable {
  var field: String = ""

  def doAndPublish_Fill(
      doThis: Unit => Matrix,
      string: String
  ): Unit = {
    matrix = doThis(initFill(string))
    notifyObservers
  }

  def initFill(filling: String): Unit = {
    val matrix = new Matrix(Nil, 8, "X", "O")
  }

  def tup(): Unit = {
    val matrix = new Matrix().initFill()
  }

  def startGame(cellsize: Int, n_Fields: Int): Unit = {
    field = fullBoardWrapped2(cellsize, n_Fields, " ")

  }

}
