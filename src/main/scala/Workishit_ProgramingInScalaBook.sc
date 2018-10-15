import scala.collection.mutable.ListBuffer
// 7.1 If expressions

case class AssetAllocationTier1Data(assetClass : String,
                                    portfolioPercent: Double,
                                    dollarValue: Double,
                                    targetPercentage: Double,
                                    targetDollar: Double,
                                    dollarTargetDifference: Double,
                                    allocations: List[AssetAllocationTier2Data])

case class AssetAllocationTier2Data(assetClass: String,
                                    portfolioPercent: Double,
                                    dollarValue: Double,
                                    targetPercentage: Double,
                                    dollarTargetDifference: Double
                                   )

val tier1Allocations = List(AssetAllocationTier1Data("T1_US_STOCKS",4.729530454610485,17082.70597659766,44.0,158924.6692,141841.96322340233,
  List(AssetAllocationTier2Data("T2_US_LARGE_CAP",3.6727378764882648,13265.651183618362,24.0,73420.53201638164),
    AssetAllocationTier2Data("T2_US_MID_CAP",0.7045283854148139,2544.703195319532,10.0,33574.53980468047),
    AssetAllocationTier2Data("T2_US_SMALL_CAP",0.35226419270740694,1272.351597659766,4.0,13175.345602340234),
    AssetAllocationTier2Data("T2_REAL_ESTATE",0.0,0.0,6.0,21671.5458))),
  AssetAllocationTier1Data("T1_INTERNATIONAL_STOCKS",1.5119386917411533,5461.008100810081,21.0,75850.4103,70389.40219918992,
    List(AssetAllocationTier2Data("T2_INTERNATIONAL_STOCKS",1.2851478879799803,4641.856885688569,14.0,45925.083314311436),
      AssetAllocationTier2Data("T2_EMERGING_STOCKS",0.226790803761173,819.1512151215121,7.0,24464.31888487849))),
  AssetAllocationTier1Data("T1_BONDS",7.711545633419391,27853.51906390639,35.0,126417.3505,98563.8314360936,
    List(AssetAllocationTier2Data("T2_US_GOVERNMENT_BONDS",3.03023474853897,10944.978522952295,16.0,46845.810277047705),
      AssetAllocationTier2Data("T2_US_CREDIT_BONDS",1.555275602670922,5617.537742484248,6.0,16054.008057515752),
      AssetAllocationTier2Data("T2_US_MORTGAGE",2.082744916577429,7522.7169748874885,13.0,39432.29892511251),
      AssetAllocationTier2Data("T2_INTERNATIONAL_BONDS",1.0432903656320702,3768.2858235823587,0.0,-3768.2858235823587))),
  AssetAllocationTier1Data("T1_CASH",78.24316047743962,282608.37263726373,0.0,0.0,-282608.37263726373,
    List(AssetAllocationTier2Data("T2_CASH_AND_EQUIVALENTS",78.24316047743962,282608.37263726373,0.0,-282608.37263726373))),
  AssetAllocationTier1Data("T1_OTHER",7.803824742789361,28186.824221422143,0.0,0.0,-28186.824221422143,
    List(AssetAllocationTier2Data("T2_COMMODITIES",7.760644374523575,28030.86,0.0,-28030.86),
      AssetAllocationTier2Data("T2_OTHER",0.043180368265786244,155.9642214221422,0.0,-155.9642214221422))))





def extractLevel2Data (assetAllocationsdata : List[AssetAllocationTier1Data]) : List[AssetAllocationTier2Data] = {

  assetAllocationsdata.flatMap(_.allocations)
}

def roundDown(decimal : Double, numberOfDecimals : Int) : Double =  {
  BigDecimal(decimal).setScale(numberOfDecimals, BigDecimal.RoundingMode.FLOOR).toDouble
}

def sum(xs: List[(String,Double)]): Double = {

  def inner(xs: List[(String,Double)], accum: Double): Double = {
    xs match {
      case x :: tail => inner(tail, accum + x._2)
      case Nil => accum
    }
  }
  inner(xs, 0.0)
}


