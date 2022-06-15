package de.htwg.se.dame.util

import de.htwg.se.dame.model.gameComponent.Game

trait Originator:
  def save(): Memento
  def restore(m: Memento): Game
