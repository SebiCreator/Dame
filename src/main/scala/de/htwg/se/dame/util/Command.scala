package de.htwg.se.dame.util

trait Command:
  def doStep:Unit
  def undoStep:Unit
  def redoStep:Unit


