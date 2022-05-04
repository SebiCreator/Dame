package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.model.Matrix

import scala.io.StdIn.readLine

/*
object Dame {
  val controller = new Controller(new Matrix)
  val tui = new Tui(controller)
  controller.notifyObservers

  def main(args: Array[String]): Unit = {
    var input: String = ""
    tui.processInputLine("help")

    while (input != "quit") {
      input = readLine()
      tui.processInputLine(input)
    }
  }
}
*/

@main def hello: Unit =

  val m = Matrix().initFill()
  m.data.foreach(println)
  val x = m.moveLeft(4,1)
  println("\n")
  x.data.foreach(println)
  println("\n")
  val y = x.moveRight(3,0)
  y.data.foreach(println)
  


    
