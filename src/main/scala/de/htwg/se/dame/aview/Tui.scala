package de.htwg.se.dame.aview

import scala.io.StdIn.readLine
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.util.Observer
import de.htwg.se.dame.model.Matrix

var eol = sys.props("line.separator")

class Tui(var controller: Controller) extends Observer {
  controller.add(this)

  def welcomeMessage() =
    println(
      "     __          __  _                            _          _____                                  "
    )
  println(
    "     \\ \\        / / | |                          | |        |  __ \\                              "
  )
  println(
    "      \\ \\  /\\  / ___| | ___ ___  _ __ ___   ___  | |_ ___   | |  | | __ _ _ __ ___   ___         "
  )
  println(
    "       \\ \\/  \\/ / _ | |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |  | |/ _` | '_ ` _ \\ / _ \\  "
  )
  println(
    "        \\  /\\  |  __| | (_| (_) | | | | | |  __/ | || (_) | | |__| | (_| | | | | | |  __/         "
  )
  println(
    "         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_____/ \\__,_|_| |_| |_|\\___| "
  )
  println(
    "                                                                                                    "
  )

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

  def processInputLine(): Unit = {
    println(eol + "Bitte Befehl eingeben")
    val input = readLine().toString
    input match {
      case "undo" => controller.undo
      case "redo" => controller.redo
      case "quit" =>
        return
      case "new" =>
        println(eol + "Starting a new game ...")
        controller.startGame()
      case "custom" =>
        println(eol + "Do you want international or standart or dev?")
        var version = readLine()
        println("Starting a new game ...")
        controller.startGame(version)
      case "load" =>
        println("Loading last save ...")
      case "save" =>
        println("Current game has been saved ...")
      case "help" =>
        helpMessage()
      case "move" =>
        println(
          eol + "----  " + controller.currentPlayer() + " is in turn  ----"
        )
        println("In which direction would you like to move?")
        var dir = readLine()
        println(eol + "Which row do you choose?")
        var row = readLine().toInt
        println(eol + "Which column do you choose?")
        var col = readLine().toInt
        controller.play(dir, row, col)
      case show => update
      case null => println(eol + "Wrong input please try again")
    }
    processInputLine()
  }

  override def update = controller.niceGame()
  // override def update = println(controller.getPrintData())
}
