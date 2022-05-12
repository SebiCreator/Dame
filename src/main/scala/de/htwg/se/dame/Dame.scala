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
  println(modLine(2,List((1,1),(2,2)))) // |#O# X #O# X |
  //println(modBlock(1,4,List((1,0),(2,0),(1,1),(2,2)))) // |OXOXOXOX|
  //println(modBoard(1,4,List(
    //List((1,1),(2,2)),
    //List((0,0),(1,1)),
    //List((0,0),(1,1)),
    //List((0,0),(1,1))
  //))) 
  //|OXOX|
  //|OXOX|
  //|OXOX|
  //|OXOX|
  println(modBoardWrapped(1,2,List(
    List((1,1),(2,2)),
    List((0,0),(1,1)),
    List((0,0),(1,1)),
    List((0,0),(1,1)) 
  )))







    
