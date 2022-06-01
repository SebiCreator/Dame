package de.htwg.se.dame.util

import de.htwg.se.dame.model.Matrix

class UndoManager:
  private var undoStack: List[Matrix] = Nil
  private var redoStack: List[Matrix] = Nil

  def doStep(matrix: Matrix) =
    undoStack = matrix :: undoStack

  def undoStep(matrix: Option[Matrix]): Option[Matrix] =
    undoStack match {
      case Nil => None
      case head :: stack => {
        undoStack = stack
        redoStack = matrix.get :: redoStack
        Some(head)
      }
    }

  def redoStep: Option[Matrix] =
    redoStack match {
      case Nil => None
      case head :: stack => {
        redoStack = stack
        undoStack = head :: undoStack
        Some(head)
      }
    }
