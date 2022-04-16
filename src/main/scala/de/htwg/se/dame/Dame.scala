package de.htwg.se.dame
import de.htwg.se.tui.Tui

@main def hello: Unit = 
  val l1 = List(("A","B"),("C","D"),("E","F"),("G","H"))
  val l2 = List(("X","X"),("X","X"),("X","X"),("X","X"))
  val l3 = List(("X","X"),("X","X"),("X","X"),("X","X"))
  val l4 = List(("H","G"),("F","E"),("D","C"),("B","A"))
  val e1 = List(l1,l2,l3,l4)

  val l5 = List(("A","B"),("C","D"),("E","F"),("G","H"),("A","B"),("C","D"),("E","F"),("G","H"))
  val l6 = List(("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"))
  val l7 = List(("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"))
  val l8 = List(("H","G"),("F","E"),("D","C"),("B","A"),("H","G"),("F","E"),("D","C"),("B","A"))
  val l9 = List(("H","G"),("F","E"),("D","C"),("B","A"),("H","G"),("F","E"),("D","C"),("B","A"))
  val l10 = List(("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"))
  val l11 = List(("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"),("X","X"))
  val l12 = List(("A","B"),("C","D"),("E","F"),("G","H"),("A","B"),("C","D"),("E","F"),("G","H"))
  val e2 = List(l5,l6,l7,l8,l9,l10,l11,l12)

  welcomeMessage()
  Tui().processInputLine("help")
  Tui().processInputLine("custom")
  //println(modLine(4,l))
  //println(modBlock(3,2,l1))
  //println(modBoardWrapped(5,4,e1))
  println(modBoardWrapped(5,8,e2))
  //println(bBlockFull(3,2,"X"))

def welcomeMessage() =
 println("     __          __  _                            _          _____                                  ")
 println("     \\ \\        / / | |                          | |        |  __ \\                              ")
 println("      \\ \\  /\\  / ___| | ___ ___  _ __ ___   ___  | |_ ___   | |  | | __ _ _ __ ___   ___         ")
 println("       \\ \\/  \\/ / _ | |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | |  | |/ _` | '_ ` _ \\ / _ \\  ")
 println("        \\  /\\  |  __| | (_| (_) | | | | | |  __/ | || (_) | | |__| | (_| | | | | | |  __/         ")
 println("         \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_____/ \\__,_|_| |_| |_|\\___| ")
 println("                                                                                                    ")


var eol = sys.props("line.separator")

// Helper
def calcTotalWidth(cellsize: Int, nFields: Int) = (cellsize * nFields) + 2
def makeodd(number: Int) = (number*2) + 1
def halfFloor(num: Int) = (num/2).toInt  

// Lines & Cells
def bLine(cellsize: Int, nfields: Int) = "|" + (("#" * cellsize) + (" " * cellsize))*halfFloor(nfields) + "|" + eol
def wLine(cellsize: Int, nfields: Int) = "|" + ((" " * cellsize) + ("#" * cellsize))*halfFloor(nfields) + "|" + eol
def innerWCell(cellsize: Int,symbol: String) = " " * (cellsize/2).toInt + symbol + " " * (cellsize/2).toInt
def innerBCell(cellsize: Int,symbol: String) = "#" * ((cellsize/2).toInt) + symbol + "#" * ((cellsize/2).toInt) 



// Lines & Blocks with symbols
def bLineFull(cellsize: Int, nFields: Int, symbol: String) = "|" + (innerBCell(cellsize,symbol) + innerWCell(cellsize,symbol)) * halfFloor(nFields) + "|" +  eol 
def wLineFull(cellsize: Int, nFields: Int, symbol: String) = "|" + (innerWCell(cellsize,symbol) + innerBCell(cellsize,symbol)) * halfFloor(nFields) + "|" + eol 
def bBlockFull(cellsize: Int, nFields: Int, symbol: String) = (bLine(cellsize,nFields) * (cellsize/2).toInt) +  bLineFull(cellsize,nFields,symbol) + (bLine(cellsize,nFields) * (cellsize/2).toInt)
def wBlockFull(cellsize: Int, nFields: Int, symbol: String) = (wLine(cellsize,nFields) * (cellsize/2).toInt) +  wLineFull(cellsize,nFields,symbol) + (wLine(cellsize,nFields) * (cellsize/2).toInt)


// Limits
def upperLimit(cellsize: Int, nFields: Int) = "_" * calcTotalWidth(cellsize,nFields) + eol
def lowerLimit(cellsize: Int, nFields: Int) = "-" * calcTotalWidth(cellsize,nFields) + eol
def limitWrap(cellsize: Int, nFields: Int, content: String) = upperLimit(cellsize,nFields) + content + lowerLimit(cellsize,nFields)

// Board
def emptyBoard(cellsize: Int,nfields: Int) = (bLine(cellsize,nfields)*cellsize + wLine(cellsize,nfields)*cellsize) * nfields
def fullBoard(cellsize: Int, nFields: Int, symbol: String) = (bBlockFull(cellsize,nFields,symbol)+ wBlockFull(cellsize,nFields,symbol)) * (nFields/2)

// nFields muss gerade sein , cellwith muss ungerade sein
def fullBoardWrapped(cellsize: Int, nFields: Int, symbol: String) = limitWrap(makeodd(cellsize),nFields*2,fullBoard(makeodd(cellsize),nFields*2,symbol))
// alle Argumente möglich ( cellsize:  wieviel pix um symbol, nFields Anzahl der Doppelfelder)
def fullBoardWrapped2(cellsize: Int, nFields: Int, symbol: String) = limitWrap(makeodd(cellsize),nFields*2,fullBoard(makeodd(cellsize),nFields*2,symbol))
def autoBoard(size: Int, symbol: String) = limitWrap(makeodd(size),size*2,fullBoard(makeodd(size),size*2,symbol))


//Modified
//def to2Tuple(entrys: List[String]) = entrys.map()
def modLine(cellsize: Int, symbols: List[(String,String)]) = "|" + symbols.map((a,b) => innerBCell(cellsize,a) + innerWCell(cellsize,b)).mkString("") + "|" + eol
def modBlock(cellsize: Int, nFields: Int, symbols: List[(String,String)]) = (bLine(cellsize,nFields*4) * (cellsize/2).toInt) +  modLine(cellsize,symbols) + (bLine(cellsize,nFields*4) * (cellsize/2).toInt)
def modBoard(cellsize: Int, nFields: Int, symbols: List[List[(String,String)]]) = symbols.map(l => modBlock(cellsize,nFields/2,l)).mkString("")
def modBoardWrapped(cellsize: Int, nFields: Int,symbols: List[List[(String,String)]]) = limitWrap(cellsize*2,nFields,modBoard(cellsize,nFields,symbols))

  

