/*
package de.htwg.se.dame

import de.htwg.se.dame.model.Matrix
import de.htwg.se.dame.util.Command
import de.htwg.se.dame.model.BoardCreator

class PutCommand(matrix: Matrix) extends Command[BoardCreator]:
  override def noStep(matrix: Matrix): Matrix = matrix
  override def doStep(matrix: Matrix): Matrix =
    matrix.movePossible(...)
  override def undoStep(matrix: Matrix): Matrix =
    matrix.movePossible(...)
  override def redoStep(matrix: Matrix): Matrix =
    matrix.movePossible(...)
 */
