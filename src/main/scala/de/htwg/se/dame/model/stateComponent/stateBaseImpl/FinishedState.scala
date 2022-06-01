package de.htwg.se.dame.model.stateComponent.stateBaseImpl

import de.htwg.se.dame.model.stateComponent.*

case class FinishedState(winner: Int, loser: Int) extends State:
  def handle(event: GameStateEvents): State =
    event match
      case GameStateEvents.Start => PlayerTurnState(loser, 2)
      case _                     => this
