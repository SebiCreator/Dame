package de.htwg.se.dame.model

import scala.compiletime.ops.boolean

case class Matrix(
    data: List[List[Int]] = Nil,
    cells: Int = 6,
    player1: Player= Player1("A"),
    player2: Player= Player2("B"),
    player: Int = 1
) {

  def initFill1(n: Int) = {
    val r = 0 to cells
    val a = List.tabulate(cells/2)(_ => (0,n))
    a.flatMap(_.toList).toList
  }

  def initFill2(n: Int) = {
    val r = 0 to cells
    val a = List.tabulate(cells/2)(_ => (n,0))
    a.flatMap(_.toList).toList 
  }

  def initFill(): Matrix = {
    val e = (List.tabulate(cells*2)(_ => 0).toList grouped cells).toList
    val it = (cells-2) / 2
    val res1 = for{
      x <- 0 to (it/2) - 1
    }yield(initFill1(1),initFill2(1))

    val res2 = for{
      x <- 0 to (it/2) -1
    }yield(initFill1(2),initFill2(2))

    
    val res3 = res1.flatMap(_.toList).toList
    val res4 = res2.flatMap(_.toList).toList

    Matrix(res3 ++ e ++ res4)

    //val res2 = (res.flatMap(_.toList) grouped cells).flatMap(_.toList).toList
    //Matrix(res2.updated(it,e).updated(it+1,e))
  }

  def numToPlayer(num: Int): String = {
    if (num == 1) player1.toString else if (num == 2) player2.toString else " "
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

  def whichFigure(row: Int, col: Int) : String = {
    val f = data(row)(col)
    f match {
      case 0 => "leer"
      case 1 => "farmer"
      case 2 => "farmer"
      case 3 => "dame"
      case 4 => "dame"
    }
  }

  def move(direction: String,row: Int, col: Int): Matrix = {
    val figure = whichFigure(row,col) 
    Dame_Figure(this,direction,getPlayer(),row,col)
  }

  def changePlayer() = {
    player match{
      case 1 => Matrix(data,cells,player1,player2,2)
      case 2 => Matrix(data,cells,player1,player2,1)
    }
  }

  def getPlayer(): String =  {
    player match {
      case 1 => "Player1"
      case 2 => "Player2"
    }
  }

  def rightMovePossibleL(row: Int, col: Int): Boolean =
    !(col + 1 > cells - 1 || row - 1 < 0)
  def rightMovePossibleU(row: Int, col: Int): Boolean =
    !(col - 1 < 0 || row + 1 > cells - 1)
  def leftMovePossibleL(row: Int, col: Int): Boolean =
    !(col - 1 < 0 || row - 1 < 0)
  def leftMovePossibleU(row: Int, col: Int): Boolean =
    !(col + 1 > cells - 1 || row + 1 > cells - 1) 

  def movePossible(pos: String, direction: String,row: Int, col: Int) : Boolean =  {
    pos match {
      case "lower" => movePossibleLower(direction,row,col)
      case "upper" => movePossibleUpper(direction,row,col)
    }
  }

  def movePossibleLower(direction: String,row: Int, col: Int): Boolean = {
    direction match{
      case "left" => leftMovePossibleL(row,col)
      case "right" => rightMovePossibleL(row,col)
    }
  }

  def movePossibleUpper(direction: String,row: Int, col: Int): Boolean = {
      direction match{
        case "left" => leftMovePossibleU(row,col)
        case "right" => rightMovePossibleU(row,col)
      }
  }

  def moveLeftL(row: Int, col: Int): Matrix = {
    val dcol = col - 1
    val drow = row - 1
    if(!leftMovePossibleL(row, col) || !cellIsEmpty(drow, dcol)) return Matrix(Nil)
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0).changePlayer()
  }

  def moveLeftU(row: Int, col: Int): Matrix = {
    val dcol = col + 1
    val drow = row + 1
    if(!leftMovePossibleU(row, col) || !cellIsEmpty(drow, dcol)) return Matrix(Nil)
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0).changePlayer()
  }

  def moveRightL(row: Int, col: Int): Matrix = {
    val dcol = col + 1
    val drow = row - 1
    if(!rightMovePossibleL(row, col) || !cellIsEmpty(drow, dcol)) return Matrix(Nil)
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0).changePlayer()
  }

  def moveRightU(row: Int, col: Int): Matrix = {
    val dcol = col - 1
    val drow = row + 1
    if(!rightMovePossibleU(row, col) || !cellIsEmpty(drow, dcol)) return Matrix(Nil)
    val sym = data(row)(col)
    replaceCell(drow, dcol, sym).replaceCell(row, col, 0).changePlayer()
  }
}
