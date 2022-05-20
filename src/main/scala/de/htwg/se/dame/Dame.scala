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
  val m2 = f1.command(m1,"left","Player1",1,2) 
  val m3 = f1.command(m2,"right","Player1",2,3)
  val m4 = f1.command(m3,"right-back","Player1",3,2)
  val m5 = f1.command(m4,"left-back","Player1",2,3)
  //val m5 = m4.moveRightL(2,1)




  m4.data.foreach(println)
  println("----------------")
  m5.data.foreach(println)


  







    
