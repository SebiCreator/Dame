package de.htwg.se.dame.aview

import scala.io.StdIn.readLine
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.util.Observer
import de.htwg.se.dame.model.Matrix

var eol = sys.props("line.separator")

class Tui(var controller: Controller) extends Observer {
  controller.add(this)

  override def update = println("Hi")


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

  def processInputLine(): Unit= {
    println(eol + "Bitte Befehl eingeben")
    val input = readLine().toString
    input match {
      case "quit" =>
        return
      case "new" =>
        println("Starting a new game ...")
        controller = controller.startGame()
      case "custom" => 
        println("Do you want international or standart or dev?")
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
        println(controller.currentPlayer() + " is in turn")
        println("In which direction would you like to move?")
        var dir = readLine()
        println("Which row do you choose?")
        var row = readLine().toInt
        println("Which column do you choose?")
        var col = readLine().toInt
        controller.play(dir,row,col)
      case show => println("------------")
      case _ => println("Wrong input please try again")
    }
    controller.niceGame()
    processInputLine()
  }

  

  def analyse(dir: String, row: Int, col: Int): Option[Matrix] = {
    val m = controller.getMatrix()
    m match {
       case Some(s) => {
          val n = s.move(dir,row,col)
          n match {
          case Matrix(Nil,s.cells,s.player1,s.player2,s.player) => None
          case _ => Some(n)
          }
        }
      case None => None
    }
  }
}
