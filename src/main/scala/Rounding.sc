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

//val tier1Allocations = List(AssetAllocationTier1Data("T1_US_STOCKS",4.729530454610485,17082.70597659766,44.0,158924.6692,141841.96322340233,
//  List(AssetAllocationTier2Data("T2_US_LARGE_CAP",3.6727378764882648,13265.651183618362,24.0,73420.53201638164),
//    AssetAllocationTier2Data("T2_US_MID_CAP",0.7045283854148139,2544.703195319532,10.0,33574.53980468047),
//    AssetAllocationTier2Data("T2_US_SMALL_CAP",0.35226419270740694,1272.351597659766,4.0,13175.345602340234),
//    AssetAllocationTier2Data("T2_REAL_ESTATE",0.0,0.0,6.0,21671.5458))),
//  AssetAllocationTier1Data("T1_INTERNATIONAL_STOCKS",1.5119386917411533,5461.008100810081,21.0,75850.4103,70389.40219918992,
//    List(AssetAllocationTier2Data("T2_INTERNATIONAL_STOCKS",1.2851478879799803,4641.856885688569,14.0,45925.083314311436),
//      AssetAllocationTier2Data("T2_EMERGING_STOCKS",0.226790803761173,819.1512151215121,7.0,24464.31888487849))),
//  AssetAllocationTier1Data("T1_BONDS",7.711545633419391,27853.51906390639,35.0,126417.3505,98563.8314360936,
//    List(AssetAllocationTier2Data("T2_US_GOVERNMENT_BONDS",3.03023474853897,10944.978522952295,16.0,46845.810277047705),
//      AssetAllocationTier2Data("T2_US_CREDIT_BONDS",1.555275602670922,5617.537742484248,6.0,16054.008057515752),
//      AssetAllocationTier2Data("T2_US_MORTGAGE",2.082744916577429,7522.7169748874885,13.0,39432.29892511251),
//      AssetAllocationTier2Data("T2_INTERNATIONAL_BONDS",1.0432903656320702,3768.2858235823587,0.0,-3768.2858235823587))),
//  AssetAllocationTier1Data("T1_CASH",78.24316047743962,282608.37263726373,0.0,0.0,-282608.37263726373,
//    List(AssetAllocationTier2Data("T2_CASH_AND_EQUIVALENTS",78.24316047743962,282608.37263726373,0.0,-282608.37263726373))),
//  AssetAllocationTier1Data("T1_OTHER",7.803824742789361,28186.824221422143,0.0,0.0,-28186.824221422143,
//    List(AssetAllocationTier2Data("T2_COMMODITIES",7.760644374523575,28030.86,0.0,-28030.86),
//      AssetAllocationTier2Data("T2_OTHER",0.043180368265786244,155.9642214221422,0.0,-155.9642214221422))))

