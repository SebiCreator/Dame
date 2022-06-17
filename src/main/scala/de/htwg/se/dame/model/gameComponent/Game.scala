package de.htwg.se.dame.model.gameComponent

import de.htwg.se.dame.util.*

trait Game extends Originator:
  def play(matrix: MatrixInterface): Game
  def skip(): Game
  def getPlayers(): Vector[MatrixInterface]
  def getBoard(): MatrixInterface
  def nextTurn: Game

object Game:
  def apply(): Game = Game()
