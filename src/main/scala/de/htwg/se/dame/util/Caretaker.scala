package de.htwg.se.dame.util

trait Caretaker:
  val stack = scala.collection.mutable.Stack[Memento]();
  def addMemento(): Unit
  def getMemento(): Memento
