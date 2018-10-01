package main.scala


// Solution for https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
object JumpingClouds {

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int]): Int = {

    var currentPos = 0
    //0 for columbus , 1 for rain
    var nJumps = 0

    for ( (e,count) <- c.zipWithIndex ) {
      println(s"$count is $e")
      if (currentPos == count && count <= c.size-2) {
        println(s"currentPos == count && count < c.size-2")
        println(s"$currentPos == $count && $count < ${c.size-2}")

        c(currentPos+ 1) match {
          case 1 => currentPos += 2
          case 0 => if(currentPos+2 <= c.size-1) { c(currentPos+2) match {
            case 1 => currentPos += 1
            case 0 => currentPos += 2
            case _ => -5
            }
          }
        }
        nJumps += 1
        println(s"nJumps = $nJumps")
      }
      else {
        println(s"else")
        println(s"$currentPos == $count && $count < ${c.size-2}")
      }

    }
    nJumps
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val n = stdin.readLine.trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c)

    println(result)

  }

}
