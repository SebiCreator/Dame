package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controllerComponent._
import de.htwg.se.dame.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.*
import de.htwg.se.dame.model.playerComponent.playerBaseImpl._

import scala.io.StdIn.readLine

import scala.swing._
import scala.swing.event._
import de.htwg.se.dame.aview.SwingGui
import de.htwg.se.dame.aview.FXGui
import de.htwg.se.dame.model.gameComponent.MatrixInterface

@main def hello: Unit = {

  val matrix = new Matrix().initFill()
  val controller = new Controller(Some(matrix))
  /*
  val FX = new FXGui(controller)
  controller.add(FX)
  val thread = new Thread {
    override def run: Unit = {
      FX.main(Array[String]())
    }
  }
   */

  // platform.run.later

  // val a = tui.processInputLine()

  val con = new Controller(None)
  val gui = new SwingGui(con)
  val tui = Tui(con)
  val a = tui.processInputLine()

  /*
  val matrix = new Matrix()
  matrix.initFill()

  print(matrix)
   */
}
