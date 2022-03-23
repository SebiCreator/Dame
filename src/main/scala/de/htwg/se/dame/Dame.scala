@main def hello: Unit = 
  println("Hello world!")
  println(msg)


var eol = sys.props("line.separator")

def row(size: Int = 3, len: Int = 10) = ("+" + "-" * size) *len + "+" + eol
def cells(len: Int = 10, fig: String = " ")  = ("|" + " " + fig + " "+ "|" + "   ") * len +  "|" + eol

def blackCell() = (for (i <- 0 to 10){
  for(j <- 0 to 10){
  }
})

val msg = (row() + cells()) * 10 + row()

