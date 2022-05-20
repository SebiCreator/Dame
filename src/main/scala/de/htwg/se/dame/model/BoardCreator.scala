package de.htwg.se.dame.model

object Board{

  def apply(name: String) = {
    name match {
      case "international" => fullBoardWrapped2(2, 5, "X")
      case "standard"      => fullBoardWrapped2(2, 4, "X")
      case "dev"           => fullBoardWrapped2(2, 3, "X")
      case _               => fullBoardWrapped2(2, 3, "X")

    }
  }

}