def getDecimalPart( number : Double) : Int = {
    val integer = number.toInt
//  println(s"(number - integer) : ${(number - integer)}")
  val decimal =  (number - integer)
  val decimalRounded = BigDecimal(decimal).setScale(1, BigDecimal.RoundingMode.HALF_UP).toDouble
//  println(s"decimalRounded : ${decimalRounded}")
  ( decimalRounded* 10).toInt
}

def getDecimalPartWthPrecision(number : Double) : Double = {
  val integer = number.toInt
  //println(s"integer : $integer")
  val decimal  = (number - integer)
  //println(s"decimal : $decimal")
  decimal
}

def getRestOfDecimalPart(number : Double) : Double = {
  val roundedDowNumber = roundDown(number,1)
  //println(s"integer : $integer")
  val decimal  = (number - roundedDowNumber)
  //println(s"decimal : $decimal")
  decimal
}

//Add up the portfolio percentages
def getSumPortFolioTier2(assetsTier2Data : List[AssetAllocationTier2Data]) : Double = {

  def inner(xs: List[AssetAllocationTier2Data], accum: Double): Double = {
    xs match {
      case x :: tail => inner(tail, accum + x.portfolioPercent)
      case Nil => accum
    }
  }
  inner(assetsTier2Data, 0.0)
}

//Recalculating portfolio percents of the Tier 1 using the Tier2's percentages rounded
def recalculatePortfolioPercentsT1( assetsData : List[AssetAllocationTier1Data]) : List[AssetAllocationTier1Data] = {
  assetsData.map(tier1Data => tier1Data.copy(portfolioPercent = roundDown(getSumPortFolioTier2(tier1Data.allocations),1) ))
}

//def adjustToOneDecimal() :Unit = {
//  println(s"adjustToOneDecimal")
//
//  println(s"var : $tier1Allocations")
//
//  val level2Data  = extractLevel2Data(tier1Allocations)
//  println(s"calling  extractLevel2Data: $level2Data")
//
//  val roundedValuesDown = level2Data.map(x => x.copy(portfolioPercent = roundDown(x.portfolioPercent,1)))
//  println(s"roundedValuesDown : $roundedValuesDown")
//
//  val tuplasWithOutRounding : List[(String,Double)] = level2Data.map(x => (x.assetClass,x.portfolioPercent))
//  println(s"tuplasWithOutRounding : $tuplasWithOutRounding")
//  val tuplasRoundedDown : List[(String,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.portfolioPercent))
//  println(s"tuplasRoundedDown : $tuplasRoundedDown")
//
//  val sumatuplasRoundedDown = sum(tuplasRoundedDown)
//  println(s"sumatuplasRoundedDown : $sumatuplasRoundedDown")
//
//  var diff =  BigDecimal(100 - sum(tuplasRoundedDown)).setScale(1, BigDecimal.RoundingMode.HALF_UP).toFloat
//  println(s"diff : $diff")
//
//
//  val orderedDesc = tuplasWithOutRounding.sortWith( (x,y) => getDecimalPartWthPrecision(x._2) > getDecimalPartWthPrecision(y._2))
//  println(s"orderedDesc : $orderedDesc")
//
//
//  val ajustePerIter : Float = "0.1".toFloat
//
//  var numeroIteraciones : Int = (if(diff < 1 && diff>0) diff * 10 else diff ).toInt
//  println(s"numeroIteraciones : $numeroIteraciones")
//
//  val ajustedList = orderedDesc.map(x => {
//    if (numeroIteraciones > 0 ){
//      println(s"diff : $diff")
//      //diff -= ajustePerIter
//      numeroIteraciones -=1
//      x.copy(_2 = x._2 +  ajustePerIter)
//      val roundedTuple = tuplasRoundedDown.find( y => y._1 ==x._1 ).get
//      println(s"roundedTuple : $roundedTuple")
//      roundedTuple.copy(_2 = roundDown(roundedTuple._2 + ajustePerIter, 1))
//
//    }else {
//      tuplasRoundedDown.find( y => y._1 ==x._1 ).get
//    }
//  })
//
//  print(s"ajustedList = $ajustedList")
//
//  val sumAdjustedList = sum(ajustedList)
//  println(s"the sum of the adjusted list is : $sumAdjustedList")
//}

