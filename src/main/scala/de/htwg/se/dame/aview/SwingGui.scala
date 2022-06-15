package de.htwg.se.dame.aview

import de.htwg.se.dame.controllerComponent._
import de.htwg.se.dame.util.*

import scala.swing._
import scala.swing.event._
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing.ImageIcon
import javax.imageio.ImageIO
import java.io.File
import java.awt.Color
import java.awt.Image
import scala.swing.Swing.Embossing
import javax.swing.border.BevelBorder
import javax.swing.border.TitledBorder
import javax.swing.border.LineBorder
import scalafx.scene.shape.Circle
import javafx.scene.layout.Border

class SwingGui(controller: ControllerInterface) extends Frame with Observer:
  controller.add(this)
  listenTo(controller)

  peer.setDefaultCloseOperation(EXIT_ON_CLOSE)
  preferredSize = new Dimension(800, 600)
  var imageIcon = new ImageIcon("icon.jpg")
  title = "HTWG-DAME"

  contents = new BorderPanel {
    if (controller.getMatrix().isDefined) {
      val cells = controller.getSize()
      add(new drawBoard(cells), BorderPanel.Position.Center)
      add(commandArea, BorderPanel.Position.South)
      add(turn, BorderPanel.Position.North)
      add(box, BorderPanel.Position.North)
    } else {
      add(box, BorderPanel.Position.North)
    }

  }

  menuBar = new MenuBar {
    background = java.awt.Color.WHITE
    border = BevelBorder(10, Color.ORANGE, Color.WHITE)
    contents += new Menu("Game") {
      contents += new MenuItem(Action("New") {
        newGame()
      })
      contents += new MenuItem(Action("Save") {
        controller.save
      })
      contents += new MenuItem(Action("Load") {
        controller.load
      })
      val items = List(contents)
    }

    contents += new Menu("Undo") {
      contents += new MenuItem(Action("Undo Step") {
        controller.undo
      })

      contents += new MenuItem(Action("Redo Step") {
        controller.redo
      })
    }

    contents += new MenuItem(Action("Quit") {
      background = java.awt.Color.WHITE
      closeWindow()
    })

    contents += new BorderPanel {
      add(new Label("Welcome to Dame"), BorderPanel.Position.North)
      background = java.awt.Color.WHITE
    }

  } // menuBar

  def box = new FlowPanel {

    val x = new Button(Action("International") {
      border = new TitledBorder(
        new TitledBorder(LineBorder.createGrayLineBorder(), "New"),
        "Game",
        TitledBorder.RIGHT,
        TitledBorder.BOTTOM
      )
      background = java.awt.Color.WHITE
      newGame("international")
      // controller....
    })
    contents += x

    contents += new Button(Action("Classic") {
      new TitledBorder(
        new TitledBorder(LineBorder.createGrayLineBorder(), "New"),
        "Game",
        TitledBorder.RIGHT,
        TitledBorder.BOTTOM
      )
      centerOnScreen()
      background = java.awt.Color.WHITE
      newGame("standard")

    })
  }

  def newGame(typ: String = "dev"): Unit = {

    val p1 = Dialog.showInput(contents.head, "Player1", initial = "Name")
    val p2 = Dialog.showInput(contents.head, "Player2", initial = "Name")

    typ match {
      case "international" => {
        controller.startGame("international", p1.toString, p2.toString)
        update
      }
      case "standard" => {
        controller.startGame("standard", p1.toString, p2.toString)
        update
      }
    }
  }

  class drawBoard(size: Int) extends GridPanel(size + 1, size + 1):
    val matrix = controller.getMatrix() match {
      case Some(s) => s
      case None    =>
    }

    val data: List[List[Int]] = controller.getMatrix() match {
      case Some(s) => s.getData()
      case None    => List(Nil)
    }

    for (i <- 0 to size - 1) {
      for (j <- 0 to size - 1) {
        data(i)(j) match {

          case 0 =>
            contents += new Button() {
              val b = if ((i + j) % 2 == 0) Color.BLACK else Color.WHITE
              background = b
            }

          case 1 =>
            contents += new Button("X") {
              val b = if ((i + j) % 2 == 0) Color.BLACK else Color.WHITE
              background = b
            }

          case 2 =>
            contents += new Button("O") {
              val b = if ((i + j) % 2 == 0) Color.BLACK else Color.WHITE
              background = b
            }
        }

      }
    }

  pack()
  visible = true
  centerOnScreen()
  open()

  def turn = new GridPanel(2, 1) {
    contents += new Label(
      "It's " + controller.getName() + "'s turn"
    )
  }

  def infoArea = new GridPanel(1, 1) {}

  def commandArea = new GridPanel(2, 1) {
    contents += new Label {
      text = "enter your command"
      font = new Font("Calibri", java.awt.Font.PLAIN, 20)
    }
    contents += new TextArea() {

      preferredSize = new Dimension(40, 40)

      val send = new Button("send command") {
        background = Color.GREEN
      }
      contents += send
      listenTo(send)

      reactions += { case ButtonClicked(send) =>
        command(text)
      }

    }
    contents += new Label {
      text =
        "the format is: <operation> <direction> <row> <col>; e.g 'move left 3 1'"
      font = new Font("Calibri", java.awt.Font.PLAIN, 12)
    }

  }

  def command(com: String) = {
    val c = com.split(" ")
    val op = c(0)
    val dir = c(1)
    val row = c(2)
    val col = c(3)
    controller.play(dir, row.toInt, col.toInt)
    update
  }

  def closeWindow() = {
    val response = Dialog.showConfirmation(
      contents.head,
      "you wish to quit the game ?",
      optionType = Dialog.Options.YesNo,
      title = title
    )

    if (response == Dialog.Result.Ok)
      sys.exit(0)
  }

  override def update: Unit = {
    contents = new BorderPanel {
      if (controller.getMatrix().isDefined) {
        val cells = controller.getSize()
        add(new drawBoard(cells), BorderPanel.Position.Center)
        add(commandArea, BorderPanel.Position.South)
        add(turn, BorderPanel.Position.North)
      } else {
        add(box, BorderPanel.Position.North)
      }
    }
  }