val tier1Allocations = List(
  AssetAllocationTier1Data("T1_US_STOCKS",4.557654111818794,16421.301143114313,44.0,158924.6692,142503.3680568857,
    List(AssetAllocationTier2Data("T2_US_LARGE_CAP",3.5345711611391404,12735.116800180018,24.0,73737.26959981996),
      AssetAllocationTier2Data("T2_US_MID_CAP",0.6820553004531018,2457.456228622863,10.0,33572.70477137714),
      AssetAllocationTier2Data("T2_US_SMALL_CAP",0.3410276502265509,1228.7281143114315,4.0,13183.336285688569),
      AssetAllocationTier2Data("T2_REAL_ESTATE",0.0,0.0,6.0,21618.096599999997))),
  AssetAllocationTier1Data("T1_INTERNATIONAL_STOCKS",1.4637107886788894,5273.773537353736,21.0,75850.4103,70576.63676264626,
    List(AssetAllocationTier2Data("T2_INTERNATIONAL_STOCKS",1.244154170377056,4482.707506750676,14.0,45959.51789324932),
      AssetAllocationTier2Data("T2_EMERGING_STOCKS",0.21955661830183343,791.0660306030604,7.0,24430.046669396936))),
  AssetAllocationTier1Data("T1_BONDS",7.721163312196263,27819.47572457246,35.0,126417.3505,98597.87477542754,
    List(AssetAllocationTier2Data("T2_US_GOVERNMENT_BONDS",3.033507600763289,10929.776725022502,16.0,46718.4808749775),
      AssetAllocationTier2Data("T2_US_CREDIT_BONDS",1.556223200857967,5607.097247884789,6.0,16010.999352115208),
      AssetAllocationTier2Data("T2_US_MORTGAGE",2.087127904322771,7519.955442034204,13.0,39319.25385796579),
      AssetAllocationTier2Data("T2_INTERNATIONAL_BONDS",1.044304606252235,3762.646309630963,0.0,-3762.646309630963))),
  AssetAllocationTier1Data("T1_CASH",78.43583677527054,282605.5827182718,0.0,0.0,-282605.5827182718,
    List(AssetAllocationTier2Data("T2_CASH_AND_EQUIVALENTS",78.43583677527054,282605.5827182718,0.0,-282605.5827182718))),
  AssetAllocationTier1Data("T1_OTHER",7.82163501203552,28181.47687668767,0.0,0.0,-28181.47687668767,
    List(AssetAllocationTier2Data("T2_COMMODITIES",7.779832013517786,28030.86,0.0,-28030.86),
      AssetAllocationTier2Data("T2_OTHER",0.041802998517733184,150.6168766876688,0.0,-150.6168766876688))))




  //    val allocationSummary = backtestAllocationSummary.allocationSummary
  def extractLevel2Data (assetAllocationsdata : List[AssetAllocationTier1Data]) : List[AssetAllocationTier2Data] = {
    assetAllocationsdata.flatMap(_.allocations)
  }

  def roundDown(decimal : Double, numberOfDecimals : Int) : Double =  {
    BigDecimal(decimal).setScale(numberOfDecimals, BigDecimal.RoundingMode.FLOOR).toDouble
  }

  def round(decimal : Double, numberOfDecimals : Int) : Double = {
    BigDecimal(decimal).setScale(numberOfDecimals, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

//  def sumTier2Values(xs: List[(AssetClassT2,Double)]): Double = {
//    def inner(xs: List[(AssetClassT2,Double)], accum: Double): Double = {
//      xs match {
//        case x :: tail => inner(tail, accum + x._2)
//        case Nil => accum
//      }
//    }
//    inner(xs, 0.0)
//  }
def sumTier2Values(xs: List[(String,Double)]): Double = {
  def inner(xs: List[(String,Double)], accum: Double): Double = {
    xs match {
      case x :: tail => inner(tail, accum + x._2)
      case Nil => accum
    }
  }
  inner(xs, 0.0)
}

  def getRestOfDecimalPart(number : Double) : Double = {
    val roundedDowNumber = roundDown(number,1)
    val decimal  = number - roundedDowNumber
    decimal
  }

//  def getSumPortFolioTier2(assetsTier2Data : List[AssetAllocationTier2Data]) : Double = {
//
//    def inner(xs: List[AssetAllocationTier2Data], accum: Double): Double = {
//      xs match {
//        case x :: tail => inner(tail, accum + x.portfolioPercent)
//        case Nil => accum
//      }
//    }
//    inner(assetsTier2Data, 0.0)
//  }
//
//  def getSumTargetTier2(assetsTier2Data : List[AssetAllocationTier2Data]) : Double = {
//
//    def inner(xs: List[AssetAllocationTier2Data], accum: Double): Double = {
//      xs match {
//        case x :: tail => inner(tail, accum + x.targetPercentage)
//        case Nil => accum
//      }
//    }
//    inner(assetsTier2Data, 0.0)
//  }

  val acumulatorTargetFun = (acc : Double, assetTier2Data : AssetAllocationTier2Data) => {acc + assetTier2Data.targetPercentage}
  val acumulatorPortfolioFun = (acc : Double, assetTier2Data : AssetAllocationTier2Data) => {acc + assetTier2Data.portfolioPercent}
  def getSum(assetsTier2Data : List[AssetAllocationTier2Data] , acumulatorFun : (Double, AssetAllocationTier2Data) => Double) = {

    def inner(xs: List[AssetAllocationTier2Data], accum: Double): Double = {
      xs match {
        case x :: tail => inner(tail, acumulatorFun(accum,x))
        case Nil => accum
      }
    }
    inner(assetsTier2Data, 0.0)
  }

//  def recalculatePortfolioPercentsT1( assetsData : List[AssetAllocationTier1Data]) : List[AssetAllocationTier1Data] = {
//    println(s"recalculatePortfolioPercentsT1 with : assetsData : $assetsData")
//    assetsData.map(tier1Data => {
//      println(s"getSumPortF2 : ${getSumPortFolioTier2(tier1Data.allocations)}")
//      tier1Data.copy(portfolioPercent = round(getSumPortFolioTier2(tier1Data.allocations),1) )
//    })
//  }
//
//  def recalculateTargetPercentsT1( assetsData : List[AssetAllocationTier1Data]) : List[AssetAllocationTier1Data] = {
//    assetsData.map(tier1Data => tier1Data.copy(targetPercentage = round(getSumTargetTier2(tier1Data.allocations),1) ))
//  }

  val funCalculateTargetsT1 = (tier1Data : AssetAllocationTier1Data) => { tier1Data.copy(portfolioPercent = round(getSum(tier1Data.allocations,acumulatorTargetFun),1) ) }
  val funCalculatePortfolioT1 = (tier1Data : AssetAllocationTier1Data) => { tier1Data.copy(targetPercentage = round(getSum(tier1Data.allocations,acumulatorPortfolioFun),1) ) }
  def recalculatePercents(assetsData : List[AssetAllocationTier1Data] , f : AssetAllocationTier1Data => AssetAllocationTier1Data) : List[AssetAllocationTier1Data] = {
    assetsData.map(tier1Data => f(tier1Data))
  }

  def roundPortfolioAllocations() : List[AssetAllocationTier1Data] = {
    //val tier1Allocations = backtestAllocationSummary.allocationSummary.tier1Allocations
    val level2Data  = extractLevel2Data(tier1Allocations)
    val roundedValuesDown = level2Data.map(x => x.copy(portfolioPercent = roundDown(x.portfolioPercent,1)))
//    val tuplasWithOutRounding : List[(AssetClassT2,Double)] = level2Data.map(x => (x.assetClass,x.portfolioPercent))
//    val tuplasRoundedDown : List[(AssetClassT2,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.portfolioPercent))
    val tuplasWithOutRounding : List[(String,Double)] = level2Data.map(x => (x.assetClass,x.portfolioPercent))
    val tuplasRoundedDown : List[(String,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.portfolioPercent))
    val tier2ValuesRoundedDownSum = sumTier2Values(tuplasRoundedDown)
    val totalErrorFromRounding =  BigDecimal(100 - tier2ValuesRoundedDownSum).setScale(1, BigDecimal.RoundingMode.HALF_UP).toFloat
    val orderedDesc = tuplasWithOutRounding.sortWith( (x,y) => getRestOfDecimalPart(x._2) > getRestOfDecimalPart(y._2)) //orderedDesc
    val ajustePerIter : Float = "0.1".toFloat
    val nIterations : Int = (if(totalErrorFromRounding < 1 && totalErrorFromRounding>0) totalErrorFromRounding * 10 else totalErrorFromRounding ).toInt

//  val ajustedList : List[(AssetClassT2,Double)] = for ((e,i) <- orderedDesc.zipWithIndex) yield {
    val ajustedList : List[(String,Double)] = for ((e,i) <- orderedDesc.zipWithIndex) yield {
      if (i <  nIterations){
        val maybeRoundedTuple = tuplasRoundedDown.find( y => y._1 == e._1 )
        maybeRoundedTuple match {
          case Some(roundedTuple) => roundedTuple.copy(_2 = roundDown(roundedTuple._2 + ajustePerIter, 1))
//          case _ => (AssetClassT2("NONE"),0.0)
          case _ => ("NONE",0.0)
        }

      }else {
//        tuplasRoundedDown.find( y => y._1 === e._1 ).getOrElse((AssetClassT2("NONE"),0.0))
        tuplasRoundedDown.find( y => y._1 == e._1 ).getOrElse(("NONE",0.0))
      }}

    val assetsWithTier2Rounded = tier1Allocations.map(x => {
      x.copy(allocations = x.allocations.map( y => y.copy( portfolioPercent = ajustedList.find( p => p._1 == y.assetClass).fold(("NONE",0.0)){x => x}._2)))
    })

    val assetsAllocationDataWithT1Rounded = recalculatePercents(assetsWithTier2Rounded,funCalculatePortfolioT1)
    assetsAllocationDataWithT1Rounded

  }

//def roundTargetPercentages(backtestAllocationSummary : BacktestAllocationSummary) : BacktestAllocationSummary  = {
def roundTargetPercentages( assets : List[AssetAllocationTier1Data]): List[AssetAllocationTier1Data]  = {
//  val tier1Allocations = backtestAllocationSummary.allocationSummary.tier1Allocations
  val level2Data  = extractLevel2Data(assets)
  val roundedValuesDown = level2Data.map(x => x.copy(targetPercentage = roundDown(x.targetPercentage,1)))
//  val tuplasWithOutRounding : List[(AssetClassT2,Double)] = level2Data.map(x => (x.assetClass,x.targetPercentage))
//  val tuplasRoundedDown : List[(AssetClassT2,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.targetPercentage))
  val tuplasWithOutRounding : List[(String,Double)] = level2Data.map(x => (x.assetClass,x.targetPercentage))
  val tuplasRoundedDown : List[(String,Double)] = roundedValuesDown.map( x => ( x.assetClass, x.targetPercentage))
  val tier2ValuesRoundedDownSum = sumTier2Values(tuplasRoundedDown)
  val totalErrorFromRounding =  BigDecimal(100 - tier2ValuesRoundedDownSum).setScale(1, BigDecimal.RoundingMode.HALF_UP).toFloat
  val orderedDesc = tuplasWithOutRounding.sortWith( (x,y) => getRestOfDecimalPart(x._2) > getRestOfDecimalPart(y._2)) //orderedDesc
  val ajustePerIter : Float = "0.1".toFloat
  val nIterations : Int = (if(totalErrorFromRounding < 1 && totalErrorFromRounding>0) totalErrorFromRounding * 10 else totalErrorFromRounding ).toInt

//  val ajustedList : List[(AssetClassT2,Double)] = for ((e,i) <- orderedDesc.zipWithIndex) yield {
    val ajustedList : List[(String,Double)] = for ((e,i) <- orderedDesc.zipWithIndex) yield {
    if (i <  nIterations){
      val maybeRoundedTuple = tuplasRoundedDown.find( y => y._1 == e._1 )
      maybeRoundedTuple match {
        case Some(roundedTuple) => roundedTuple.copy(_2 = roundDown(roundedTuple._2 + ajustePerIter, 1))
        case _ => ("NONE",0.0)
      }

    }else {
      tuplasRoundedDown.find( y => y._1 == e._1 ).getOrElse(("NONE",0.0))
    }}

  val assetsWithTier2Rounded = tier1Allocations.map(x => {
    x.copy(allocations = x.allocations.map( y => y.copy( targetPercentage = ajustedList.find( p => p._1 == y.assetClass).fold(("NONE",0.0)){x => x}._2)))
  })

  val assetsAllocationDataWithT1Rounded = recalculatePercents(assetsWithTier2Rounded,funCalculateTargetsT1)
  assetsAllocationDataWithT1Rounded
//  backtestAllocationSummary.copy( allocationSummary = backtestAllocationSummary.allocationSummary.copy(tier1Allocations = assetsAllocationDataWithT1Rounded))

}

  val rounded = roundPortfolioAllocations()
  println(s"rounded : $rounded")

println(s"roundedTargets : ${roundTargetPercentages(rounded)}")
  //backtestAllocationSummary.copy( allocationSummary = backtestAllocationSummary.allocationSummary.copy(tier1Allocations = roundPortfolioAllocations()))
