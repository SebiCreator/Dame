package de.htwg.se.dame.controller
import de.htwg.se.dame.util.Command
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.dame.controllerComponent.ControllerInterface

/*

class PlayCommand(controller: Controller,row: Int, col: Int, dir: String,m: Matrix) extends Command:
  override def doStep: Unit = controller.play(dir,row,col)
  override def undoStep: Unit = controller.matrix = m
  override def redoStep: Unit = controller.play(dir,row,col)
  */