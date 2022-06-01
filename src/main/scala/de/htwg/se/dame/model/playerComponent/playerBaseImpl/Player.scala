package de.htwg.se.dame.model.playerComponent.playerBaseImpl

import de.htwg.se.dame.model.playerComponent.PlayerInterface

class Player(name: String = "X") extends PlayerInterface {
  override val isPlaying = true
  override def toString: String = name
}

case class Player1(name: String = "A") extends PlayerInterface {
  val symbol = "X"
}

case class Player2(name: String = "B") extends PlayerInterface {
  val symbol = "O"
}
case class Spectator(name: String) extends PlayerInterface {
  override val isPlaying = false
}

object PersonFactory {
  def apply(kind: String, name: String) = kind match {
    case "Player"    => new Player(name)
    case "Spectator" => new Spectator(name)
  }
}
