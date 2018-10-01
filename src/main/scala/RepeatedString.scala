package main.scala

//https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
object RepeatedString {

  // Complete the repeatedString function below.
  def repeatedString(s: String, n: Long): Long = {
    val numerChars = s.length
    val repeatedAperStringFragment = s.count(_ == 'a')
    val numberOfFragmentsInN : Long = n / numerChars
    val uncompletedChars  : Int = (n % numerChars).toInt

    val numerOfAonUncompletedChars =  uncompletedChars match {
      case 0 => 0
      case _ => {
        println(s"s.substring(uncompletedChars) : ${s.substring(0,uncompletedChars)}")
        s.substring(0,uncompletedChars).count(_ == 'a')
      }
    }

    val TotalNumberOfA = (repeatedAperStringFragment * numberOfFragmentsInN) + numerOfAonUncompletedChars

    println(s"numerChars: $numerChars")
    println(s"repeatedAperStringFragment: $repeatedAperStringFragment")
    println(s"numberOfFragmentsInN: $numberOfFragmentsInN")
    println(s"uncompletedChars: $uncompletedChars")
    println(s"numerOfAonUncompletedChars: $numerOfAonUncompletedChars")
    println(s"TotalNumberOfA: $TotalNumberOfA")

    TotalNumberOfA


  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn


    val s = stdin.readLine

    val n = stdin.readLine.trim.toLong

    val result = repeatedString(s, n)

    println(result)

  }

}
