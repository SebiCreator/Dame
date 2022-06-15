package de.htwg.se.dame.model.fileIOComponent.fileIOXML

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
import de.htwg.se.dame.model.playerComponent.playerBaseImpl.Player1
import de.htwg.se.dame.model.playerComponent.playerBaseImpl.Player2
import scala.xml.{NodeSeq, PrettyPrinter}

class FileIO extends FileIOInterface:
  override def load: MatrixInterface = {
    val file = scala.xml.XML.loadFile("game.xml")
    val player1 = (file \\ "game" \ "player1")
    val player2 = (file \\ "game" \ "player2")

    val p1 = Player1(player1.toString())
    val p2 = Player2(player1.toString())

    val test = Matrix().initFill()
    Matrix(test.getData(), test.getCells(), p1, p2)
  }

  override def save(matrix: MatrixInterface): Unit = {
    val pw = new PrintWriter(new File("game.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(matrixToXML(matrix))
    pw.write(xml)
    pw.close
  }

  def matrixToXML(matrix: MatrixInterface) = {
    <matrix>
    /*
        <turn turn={matrix.getPlayer()}> </turn>

        <player1>
        {}
        </player1>

        <player2>
        {}
        </player2>
    */
        <board board={matrix.getData().toString}> </board>

    </matrix>
  }
