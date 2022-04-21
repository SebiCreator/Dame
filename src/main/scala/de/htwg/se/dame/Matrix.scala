package de.htwg.se.dame

import scala.collection.mutable.ListBuffer
import scala.compiletime.ops.boolean

case class Matrix[T](
    data: List[List[T]],
    cells: Int = 6,
    player1: String = "O",
    player2: String = "X"
) {

  // half of the board
  val center = (cells / 2) - 1
  val test = cells - (2 * center)

  def initFill(): Matrix[Int] = {
    val p1 = List.tabulate((cells * (cells - 2) / 2))(_ => 1)
    val p2 = List.tabulate((cells * (cells - 2) / 2))(_ => 2)
    val mid = List.tabulate(cells * 2)(_ => 0)
    val concat = p1 :: mid :: p2 :: List()
    Matrix(concat)
  }

  def isNext(i : Int) =  (i - ((cells - 1) * 2)) % cells == 0
  def numToPlayer(num: T) : String = {
    if (num == 1) "X" else if (num == 2) "O" else " "
  }


  def tup(): List[List[(String,String)]] = {
    val flat1 = data.flatMap(x => x)
    val flat = flat1.map(x => numToPlayer(x))
    val splitted = flat grouped cells 
    val r = List.range(0,flat.length-1,2)
    val res = for{
      c <- r
    } yield(flat(c),flat(c+1))
    
    val result = (res grouped cells/2).toList
    println(result)
    return result
  }

  /*
  def tupilization(): ListBuffer[ListBuffer[(String, String)]] = {
    val flat = data.flatMap(x => x)
    val z = new ListBuffer[(String, String)]()
    val h = new ListBuffer[ListBuffer[(String, String)]]()
    // val f = List((0, 0))

    for (i <- 0 to flat.size - 1) {
      if (i % 2 == 0) {
        println(flat(i))

        val s1 =
          if (flat(i) == 1) player1
          else if (flat(i) == 2) player2
          else " "

        val s2 =
          if (flat(i + 1) == 1) player1
          else if (flat(i + 1) == 2) player2
          else " "
        val t1 = (s1, s2)
        z += t1

        // f = t1 :: f
        if ((i - ((cells - 1) * 2)) % cells == 0) {
          h += z.clone
          z.clear()
        }
      }
    }

    return h
  }
  */
}
