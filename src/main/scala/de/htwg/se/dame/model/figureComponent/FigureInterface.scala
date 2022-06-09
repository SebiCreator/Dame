package de.htwg.se.dame.model.figureComponent

import de.htwg.se.dame.model.gameComponent.MatrixInterface

/*
The figure based on the Strategy
 */

trait FigureInterface {
  val onBoard = true
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
