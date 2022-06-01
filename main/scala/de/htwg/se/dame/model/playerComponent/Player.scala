package de.htwg.se.dame.model


class Player(name: String="X") {
  val isPlaying = true
  override def toString: String = name
}

case class Player1(name: String="A") extends Player {
  val symbol = "X"
}

case class Player2(name: String="B") extends Player {
  val symbol = "O"
}
case class Spectator(name: String) extends Player{
  override val isPlaying = false
}

object PersonFactory {
  def apply(kind: String, name: String) = kind match {
    case "Player"    => new Player(name)
    case "Spectator" => new Spectator(name)
  }
}
