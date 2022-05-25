package de.htwg.se.dame.aview

import scala.io.StdIn.readLine
import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.util.Observer
import de.htwg.se.dame.model.Matrix

class Tui(var controller: Controller) extends Observer {
  controller.add(this)

  override def update: Unit =
    print(controller.field)

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
    val input = readLine().toString
    input match {
      case "quit" =>
        System.exit(0)

      case "new" =>
        println("Starting a new game ...")

        controller = controller.doAndNotify(controller.startGame)


      case "custom" => /* new Board with user sizes*/
        println("Enter your prefered cellsize ")
        var cellsize = readLine().toInt

        println("How many cells do you want to have ?")
        var nFields = readLine().toInt

        println("Starting a new game ...")

      case "load" => /* load a savegame */
        println("Loading last save ...")

      case "save" => /* save current game*/
        println("Current game has been saved ...")

      case "help" =>
        helpMessage()
      
      case "move" => 
        var p = controller.getMatrix().player 
        println("Which direction (player" + p + ")")
        val dir = readLine().toString
        println("Row")
        val row = readLine().toInt
        println("Col")
        val col= readLine().toInt
        val a = analyse(dir,row,col)
        a match {
          case Some(n) => controller.doAndNotify()
        }
    }
    processInputLine()
  }

  

  def analyse(dir: String, row: Int, col: Int): Option[Matrix] = {
    val m = controller.getMatrix()
    val n = m.move(dir,row,col)
    n match {
      case Matrix(Nil,m.cells,player1,player2,player) => None
      case _ => Some(n)
    }
  }

}
