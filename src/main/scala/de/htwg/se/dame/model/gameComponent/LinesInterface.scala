package de.htwg.se.dame.model.gameComponent

trait LinesInterface {

  def fullBoardWrapped2(cellsize: Int, nFields: Int, symbol: String): String

  def modBoard(
      cellsize: Int,
      nFields: Int,
      symbols: List[List[(String, String)]]
  ): String

  def modBoardWrapped(
      cellsize: Int,
      nFields: Int,
      symbols: List[List[(String, String)]]
  ): String

}
