package de.htwg.se.dame.model
import scala.io.StdIn.readLine

/*
Strategy-Pattern for a left or right move
to be extended with additional moves for the dame figure
 */

object Move {

  var move = if (readLine() == "1") moveLeft else moveRight

  def moveLeft = println("left")

  def moveRight = println("right")

}
