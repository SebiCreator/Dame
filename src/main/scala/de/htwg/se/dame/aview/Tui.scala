package de.htwg.se.dame.aview

import scala.io.StdIn.readLine
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.util.Observer
import de.htwg.se.dame.model.Lines.fullBoardWrapped2

class Tui(controller: Controller) extends Observer {
  controller.add(this)

def welcomeMessage() =
 println("     __          __  _                            _          _____                                  ")
 println("     \\ \\        / / | |                          | |        |  __ \\                              ")
 println("      \\ \\  /\\  / ___| | ___ ___  _ __ ___   ___  | |_ ___   | |  | | __ _ _ __ ___   ___         ")
 println("       \\ \\/  \\/ / _ | |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |  | |/ _` | '_ ` _ \\ / _ \\  ")
 println("        \\  /\\  |  __| | (_| (_) | | | | | |  __/ | || (_) | | |__| | (_| | | | | | |  __/         ")
 println("         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_____/ \\__,_|_| |_| |_|\\___| ")
 println("                                                                                                    ")

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

  def processInputLine(input: String): Integer = {
    input match {
      case "quit" =>
        System.exit(0)
        return -1

      case "new" =>
        println("Starting a new game ...")
        println(fullBoardWrapped2(3, 8, " "))
        return 0

      case "custom" => /* new Board with user sizes*/
        println("Enter your prefered cellsize ")
        var cellsize = readLine().toInt

        println("How many cells do you want to have ?")
        var nFields = readLine().toInt

        println("Starting a new game ...")
        println(fullBoardWrapped2(cellsize, nFields, " "))
        return 1

      case "load" => /* load a savegame */
        println("Loading last save ...")
        return 2

      case "save" => /* save current game*/
        println("Current game has been saved ...")
        return 3

      case "help" =>
        helpMessage()
        return 4
    }
  }

  override def update: Unit = println(controller.fullBoardWrapped2())
}
