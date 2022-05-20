package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class BoardCreatorSpec extends AnyWordSpec {
  formatHead("A Board") when {
    "international" should {
      BoardCreator("international") should be(
        fullBoardWrapped2(2, 5, "X")
      )
    }
    "standard" should {
      BoardCreator("standard") should be(
        fullBoardWrapped2(2, 4, "X")
      )
    }
    "dev" should {
      BoardCreator("dev") should be(fullBoardWrapped2(2, 3, "X"))
    }
    "default" should {
      BoardCreator("default") should be(
        fullBoardWrapped2(2, 3, "X")
      )
    }
  }
}
