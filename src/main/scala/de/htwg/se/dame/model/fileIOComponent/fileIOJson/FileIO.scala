package de.htwg.se.dame.model.fileIOComponent.fileIOJson

import scala.io.Source
import java.io._
import java.io.PrintWriter

import com.google.inject.Guice
import com.google.inject.Inject
import com.google.inject.name.Names

import play.api.libs.json._

import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix
import de.htwg.se.dame.model.fileIOComponent.FileIOInterface
import de.htwg.se.dame.model.gameComponent.MatrixInterface
import de.htwg.se.dame.model.playerComponent.*
import de.htwg.se.dame.model.playerComponent.PlayerInterface
import de.htwg.se.dame.model.playerComponent.playerBaseImpl.Player1
import de.htwg.se.dame.model.playerComponent.playerBaseImpl.Player2

class FileIO extends FileIOInterface:
  override def load: MatrixInterface = {

    val source: String = Source.fromFile("game.json").getLines.mkString
    val json: JsValue = Json.parse(source)

    var boardGame: MatrixInterface = null

    val player1 = (json \ "player1").get.toString
    val player2 = (json \ "player2").get.toString
    val cells = (json \ "cells").get.toString.toInt
    val board = (json \ "board").get

    val p1 = Player1(player1)
    val p2 = Player2(player2)

    val test = Matrix().initFill()
    Matrix(test.getData(), test.getCells(), p1, p2)
  }

  override def save(matrix: MatrixInterface): Unit = {
    val pw = new PrintWriter(new File("game.json"))
    pw.write(Json.prettyPrint(matrixToJson(matrix)))
    pw.close
  }

  /*
  implicit val listWrites = new Writes[PlayerInterface] {
    def writes(players: PlayerInterface) = Json.obj(
      "player1" -> Player1.toString,
      "player2" -> Player2.toString
    )
  }
   */

  def matrixToJson(matrix: MatrixInterface) = {
    Json.obj(
      "board" -> matrix.getData(),
      "cells" -> matrix.getCells(),
      "player1" -> matrix.getPlayer(),
      "player2" -> Player2.toString
    )
  }
