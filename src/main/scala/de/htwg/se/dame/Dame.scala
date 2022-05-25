package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.model.Matrix
import de.htwg.se.dame.model.*
import scala.io.StdIn.readLine

import scala.swing._
import scala.swing.event._
import java.awt.Dimension







@main def hello: Unit = {
  val m = Matrix()
  val controller = Controller(None).startGame()
  val tui = Tui(controller)
  val a = tui.processInputLine() 
  

}


  







    
