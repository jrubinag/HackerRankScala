package main.scala

// code for https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
object CountingValleys {

  // Complete the countingValleys function below.
  def countingValleys(n: Int, s: String): Int = {

    var currentValue = 0
    var contValleys = 0


    for (char <- s ) {
      val comesFromDown = currentValue < 0
      char match {
        case 'U' => currentValue += 1
        case 'D' => currentValue -= 1
        case _ => currentValue
      }
      if (comesFromDown &&  (currentValue == 0)) contValleys += 1
    }
    contValleys

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val n = stdin.readLine.trim.toInt

    val s = stdin.readLine

    val result = countingValleys(n, s)
    println(result)
  }

}
