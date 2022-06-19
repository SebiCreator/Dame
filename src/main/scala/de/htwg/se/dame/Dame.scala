package de.htwg.se.dame

import de.htwg.se.dame.aview.Tui
import de.htwg.se.dame.controllerComponent._
import de.htwg.se.dame.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.*
import de.htwg.se.dame.model.playerComponent.playerBaseImpl._

import scala.io.StdIn.readLine
import com.google.inject.Guice

import scala.swing._
import scala.swing.event._
import de.htwg.se.dame.aview.SwingGui
import de.htwg.se.dame.aview.FXGui
import de.htwg.se.dame.model.gameComponent.MatrixInterface

@main def hello: Unit = {

  val matrix = new Matrix().initFill()
  val controller = new Controller(Some(matrix))
  /*
  val FX = new FXGui(controller)
  controller.add(FX)
  val thread = new Thread {
    override def run: Unit = {
      FX.main(Array[String]())
    }
  }
   */

  // platform.run.later

  // val a = tui.processInputLine()
  /*
 val injector = Guice.createInjector(new DameModule)
 val con = injector.getInstance(classOf[ControllerInterface])
 val gui = new SwingGui(con)
 val tui = Tui(con)
 val a = tui.processInputLine()
   */

  val m = Board("dev", "A", "B")
  println(m.getData().foreach(println))
  val m2 = m.moveC(1,2,2,3)
//  val m2 = m.move("right",1,2)
  val m3 = m2.moveC(4,1,3,2)
  println(m)
  println(m2.getData().foreach(println))
  println(m2)
  println(m3.getData().foreach(println))
  println(m3)


}
