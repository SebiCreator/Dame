package de.htwg.se.dame

import scala.io.StdIn.readLine

class Tui {

  def processInputLine(input: String): Unit = {
    input match {
      case "quit" => System.exit(0)
      case "new"  => new fullBoardWrapped2(8, 8, ' ')
      case "custom" => /* new Board with user sizes*/
        println("Enter your prefered cellsize ")
        var cellsize = readLine().toInt
        println("How many Cells do you want to have ?")
        var nFields = readLine().toInt
        new fullBoardWrapped2(cellsize, nFields, ' ')
      case "load" => /* load a savegame */
      case "save" => /* save current game*/
    }
  }
}
