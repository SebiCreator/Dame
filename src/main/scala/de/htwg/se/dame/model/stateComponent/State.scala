package de.htwg.se.dame.model.stateComponent

trait State:
  def handle(event: GameStateEvents): State
