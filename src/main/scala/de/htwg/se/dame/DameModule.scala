package de.htwg.se.dame

import com.google.inject.AbstractModule
import com.google.inject.TypeLiteral
import com.google.inject.name.Names
import com.google.inject.Binder
import net.codingwell.scalaguice.ScalaModule

import de.htwg.se.dame.controllerComponent.controllerBaseImpl.Controller
import de.htwg.se.dame.model.gameComponent.*
import de.htwg.se.dame.model.playerComponent.*
import de.htwg.se.dame.model.fileIOComponent.*
import de.htwg.se.dame.controllerComponent.ControllerInterface

class DameModule extends AbstractModule:
  override protected def configure(): Unit = {
    bind(classOf[ControllerInterface]).toInstance(Controller(None))
    bind(classOf[FileIOInterface]).toInstance(fileIOJson.FileIO())
  }
