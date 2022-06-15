package de.htwg.se.dame.util

import de.htwg.se.dame.model.gameComponent.Game
import de.htwg.se.dame.model.stateComponent._

trait Memento:
  def state(): State
  def game(): Game

case class GameMemento(savegame: Game, savestate: State) extends Memento:
  def state(): State = savestate
  def game(): Game = savegame
