package de.htwg.se.dame.model.gameComponent

import de.htwg.se.dame.model.gameComponent.gameBaseImpl._
import de.htwg.se.dame.model.playerComponent.playerBaseImpl._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class BoardCreatorSpec extends AnyWordSpec {
  formatHead("A Board") when {
    "international" should {
      Board("international") should be(
        Matrix(Nil, 10, Player1("A"), Player2("B")).initFill()
      )
    }
    "standard" should {
      Board("standard") should be(
        Matrix(Nil, 8, Player1("A"), Player2("B")).initFill()
      )
    }
    "dev" should {
      Board("dev") should be(
        Matrix(Nil, 6, Player1("A"), Player2("B")).initFill()
      )
    }
    "default" should {
      Board("default") should be(
        Matrix(Nil, 6, Player1("A"), Player2("B")).initFill()
      )
    }
  }
}
