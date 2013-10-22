//given a grid of numbers, quickly get the average of a subrectangle of those numbers
//topLeft and bottomRight must represent a subrectangle that exists inside grid
//topLeft and bottomRight are both represented as (row, col), and must actually represent a rectangle
def gridAverage(grid: Array[Array[Int]], topLeft: (Int, Int), bottomRight: (Int, Int)): Double = {
  val (topRow, leftCol) = topLeft
  val (bottomRow, rightCol) = bottomRight
  val correctRows = grid.slice(topRow, bottomRow + 1)
  val sums = correctRows.map { col =>
    col.foldLeft(0D) { (agg, cur) =>
      agg + cur
    }
  }
  val sum = sums.foldLeft(0D) { (agg, cur) =>
    agg + cur
  }
  val area = (bottomRow - topRow) * (rightCol - leftCol)
  sum / area
}