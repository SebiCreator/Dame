package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controllerComponent._
import de.htwg.se.dame.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.*

import scala.io.StdIn.readLine

import scala.swing._
import scala.swing.event._
import java.awt.Dimension
import de.htwg.se.dame.aview.SwingGui

@main def hello: Unit = {

  val controller = Controller(None)
  val tui = Tui(controller)
  val a = tui.processInputLine()

  // val gui = new SwingGui
  // gui.mainMenu
}
