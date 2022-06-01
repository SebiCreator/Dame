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

class SwingGui(controller: ControllerInterface) extends Frame with Reactor:
  // listenTo(controller)

  peer.setDefaultCloseOperation(EXIT_ON_CLOSE)
  title = "HTWG-DAME"
  // val icon = ImageIO.read(new File(f"icon.png"))

  reactions += { case e =>
  // this.close()
  // new BeveledBorder(BevelBorder.RAISED, Color.orange, Color.DARK_GRAY)
  }
  menuBar = new MenuBar {
    background = java.awt.Color.DARK_GRAY
    border = BevelBorder(10, Color.orange, Color.DARK_GRAY)
    contents += new Menu("Game") {
      contents += new MenuItem(Action("New") {
        // controller....
      })
      contents += new MenuItem(Action("Save") {
        // controller ...
      })
      contents += new MenuItem(Action("Load") {
        // controller ...
      })
      val items = List(contents)
    }

    contents += new Menu("Redo") {
      contents += new MenuItem(Action("Redo Step") {
        // controller ...
      })

      contents += new MenuItem(Action("Undo Step") {
        // ...
      })
    }

    contents += new MenuItem(Action("Quit") { /* cotroller.exit() */ })

    contents += new BorderPanel {
      add(new Label("Welcome to Dame"), BorderPanel.Position.North)
      // border = Swing.EmptyBorder(0, 0, 600, 600)
    }
    contents += mainMenu
  }
  pack()
  visible = true
  centerOnScreen()
  open()

  def mainMenu: BoxPanel = new BoxPanel(Orientation.Vertical):
    val boxpanel = new BoxPanel(Orientation.Horizontal):
      // val image = new File(f"src/main/scala/de/htwg/se/dame/aview/dame.png")
      val title = new Button("")
      // title.icon = ImageIcon(ImageIO.read(image))
      title.selected = false
      title.contentAreaFilled = false
      title.borderPainted = false
      title.focusPainted = false
      title.opaque = false
      contents += title
      // border = Swing.EmptyBorder(0, 0, 600, 600)

    val boxpanelButtons = new BoxPanel(Orientation.Horizontal):
      val international = new Button("International")
      val classic = new Button("Classic")

      contents += international
      contents += classic

      listenTo(international)
      listenTo(classic)

      reactions += {
        case ButtonClicked(`international`) => // controller ...
        case ButtonClicked(`classic`)       => // controller
      }
    background = Color.BLUE
    contents += boxpanel
    contents += boxpanelButtons
