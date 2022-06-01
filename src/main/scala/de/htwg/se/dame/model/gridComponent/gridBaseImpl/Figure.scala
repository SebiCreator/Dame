package de.htwg.se.dame.model

/*
The figure based on the Strategy
 */

trait Figure {
  val onBoard = true
  def apply(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): Matrix
  def command_upper(matrix: Matrix, command: String, row: Int, col: Int): Matrix
  def command_lower(matrix: Matrix, command: String, row: Int, col: Int): Matrix

}

object Farmer_Figure extends Figure {
  override def apply(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): Matrix = {
    player match {
      case "Player1" => command_upper(matrix, command, row, col)
      case "Player2" => command_lower(matrix, command, row, col)
    }

  }

  override def command_upper(
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ): Matrix = {
    command match {
      case "right"      => matrix.moveRightU(row, col)
      case "left"       => matrix.moveLeftU(row, col)
      case "right-kill" => matrix.killRightU(row, col)
      case "left-kill"  => matrix.killLeftU(row, col)
    }
  }

  override def command_lower(
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ): Matrix = {
    command match {
      case "right"      => matrix.moveRightL(row, col)
      case "left"       => matrix.moveLeftL(row, col)
      case "right-kill" => matrix.killRightL(row, col)
      case "left-kill"  => matrix.killLeftL(row, col)
    }
  }
}

object Dame_Figure extends Figure {
  override def apply(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): Matrix = {
    player match {
      case "Player1" => command_upper(matrix, command, row, col)
      case "Player2" => command_lower(matrix, command, row, col)
    }

  }

  override def command_upper(
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ): Matrix = {
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
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ): Matrix = {
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