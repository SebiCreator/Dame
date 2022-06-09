package de.htwg.se.dame.aview

import de.htwg.se.dame.controllerComponent.ControllerInterface
import de.htwg.se.dame.util.*

import javafx.scene.control.MenuBar
import javafx.scene.control.Menu
import javafx.scene.control.MenuItem
import scala.io.StdIn.readLine
import scalafx.application.JFXApp3
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle
import scalafx.scene.Scene
import scalafx.Includes._
import javafx.scene.layout.BorderPane
import javafx.scene.control.Label

class FXGui(con: ControllerInterface) extends JFXApp3, Observer {
  con.add(this)
  override def update: Unit = {
    stage = new JFXApp3.PrimaryStage {
      width = 800
      height = 800
    }
  }

  def start(): Unit = {
    val stage = new JFXApp3.PrimaryStage {

      title = "Dame"

      scene = new Scene {
        fill = LightGray
        val border = new BorderPane {
          val menu = new MenuBar {
            val menuGame = new Menu("Game") {
              val itemNew = new MenuItem("New")
              val itemSave = new MenuItem("Save")
              val items = List(itemNew, itemSave)
            }
            val menuCtrl = new Menu("Redo") {
              val redo = new MenuItem("Redo Step")
              val undo = new MenuItem("Undo Step")
              val items = List(redo, undo)
            }

            val menuList = List(menuGame, menuCtrl)
          }

          val bottom = Label("Welcome to Dame")

        }

      }
    }
  }
}
