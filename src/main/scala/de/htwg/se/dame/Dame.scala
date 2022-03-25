

@main def hello: Unit = 
  println("\t Hello world!")
  println("\t Dame v0.1")

  println(singleField())
  println(smallBoard())
  println(classicBoard())
  println(internationalBoard())

  println(coloredBoard())

var eol = sys.props("line.separator")
// current row and cell types
def singleRow(size: Int = 3) = ("+" + "-" *size) + "+" + eol
def singleCell(size: Int = 3, sign: String = "O") = ("|" + " " + sign + " " + "|") + eol
def singleField(size: Int = 3) = singleRow(size) + singleCell(size) + singleRow(size)
def middleCell(size: Int = 3, sign: String = "F") = (" " + sign + " ") + eol
def multiRow(size: Int = 3, len: Int = 10) = ("+" + "-" * size) *len + "+" + eol
def multiCells(len: Int = 10, fig: String = " ")  = ("|" + " " + fig + " ") * len +  "|" + eol



// supported BoardSizes
def customBoard(size: Int = 10) = ( multiRow(3,size) +  multiCells(size) ) * size  + multiRow(3,size) + eol
def classicBoard(size: Int = 8) = customBoard(size) 
def internationalBoard(size: Int = 10) = customBoard(size)
// For Testing only
def smallBoard(size: Int = 6) = customBoard(size)

def isEven(number: Int) = number % 2 == 0
def isOdd(number: Int) = !isEven(number) 

def coloredBoard(length: Int = 10, width: Int = 3, player1: String = "X" , player2: String = "O") = 
  def half(in: Int) = in/2
  def third(in: Int) = in /3
  def pad(in: Int) = in +2

  def scale(wid: Int) = 
    if (isEven(wid)) {
      wid + 1
    }

  def evenRow() = "|" + ( ( ("#" * width) + (" " * width) ) * (half(length))) + "|"
  def evenRowWithPlayer(player: String) = "|" + ( ( ("#" * math.ceil((width*1/3)).toInt + player + ("#" * math.ceil(width*1/3).toInt )) + (" " * width) ) * (half(length))) + "|"
  def oddRow() = "|" + ( ( (" " * width) + ("#" * width) ) * (half(length))) + "|"
  def oddRowWithPlayer(player: String) = "|" + ( ( (" " * width) + ("#" + player1 + "#") ) * (half(length))) + "|"

  println("_" * pad(length * width))
  for (n <- List.range(0,length)) {
    if (isEven(n)) {
      if(n <= 3) {
        println( evenRow() )
        println( evenRowWithPlayer(player1) )
        println( evenRow() )
      } else if (n >= 6) {
        println( evenRow() )
        println( evenRowWithPlayer(player2) )
        println( evenRow() )
      } else {
        println( evenRow() )
        println( evenRow() )
        println( evenRow() )
      }
    }
    if (isOdd(n)) {
      if(n <= 3) {
        println( oddRow() )
        println( oddRowWithPlayer(player1) )
        println( oddRow() )
      } else if (n >= 6) {
        println( oddRow() )
        println( oddRowWithPlayer(player2) )
        println( oddRow() )
      } else {
        println( oddRow() )
        println( oddRow() )
        println( oddRow() )
      }
    }
  }
  println("-" * pad(length * width))
  
val msg = (multiRow() + multiCells()) * 10 + multiRow()

