package de.htwg.se.dame.model.stateComponent

import de.htwg.se.dame.model.stateComponent.stateBaseImpl.StartState

object GameStateContext:
  var state: State = StartState()
  var maxplayers = 2
  def handle(event: GameStateEvents) = state = state.handle(event)
  def getState() = state
  def setState(s: State) = state = s
