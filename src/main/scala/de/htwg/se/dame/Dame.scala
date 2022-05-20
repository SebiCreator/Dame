package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.model.Matrix
import de.htwg.se.dame.model.*

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
  val f1 = Figure("Dame")
  val m1 = Matrix().initFill()
  val m2 = f1.command(m1,"left","Player2",4,2) 
  val m3 = f1.command(m2,"right","Player1",1,3)
  val m4 = f1.command(m3,"left","Player1",2,2)
  //val m4 = m3.moveLeftU(2,2)

  m4.data.foreach(println)

  







    
