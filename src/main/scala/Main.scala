@main def hello: Unit = 
  println("Hello world!")
  println(blackCell())


var eol = sys.props("line.separator")

def row(size: Int = 3, len: Int = 10) = ("+" + "-" * size) *len + "+" + eol
def cells(len: Int = 10, fig: String = " ")  = ("|" + " " + fig + " "+ "|" + "   ") * len +  "|" + eol

def blackCell() = (for (i <- 0 to 10){
  for(j <- 0 to 10){
  }
})


//def msg(width: Int = 10, height: Int = 10) = (row(3,width) + cells(width,"O")) * height + row(3,width)
