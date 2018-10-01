package main.scala

import scala.collection.mutable.ListBuffer

//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
object Array2DDS {

  // Complete the hourglassSum function below.
  def hourglassSum(arr: Array[Array[Int]]): Int = {

    var sums = new ListBuffer[Int]()
    var rowIndex = 0
    var colIndex = 0

//    for((row,indexI) <- arr.zipWithIndex){
//      for((col,indexJ) <- row.zipWithIndex){
//
//      }
//    }

    for (rowIndex <- 0 to arr.size -1 ) {
      for (colIndex <- 0 to arr(0).size -1 ){
        print(s"${arr(rowIndex)(colIndex)}")
      }
      println("")
    }

    for (rowIndex <- 0 to 3 ) {
      var row = rowIndex
      for (colIndex <- 0 to 3 ){
        var col = colIndex
        print(s"${arr(rowIndex)(colIndex)}")
      }
      println("")
    }
      0
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = hourglassSum(arr)

    println(result)

  }

}
