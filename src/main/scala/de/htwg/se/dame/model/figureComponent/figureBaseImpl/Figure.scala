package de.htwg.se.dame.model.figureComponent.figureBaseImpl

import de.htwg.se.dame.model.figureComponent.FigureInterface
import de.htwg.se.dame.model.gameComponent.MatrixInterface
/*
The figure based on the Strategy
 */

trait Figure extends FigureInterface {
  override val onBoard = true
  def apply(
      matrix: MatrixInterface,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): MatrixInterface
  def command_upper(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface
  def command_lower(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface

}

object Farmer_Figure extends FigureInterface {
  override def apply(
      matrix: MatrixInterface,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    player match {
      case "Player1" => command_upper(matrix, command, row, col)
      case "Player2" => command_lower(matrix, command, row, col)
    }

  }

  override def command_upper(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    command match {
      case "right"      => matrix.moveRightU(row, col)
      case "left"       => matrix.moveLeftU(row, col)
      case "right-kill" => matrix.killRightU(row, col)
      case "left-kill"  => matrix.killLeftU(row, col)
    }
  }

  override def command_lower(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    command match {
      case "right"      => matrix.moveRightL(row, col)
      case "left"       => matrix.moveLeftL(row, col)
      case "right-kill" => matrix.killRightL(row, col)
      case "left-kill"  => matrix.killLeftL(row, col)
    }
  }
}

object Dame_Figure extends FigureInterface {
  override def apply(
      matrix: MatrixInterface,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    player match {
      case "Player1" => command_upper(matrix, command, row, col)
      case "Player2" => command_lower(matrix, command, row, col)
    }

  }

  override def command_upper(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    command match {
      case "right"           => matrix.moveRightU(row, col)
      case "left"            => matrix.moveLeftU(row, col)
      case "right-back"      => matrix.moveRightL(row, col)
      case "left-back"       => matrix.moveLeftL(row, col)
      case "right-kill"      => matrix.killRightU(row, col)
      case "left-kill"       => matrix.killLeftU(row, col)
      case "left-back-kill"  => matrix.killLeftL(row, col)
      case "right-back-kill" => matrix.killRightL(row, col)
    }
  }

  override def command_lower(
      matrix: MatrixInterface,
      command: String,
      row: Int,
      col: Int
  ): MatrixInterface = {
    command match {
      case "right"           => matrix.moveRightL(row, col)
      case "left"            => matrix.moveLeftL(row, col)
      case "right-back"      => matrix.moveLeftU(row, col)
      case "left-back"       => matrix.moveRightU(row, col)
      case "right-kill"      => matrix.killRightL(row, col)
      case "left-kill"       => matrix.killLeftL(row, col)
      case "left-back-kill"  => matrix.killLeftU(row, col)
      case "right-back-kill" => matrix.killRightU(row, col)
    }
  }
}
