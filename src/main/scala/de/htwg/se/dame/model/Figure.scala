package de.htwg.se.dame.model

/*
The figure based on the FactoryMethod-Pattern
*/

trait Figure {
    val onBoard = true
    def possibleMove = List()
    def move = List()
}

private class Farmer_Figure extends Figure {
    override def possibleMove  = List()
    override def move =  List()
}

private class Dame_Figure extends Figure {
    override def possibleMove =  Nil
    override def move =  Nil
}

object Figure {
    def apply(kind: String) = kind match {
        case "Dame" => new Dame_Figure()
        case "Farmer" => new Farmer_Figure()

    }
}