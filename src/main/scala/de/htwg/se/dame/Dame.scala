@main def hello: Unit = 
  println("\t Hello world!")
  println("\t Dame v0.1")


  println(fullBoardWrapped2(4,4,"X"))

var eol = sys.props("line.separator")

// Lines & Cells
def bLine(cellsize: Int, nfields: Int) = "|" + (("#" * cellsize) + (" " * cellsize))*halfFloor(nfields) + "|" + eol
def wLine(cellsize: Int, nfields: Int) = "|" + ((" " * cellsize) + ("#" * cellsize))*halfFloor(nfields) + "|" + eol
def innerWCell(cellsize: Int,symbol: String) = " " * (cellsize/2).toInt + symbol + " " * (cellsize/2).toInt
def innerBCell(cellsize: Int,symbol: String) = "#" * ((cellsize/2).toInt) + symbol + "#" * ((cellsize/2).toInt) 

// Lines & Blocks with symbols
def halfFloor(num: Int) = (num/2).toInt  
def bLineFull(cellsize: Int, nFields: Int, symbol: String) = "|" + (innerBCell(cellsize,symbol) + innerWCell(cellsize,symbol)) * halfFloor(nFields) + "|" +  eol 
def wLineFull(cellsize: Int, nFields: Int, symbol: String) = "|" + (innerWCell(cellsize,symbol) + innerBCell(cellsize,symbol)) * halfFloor(nFields) + "|" + eol 
def bBlockFull(cellsize: Int, nFields: Int, symbol: String) = (bLine(cellsize,nFields) * (cellsize/2).toInt) +  bLineFull(cellsize,nFields,symbol) + (bLine(cellsize,nFields) * (cellsize/2).toInt)
def wBlockFull(cellsize: Int, nFields: Int, symbol: String) = (wLine(cellsize,nFields) * (cellsize/2).toInt) +  wLineFull(cellsize,nFields,symbol) + (wLine(cellsize,nFields) * (cellsize/2).toInt)

// Helper
def calcTotalWidth(cellsize: Int, nFields: Int) = (cellsize * nFields) + 2
def makeodd(number: Int) = (number*2) + 1

// Limits
def upperLimit(cellsize: Int, nFields: Int) = "_" * calcTotalWidth(cellsize,nFields) + eol
def lowerLimit(cellsize: Int, nFields: Int) = "-" * calcTotalWidth(cellsize,nFields) + eol
def limitWrap(cellsize: Int, nFields: Int, content: String) = upperLimit(cellsize,nFields) + content + lowerLimit(cellsize,nFields)

// Board
def emptyBoard(cellsize: Int,nfields: Int) = (bLine(cellsize,nfields)*cellsize + wLine(cellsize,nfields)*cellsize) * nfields
def fullBoard(cellsize: Int, nFields: Int, symbol: String) = (bBlockFull(cellsize,nFields,symbol)+ wBlockFull(cellsize,nFields,symbol)) * (nFields/2)

// nFields muss gerade sein , cellwith muss ungerade sein
def fullBoardWrapped(cellsize: Int, nFields: Int, symbol: String) = limitWrap(makeodd(cellsize),nFields*2,fullBoard(makeodd(cellsize),nFields*2,"X"))
// alle Argumente möglich
def fullBoardWrapped2(cellsize: Int, nFields: Int, symbol: String) = limitWrap(makeodd(cellsize),nFields*2,fullBoard(makeodd(cellsize),nFields*2,"X"))



  

