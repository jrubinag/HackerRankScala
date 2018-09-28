package main.scala

// referred to > https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

object SockMerchant {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {

    var lastColor = -1
    var numPares = 0

    for ( color <- ar.sorted ) yield{
      if (lastColor == color)
      {
        numPares += 1
        lastColor = -1
      }
        else lastColor = color
    }
    numPares

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val ar = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = sockMerchant(n, ar)

    println(result)

  }

}
