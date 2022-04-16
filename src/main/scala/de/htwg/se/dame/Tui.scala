package de.htwg.se.tui

import de.htwg.se.dame
import scala.io.StdIn.readLine


class Tui {

  def hMessageFormat(keyword: String, message: String) =
    "\n%2$s %1$s %2$s \t%3$s".format(keyword, "  ", message)

  def helpMessage() =
    println(
      "HelpBoard type:" +
        hMessageFormat("quit", "to exit the game") +
        hMessageFormat("new", "to start a default game") +
        hMessageFormat("custom", "to start a custom game") +
        hMessageFormat("load", "the last saved game") +
        hMessageFormat("save", "current game") +
        hMessageFormat("help", "to get this HelpBoard")
    )

  def processInputLine(input: String): Unit = {
    input match {
      case "quit" => System.exit(0)

      case "new" =>
        println("Starting a new game ...")
        println(dame.fullBoardWrapped2(3, 8, " "))

      case "custom" => /* new Board with user sizes*/
        println("Enter your prefered cellsize ")
        var cellsize = readLine().toInt

        println("How many cells do you want to have ?")
        var nFields = readLine().toInt

        println("Starting a new game ...")
        println(dame.fullBoardWrapped2(cellsize, nFields, " "))

      case "load" => /* load a savegame */
        println("Loading last save ...")

      case "save" => /* save current game*/
        println("Current game has been saved ...")

      case "help" =>
        helpMessage()
    }
  }
}
