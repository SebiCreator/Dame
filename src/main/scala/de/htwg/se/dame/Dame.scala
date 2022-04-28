package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.model.Matrix

@main def hello: Unit =

  val controller = new Controller(new Matrix)
  val tui = new Tui(controller)
  tui.processInputLine("help")
  tui.processInputLine("custom")
