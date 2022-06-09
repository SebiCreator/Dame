package de.htwg.se.dame.model.stateComponent

enum GameStateEvents(name: String):
  override def toString = name
  case Start extends GameStateEvents("start")
  case Skip extends GameStateEvents("skip")
  case Finished extends GameStateEvents("finished")
