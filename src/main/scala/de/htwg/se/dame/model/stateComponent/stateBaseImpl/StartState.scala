package de.htwg.se.dame.model.stateComponent.stateBaseImpl

import de.htwg.se.dame.model.stateComponent.*

case class StartState() extends State:
  def handle(event: GameStateEvents): State =
    event match
      case GameStateEvents.Start => PlayerTurnState(0, 2)
      case _                     => this
