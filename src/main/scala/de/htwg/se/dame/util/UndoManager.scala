package de.htwg.se.dame.util

import de.htwg.se.dame.model.gameComponent.MatrixInterface

class UndoManager:
  private var undoStack: List[MatrixInterface] = Nil
  private var redoStack: List[MatrixInterface] = Nil

  def doStep(matrix: MatrixInterface) =
    undoStack = matrix :: undoStack

  def undoStep(matrix: Option[MatrixInterface]): Option[MatrixInterface] =
    undoStack match {
      case Nil => None
      case head :: stack => {
        undoStack = stack
        redoStack = matrix.get :: redoStack
        Some(head)
      }
    }

  def redoStep: Option[MatrixInterface] =
    redoStack match {
      case Nil => None
      case head :: stack => {
        redoStack = stack
        undoStack = head :: undoStack
        Some(head)
      }
    }
