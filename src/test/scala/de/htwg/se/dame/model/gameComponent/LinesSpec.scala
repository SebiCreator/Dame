package de.htwg.se.dame.model.gameComponent

import de.htwg.se.dame.model.gameComponent.gameBaseImpl._
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

def formatHead(str: String) = "%2$s %1$s %2$s".format(str, "##")
def formatText(str: String) = "%2$s %1$s %2$s\n".format(str, "  ")

class LinesSpec extends AnyWordSpec {
  // Lines & Cells
  formatHead(" Lines and Cells ") should {
    '\n' +
      formatText("have a bLine as String of form    '|###|'") +
      formatText("a wLine as String of form         '|   |'") +
      formatText("an innerWCell as String in form   ' O '") +
      formatText("an innerBCell as String in form   '#X#'") in {
        val x = Lines
        x.bLine(3, 1)
        x.wLine(3, 1)
        x.innerWCell(3, "0")
        x.innerBCell(3, "X")
      }
  }
  formatHead(" Lines & Blocks with symbols ") should {
    '\n' +
      formatText("return in halffloor an Integer divided by to 2") +
      formatText(
        "bLineFull returns a String of a full Black Line '|#X#| * nFields'"
      ) +
      formatText(
        "wLineFull returns a String of a full White Line '| O | * nFields'"
      ) +
      formatText(
        "bBlockFull returns a String of a full Black Block (y-axis) '|#X#| *nFields * cellsize'"
      ) +
      formatText(
        "wBlockFull returns a String of a full White Block (y-axis) '| O | *nFields * cellsize'"
      ) in {
        val line = Lines
        line.halfFloor(4)
        line.bLineFull(3, 3, "X")
        line.wLineFull(3, 3, "O")
        line.bBlockFull(3, 3, "X")
        line.wBlockFull(3, 3, "O")
      }
  }
  formatHead("Helper functions") should {
    '\n' +
      formatText(
        "calcTotalWidth returns cellSize * nFields to calculate the full boardSize"
      ) +
      formatText(
        "makeodd always returns an uneven Integer  '(number * 2) + 1' "
      ) in {
        val line = Lines
        line.calcTotalWidth(3, 3)
        line.makeodd(5)
      }
  }
  formatHead("Limit helper functions") should {
    '\n' +
      formatText(
        "upperLimit returns a String to draw the upper GameBoard line"
      ) +
      formatText(
        "lowerLimit returns a String to draw the lower GameBoard line"
      ) +
      formatText(
        "limitWrap returns a GameBoard as String with upper and lower lines"
      ) in {
        val line = Lines
        line.upperLimit(3, 3)
        line.lowerLimit(3, 3)
        line.limitWrap(3, 3, line.emptyBoard(3, 3))
        line.limitWrap(3, 3, line.fullBoard(3, 3, "X"))
      }
  }
  formatHead("Board functions") should {
    '\n' +
      formatText("emptyBoard returns the Gameboard as String without players") +
      formatText(
        "fullBoard returns the Gameboard as String with playerPositions"
      ) +
      formatText(
        "fullBoardWrapped returns the fullGameboard as String without players and upper, lower Bounds"
      ) +
      formatText(
        "fullBoardWrapped2 returns the fullGameboard as String without players and upper, lower Bounds"
      ) in {
        val line = Lines
        line.emptyBoard(3, 3)
        line.fullBoard(3, 3, "X")
        line.fullBoardWrapped(3, 6, "O")
        line.fullBoardWrapped(3, 6, "X")
        line.fullBoardWrapped(5, 10, "O")
        line.fullBoardWrapped2(5, 10, "X")
      }
  }
  /*
  formatHead("Modified functions") should {
    modLine(2, List(("1", "1"), ("2", "2"))) should be("|#O# X #O# X |\n")

    modBlock(
      1,
      4,
      List(("1", "0"), ("2", "0"), ("1", "1"), ("2", "2"))
    ) should be(
      "|OXOXOXOX|\n"
    )

    modBoard(
      1,
      4,
      List(
        List(("1", "1"), ("2", "2")),
        List(("0", "0"), ("1", "1")),
        List(("0", "0"), ("1", "1")),
        List(("0", "0"), ("1", "1"))
      )
    ) should be("|OXOX|\n|OXOX|\n|OXOX|\n|OXOX|\n")

    modBoardWrapped(
      1,
      2,
      List(
        List(("1", "1"), ("2", "2")),
        List(("0", "0"), ("1", "1")),
        List(("0", "0"), ("1", "1")),
        List(("0", "0"), ("1", "1"))
      )
    ) should be("______\n|OXOX|\n|OXOX|\n|OXOX|\n|OXOX|\n------\n")

  }
   */
}
