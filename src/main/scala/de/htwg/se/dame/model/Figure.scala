package de.htwg.se.dame.model

/*
The figure based on the FactoryMethod-Pattern
 */

trait Figure {
  val onBoard = true
  def command(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ): Matrix
  def command_upper(matrix: Matrix, command: String, row: Int, col: Int): Matrix
  def command_lower(matrix: Matrix, command: String, row: Int, col: Int): Matrix

}

private class Farmer_Figure extends Figure {
  override def command(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ) = {
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
  ) = {
    command match {
      case "right" => matrix.moveRightU(row, col)

      case "left" => matrix.moveLeftU(row, col)
    }
  }

  override def command_lower(
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ) = {
    command match {
      case "right" => matrix.moveRightL(row, col)

      case "left" => matrix.moveLeftL(row, col)
    }
  }
}

private class Dame_Figure extends Figure {
  override def command(
      matrix: Matrix,
      command: String,
      player: String,
      row: Int,
      col: Int
  ) = {
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
  ) = {
    command match {
      case "right" => matrix.moveLeftU(row, col)

      case "left" => matrix.moveRightU(row, col)

    }
  }

  override def command_lower(
      matrix: Matrix,
      command: String,
      row: Int,
      col: Int
  ) = {
    command match {
      case "right" => matrix.moveRightL(row, col)

      case "left" => matrix.moveLeftL(row, col)

    }
  }
}

object Figure {
  def apply(kind: String) = kind match {
    case "Dame"   => new Dame_Figure()
    case "Farmer" => new Farmer_Figure()

  }
}
