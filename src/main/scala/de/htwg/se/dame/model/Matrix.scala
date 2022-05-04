package de.htwg.se.dame.model

import scala.collection.mutable.ListBuffer

import scala.compiletime.ops.boolean

case class Matrix(
    data: List[List[Int]] = Nil,
    cells: Int = 6,
    player1: String = "O",
    player2: String = "X"
) {


  def initFill(): Matrix = {
    val p1 = List.tabulate(cells*2)(_ => 1) 
    val p2 = List.tabulate(cells*2)(_ => 2) 
    val e = List.tabulate(Math.pow(cells,2).toInt - (cells*4))(_ => 0)
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

  def moveLeft2(row: Int, col: Int): Matrix = {
    val dcol = col-1
    val drow = row-1
    // Better Error Handling
    if(!leftMovePossible2(row,col)){
      println("Nicht möglich")
      return Matrix(Nil)
    }
    if(!cellIsEmpty(drow,dcol)){
      println("Besetzt")
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow,dcol,sym).replaceCell(row,col,0)
  }

  def moveLeft1(row: Int, col: Int): Matrix= {
    val dcol = col+1
    val drow = row+1
    // Better Error Handling
    if(!leftMovePossible1(row,col)){
      println("Nicht möglich")
      return Matrix(Nil)
    }
    if(!cellIsEmpty(drow,dcol)){
      println("Besetzt")
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow,dcol,sym).replaceCell(row,col,0)
  }

  def moveRight2(row: Int, col: Int): Matrix = {
    val dcol = col+1
    val drow = row-1
    // Better Error Handling
    if(!rightMovePossible2(row,col)){
      println("Nicht möglich")
      return Matrix(Nil)
    }
    if(!cellIsEmpty(drow,dcol)){
      println("Besetzt")
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow,dcol,sym).replaceCell(row,col,0)
  }

  def moveRight1(row: Int, col: Int): Matrix= {
    val dcol = col-1
    val drow = row+1
    // Better Error Handling
    if(!leftMovePossible1(row,col)){
      println("Nicht möglich")
      return Matrix(Nil)
    }
    if(!cellIsEmpty(drow,dcol)){
      println("Besetzt")
      return Matrix(Nil)
    }
    val sym = data(row)(col)
    replaceCell(drow,dcol,sym).replaceCell(row,col,0)
  }


  def rightMovePossible2(row: Int, col: Int): Boolean = {
    val pcell = cells-1
    
    if(col+1 > pcell || row-1 < 0){
      return false
    }
    if (data(row-1)(col+1) != 0){
      return false
    }
    return true
  }

  def rightMovePossible1(row: Int, col: Int): Boolean = {
    val pcell = cells-1
    if(col-1 < 0 || row+1 > pcell){
      return false
    }
    if(data(col-1)(row+1) != 0){
      return false
    }
    return true
  }

  def leftMovePossible2(row: Int, col: Int): Boolean = {
    val pcell = cells-1

    if(col-1 < 0 || row-1 < 0){
      return false
    }
    if(data(row-1)(col-1) != 0){
      return false
    }
    return true
  }

  def leftMovePossible1(row: Int, col: Int): Boolean = {
    val pcell = cells-1

    if(col+1 > pcell || row+1 > pcell){
      return false
    }
    if(data(row+1)(col+1) != 0){
      return false
    }
    return true
  }

  def rightJumpPossible2(row: Int, col: Int, player: Int): Boolean = {
    val pcell = cells -1
    val des = if(player == 1) 2 else 1
    val erow = row-1
    val ecol = col+1
    val drow = row-2
    val dcol = col+2
    if(erow < 0 || ecol > pcell || drow < 0 || dcol > pcell){
      return false
    }
    if( (data(erow)(ecol) == des) && (data(drow)(dcol) == 0)){
      return true
    }else {
      return false
    }

  }
  
  def jumpLeftPossible2(row: Int, col: Int, player: Int): Boolean = {
    val des = if(player == 1) 2 else 1
    val erow = row-1
    val ecol = col-1
    val drow = row-2
    val dcol = col-2
    if(erow < 0 || ecol < 0 || drow < 0 || dcol < 0){
      return false
    }
    if((data(erow)(ecol) == des) && (data(drow)(dcol) == 0)){
      return true
    }
    return false
  }

  

}
