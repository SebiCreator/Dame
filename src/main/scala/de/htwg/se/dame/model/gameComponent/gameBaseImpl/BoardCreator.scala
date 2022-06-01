package de.htwg.se.dame.model.gameComponent.gameBaseImpl

import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.model.playerComponent.playerBaseImpl.{Player1, Player2}

object Board {

  def apply(
      boardname: String = "dev",
      name1: String = "A",
      name2: String = "B"
  ) = {
    boardname match {
      case "international" =>
        Matrix(Nil, 10, Player1(name1), Player2(name2)).initFill()
      case "standard" =>
        Matrix(Nil, 8, Player1(name1), Player2(name2)).initFill()
      case "dev" => Matrix(Nil, 6, Player1(name1), Player2(name2)).initFill()
      case _     => Matrix(Nil, 6, Player1(name1), Player2(name2)).initFill()
    }
  }

}
