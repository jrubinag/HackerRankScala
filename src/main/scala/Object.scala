package main.scala

object Solution {

  /*
   * Complete the getTotalX function below.
   */
  def getTotalX(a: Array[Int], b: Array[Int]): Int = {
    /*
     * Write your code here.
     */
    23

  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn


    val nm = scan.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val a = scan.readLine.split(" ").map(_.trim.toInt)

    val b = scan.readLine.split(" ").map(_.trim.toInt)
    val total = getTotalX(a, b)

    println(total)

  }
}