def run() : Unit =  {

  println(s"Starting from here")

  println(s"var : $tier1Allocations")

  val level2Data  = extractLevel2Data(tier1Allocations)

  println(s"calling  extractLevel2Data: $level2Data")

  val roundedValuesDown = level2Data.map(x => x.copy(portfolioPercent = roundDown(x.portfolioPercent,1)))

  println(s"roundedValuesDown : $roundedValuesDown")

  val tuplasWithOutRounding : List[(String,Double)] = level2Data.map(x => (x.assetClass,x.portfolioPercent))
  println(s"tuplasWithOutRounding : $tuplasWithOutRounding")
  val tuplasRoundedDown : List[(String,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.portfolioPercent))
  println(s"tuplasRoundedDown : $tuplasRoundedDown")

  println(s"sumatuplasRoundedDown : ${sum(tuplasRoundedDown)}")

  var diff =  BigDecimal(100 - sum(tuplasRoundedDown)).setScale(1, BigDecimal.RoundingMode.HALF_UP).toFloat
  println(s"diff : $diff")


  val orderedDesc = tuplasWithOutRounding.sortWith( (x,y) => getRestOfDecimalPart(x._2) > getRestOfDecimalPart(y._2))
  println(s"orderedDesc : $orderedDesc")


val ajustePerIter : Float = "0.1".toFloat

  var numeroIteraciones : Int = (if(diff < 1 && diff>0) diff * 10 else diff ).toInt
  println(s"numeroIteraciones : $numeroIteraciones")

  val ajustedList = orderedDesc.map(x => {
    if (numeroIteraciones > 0 ){
      numeroIteraciones -= 1
      val roundedTuple = tuplasRoundedDown.find( y => y._1 ==x._1 ).get
      roundedTuple.copy(_2 = roundDown(roundedTuple._2 + ajustePerIter, 1))
    }else {
      tuplasRoundedDown.find( y => y._1 ==x._1 ).get
    }
  })

  println(s"ajustedList = $ajustedList")

  val adjustedListFor = for ((e,i) <- orderedDesc.zipWithIndex) yield {
    println(s"i : $i - e: $e")
    if (i <  numeroIteraciones){
    val roundedTuple = tuplasRoundedDown.find( y => y._1 == e._1 ).get
    roundedTuple.copy(_2 = roundDown(roundedTuple._2 + ajustePerIter, 1))
  }else {
    tuplasRoundedDown.find( y => y._1 == e._1 )
  }}

  println(s"adjustedListFor = $adjustedListFor")

  val sumAdjustedList = sum(ajustedList)
  println(s"the sum of the adjusted list is : $sumAdjustedList")

  val assetsWithTier2Rounded = tier1Allocations.map(x => {
    x.copy(allocations = x.allocations.map( y => y.copy( portfolioPercent = ajustedList.find( p => p._1 == y.assetClass).get._2)))
//    x.allocations.map( y => y.copy( portfolioPercent = ajustedList.find( p => p._1 == y.assetClass).get._2))
  })
  println(s"assetsWithTier2Rounded : $assetsWithTier2Rounded")

  val assetsAllocationDataWithT1Rounded = recalculatePortfolioPercentsT1(assetsWithTier2Rounded)
  println(s"assetsAllocationDataWithT1Rounded : $assetsAllocationDataWithT1Rounded")




  // using for in order to use the index for quick access

}

//adjustToOneDecimal()
run()

/*getDecimalPartWthPrecision(4.729530454610485)
getDecimalPartWthPrecision(3.6727378764882648)
getDecimalPartWthPrecision(0.7045283854148139)
getDecimalPartWthPrecision(0.0)
getDecimalPartWthPrecision(1.5119386917411533) */

//
//getRestOfDecimalPart(4.729530454610485)
//getRestOfDecimalPart(3.6727378764882648)
//getRestOfDecimalPart(0.7045283854148139)
//getRestOfDecimalPart(0.0)
//getRestOfDecimalPart(1.5119386917411533)