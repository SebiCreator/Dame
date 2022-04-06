import org.scalatest.{Matchers, WordSpec}

class Dame extends AnyWordSpec {
  // Lines & Cells
  "Dame" should {
    "Have a bLine as String of form  '|# #|' \n" +
      "a wLine as String of form '|   |' \n" +
      "an innerWCell as String in form '   ' \n" +
      "an innerBCell as String in form '###' " in {
        bline(3, 1)
        wline(3, 1)
        innerWCell(3, "0")
        innerBCell(3, "X")
      }
    "Lines & Blocks with symbols \n" +
      "halfFloor should return an Integer divided by to 4/2 = 2 \n" +
      "bLineFull should \n" +
      "wLineFull should \n" +
      "bBlockFull should \n" +
      "wBlockFull should \n" in {
        halfFloor(4)
        bLineFull(3, 3, "X")
        wLineFull(3, 3, "O")
        bBlockFull(3, 3, "X")
        wBlockFull(3, 3, "O")
      }
    "Helper functions \n" +
      "calcTotalWidth should \n" +
      "makeodd should \n" in {
        calcTotalWidth(3, 3)
        makeodd(5)
      }
    "Limit helper functions \n" +
      "upperLimit should \n" +
      "lowerLimit should \n" +
      "limitWrap should \n" in {
        upperLimit(3, 3)
        lowerLimit(3, 3)
        limitWrap(3, 3, "X")
        limitWrap(3, 3, "O")
      }
    "Board functions \n" +
      "emptyBoard should\n" +
      "fullBoard should \n" +
      "fullBoardWrapped should \n " +
      "fullBoardWrapped2 should \n" in {
        emptyBoard(3, 3)
        fullBoard(3, 3, "X")
        fullBoardWrapped(3, 6, "O")
        fullBoardWrapped2(3, 3, "X")
      }
  }
}
