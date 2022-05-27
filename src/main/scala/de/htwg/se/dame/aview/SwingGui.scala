package de.htwg.se.dame.aview

import de.htwg.se.dame.controller.Controller
import de.htwg.se.dame.util.*

import scala.swing._
import scala.swing.event._
import javax.swing.WindowConstants.EXIT_ON_CLOSE
import javax.swing.ImageIcon
import javax.imageio.ImageIO

class SwingGui extends Frame with Reactor:

  peer.setDefaultCloseOperation(EXIT_ON_CLOSE)
  title = "HTWG-DAME"

  reactions += { case e =>
    //this.close()
  }

  menuBar = new MenuBar {
    background = java.awt.Color.DARK_GRAY
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
    }
  }

  pack()
  visible = true
  centerOnScreen()
  open()

  def MainMenu: BoxPanel = new BoxPanel(Orientation.Vertical):
    val boxpanel = new BoxPanel(Orientation.Horizontal):
      // val image = new File(f"src/main/scala/de/htwg/se/dame/aview/gui/dame.png")
      val title = new Button("")
      // title.icon = ImageIcon(ImageIO.read(image))
      title.selected = false
      title.contentAreaFilled = false
      title.borderPainted = false
      title.focusPainted = false
      title.opaque = false
      contents += title

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
    background = java.awt.Color.BLUE
    contents += boxpanel
    contents += boxpanelButtons
