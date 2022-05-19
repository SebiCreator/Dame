package de.htwg.se.dame.model

import scala.compiletime.ops.boolean

case class Matrix(
    data: List[List[Int]] = Nil,
    cells: Int = 6,
    player1: String = "O",
    player2: String = "X"
) {

  def initFill(): Matrix = {
    val p1 = List.tabulate(cells * 2)(_ => 1)
    val p2 = List.tabulate(cells * 2)(_ => 2)
    val e = List.tabulate(Math.pow(cells, 2).toInt - (cells * 4))(_ => 0)
    val c = p1 ++ e ++ p2
    Matrix((c grouped cells).toList)
  }

  def numToPlayer(num: Int): String = {
    if (num == 1) player1 else if (num == 2) player2 else " "
  }

  def tup(): List[List[(String, String)]] = {
    val flat = data.flatMap(x => x).map(x => numToPlayer(x))
    val r = List.range(0, flat.length - 1, 2)
    val res = for {
      c <- r
    } yield (flat(c), flat(c + 1))
    (res grouped cells / 2).toList
  }

  def replaceCell(row: Int, col: Int, symbol: Int): Matrix = {
    copy(data.updated(row, data(row).updated(col, symbol)))
  }

  def cellIsEmpty(row: Int, col: Int): Boolean = {
    data(row)(col) == 0
  }

  def rightMovePossibleL(row: Int, col: Int): Boolean =
    !(col + 1 > cells - 1 || row - 1 < 0) && !(data(row - 1)(col + 1) != 0)
  def rightMovePossibleU(row: Int, col: Int): Boolean =
    !(col - 1 < 0 || row + 1 > cells - 1) && !(data(col - 1)(row + 1) != 0)
  def leftMovePossibleL(row: Int, col: Int): Boolean =
    !(col - 1 < 0 || row - 1 < 0) && !(data(row - 1)(col - 1) != 0)
  def leftMovePossibleU(row: Int, col: Int): Boolean =
    !(col + 1 > cells - 1 || row + 1 > cells - 1) && !(data(row + 1)(
      col + 1
    ) != 0)

  def moveLeftL(row: Int, col: Int): Matrix = {
    val dcol = col - 1
    val drow = row - 1
    // Better Error Handling
    if (!leftMovePossibleL(row, col)) {
      return Matrix(Nil)
    }
    if (!cellIsEmpty(drow, dcol)) {
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0)
  }

  def moveLeftU(row: Int, col: Int): Matrix = {
    val dcol = col + 1
    val drow = row + 1
    // Better Error Handling
    if (!leftMovePossibleU(row, col)) {
      return Matrix(Nil)
    }
    if (!cellIsEmpty(drow, dcol)) {
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0)
  }

  def moveRightL(row: Int, col: Int): Matrix = {
    val dcol = col + 1
    val drow = row - 1
    // Better Error Handling
    if (!rightMovePossibleL(row, col)) {
      return Matrix(Nil)
    }
    if (!cellIsEmpty(drow, dcol)) {
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0)
  }

  def moveRightU(row: Int, col: Int): Matrix = {
    val dcol = col - 1
    val drow = row + 1
    // Better Error Handling
    if (!leftMovePossibleU(row, col)) {
      return Matrix(Nil)
    }
    if (!cellIsEmpty(drow, dcol)) {
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0)
  }

}
