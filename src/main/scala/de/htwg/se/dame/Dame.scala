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
  for (n <- List.range(0,10)) {
    
    if (isEven(n)) {
      if(n <= 3) {
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
        println( "|" + ( ( ("#" + player1 + "#") + (" " * 3) ) * (length/2)) + "|")
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
      } else if (n >= 6) {
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
        println( "|" + ( ( ("#" * 3) + (" " + player2 + " ") ) * (length/2)) + "|")
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
      } else {
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
        println( "|" + ( ( ("#" * 3) + (" " * 3) ) * (length/2)) + "|")
      }
    }
    if (isOdd(n)) {
      if(n <= 3) {
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
        println( "|" + ( ( (" " * 3) + ("#" + player1 + "#") ) * (length/2)) + "|")
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
      } else if (n >= 6) {
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
        println( "|" + ( ( (" " *3 ) + ("#" + player2 + "#") ) * (length/2)) + "|")
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
      } else {
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
        println( "|" + ( ( (" " * 3) + ("#" * 3) ) * (length/2)) + "|")
      }
    }
    
  }
  
def blackCell() = (for (i <- 0 to 10){
  for(j <- 0 to 10){
  }
})

val msg = (multiRow() + multiCells()) * 10 + multiRow()

