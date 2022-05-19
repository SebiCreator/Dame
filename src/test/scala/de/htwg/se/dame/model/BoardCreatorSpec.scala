package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class BoardCreatorSpec extends AnyWordSpec {
  formatHead("A Board") when {
    "international" should {
      BoardCreator.createBoard("international") should be(
        fullBoardWrapped2(2, 5, "X")
      )
    }
    "standard" should {
      BoardCreator.createBoard("standard") should be(
        fullBoardWrapped2(2, 4, "X")
      )
    }
    "dev" should {
      BoardCreator.createBoard("dev") should be(fullBoardWrapped2(2, 3, "X"))
    }
    "default" should {
      BoardCreator.createBoard("default") should be(
        fullBoardWrapped2(2, 3, "X")
      )
    }
  }
}
