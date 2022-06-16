package de.htwg.se.dame.model.fileIOComponent.fileIOXML

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import de.htwg.se.dame.model.gameComponent.gameBaseImpl.Matrix

class FileIOXMLSpec extends AnyWordSpec:
  val fileIO = FileIO()
  val matrix = Matrix().initFill()

  "The FileIO with the XML implementation" should {
    "save a the current game and its stats in game.xml" in {
      fileIO.save(matrix)
    }

    "load a game and its stats from game.xml" in {
      val load = fileIO.load

      load.getData().equals(matrix.getData()) should be(true)
    }
  }