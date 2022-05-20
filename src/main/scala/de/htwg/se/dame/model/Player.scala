package de.htwg.se.dame.model

trait Person {
  val name = ""
  override def toString: String = name
}

case class Player(override val name: String, wins: Int = 0) extends Person {
  val isPlaying = true
  val numberOfFigures = 0
  def increaseWinningStreak() = new Player(name, wins + 1)
}
case class Spectator(override val name: String) extends Person {
  val isPlaying = false
}

object PersonFactory {
  def apply(kind: String, name: String) = kind match {
    case "Player"    => new Player(name)
    case "Spectator" => new Spectator(name)
  }
}
