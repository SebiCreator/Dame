package de.htwg.se.dame.model

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class BoardCreatorSpec extends AnyWordSpec {
  formatHead("A Board") when {
    "international" should {
      Board("international") should be(
        fullBoardWrapped2(2, 5, "X")
      )
    }
    "standard" should {
      Board("standard") should be(
        fullBoardWrapped2(2, 4, "X")
      )
    }
    "dev" should {
      Board("dev") should be(fullBoardWrapped2(2, 3, "X"))
    }
    "default" should {
      Board("default") should be(
        fullBoardWrapped2(2, 3, "X")
      )
    }
  }
}
