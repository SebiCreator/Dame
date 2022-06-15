package de.htwg.se.dame.model.fileIOComponent

import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.model.gameComponent.MatrixInterface

trait FileIOInterface:
  def load: MatrixInterface
  def save(board: MatrixInterface): Unit

object FileIOInterface:
  def apply(): FileIOInterface =
    new fileIOJson.FileIO()
