/*
package de.htwg.se.dame.aview

import de.htwg.se.dame.controller.Controller
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

object FXGui extends JFXApp3 with Observer:
  // controller.add(this)
  val controller = Controller(None)
  override def update() = controller.niceGame()

  def start() = {
    val stage = new JFXApp3.PrimaryStage {

      title.value = "Dame"
      width = 800
      height = 800

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

 */
