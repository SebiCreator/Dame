package de.htwg.se.dame.model


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
        bLine(3, 1)
        wLine(3, 1)
        innerWCell(3, "0")
        innerBCell(3, "X")
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
        halfFloor(4)
        bLineFull(3, 3, "X")
        wLineFull(3, 3, "O")
        bBlockFull(3, 3, "X")
        wBlockFull(3, 3, "O")
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
        calcTotalWidth(3, 3)
        makeodd(5)
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
        upperLimit(3, 3)
        lowerLimit(3, 3)
        limitWrap(3, 3, emptyBoard(3, 3))
        limitWrap(3, 3, fullBoard(3, 3, "X"))
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
        emptyBoard(3, 3)
        fullBoard(3, 3, "X")
        fullBoardWrapped(3, 6, "O")
        fullBoardWrapped(3, 6, "X")
        fullBoardWrapped(5, 10, "O")
        fullBoardWrapped2(5, 10, "X")
      }
  }
}
