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
    val player1 = (file \\ "player1").text.toString.trim()
    val player2 = (file \\ "player2").text.toString.trim()
    val turn = (file \\ "turn" ).text.toString.trim()
    val data = (file \\ "board").text.replaceAll(" ","").replaceAll("\n","").toList
    val cells = (file \\ "cells").text.toInt

    val data1 = data.map(_.asDigit)

    val extract = (data1 grouped cells).toList

    val p1 = Player1(player1)
    val p2 = Player2(player2)


    val m = Matrix(extract, cells, p1, p2)
    val name = m.getName_()

    if(turn == name) {
      return m
    } else {
      return m.changePlayer()
    }
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
        <turn>{matrix.getName_()} </turn>
        <player1>
        {matrix.getplayerNames(1)}
        </player1>
        <player2>
        {matrix.getplayerNames(2)}
        </player2>
        <board>{matrix.getData()}</board>
        <cells>{matrix.getCells()}</cells>
    </matrix>
  }
