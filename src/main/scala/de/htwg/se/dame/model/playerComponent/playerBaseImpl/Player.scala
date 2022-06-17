package de.htwg.se.dame.model.playerComponent.playerBaseImpl

import de.htwg.se.dame.model.playerComponent.PlayerInterface

class Player(name: String = "X") extends PlayerInterface {
  override val isPlaying = true
  override def toString: String = name
  def get_name(): String= name
}

case class Player1(name: String ) extends PlayerInterface {
  val symbol = "X"
  def get_name(): String= name 
}

case class Player2(name: String) extends PlayerInterface {
  val symbol = "O"
  def get_name(): String= name 
}
case class Spectator(name: String) extends PlayerInterface {
  override val isPlaying = false
  def get_name(): String= name
}

object PersonFactory {
  def apply(kind: String, name: String) = kind match {
    case "Player"    => new Player(name)
    case "Spectator" => new Spectator(name)
  }
}
