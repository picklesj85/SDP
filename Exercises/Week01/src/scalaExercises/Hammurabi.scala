package scalaExercises

/**
  * Created by James Pickles on 15/01/2017.
  */
object Hammurabi {

  def main(args: Array[String]): Unit = {

    hammurabi()

  }

  def printIntroductoryMessage(): Unit = {
    println("""
    Congratulations, you are the newest ruler of ancient Samaria, elected
    for a ten year term of office. Your duties are to dispense food, direct
    farming, and buy and sell land as needed to support your people. Watch
    out for rat infestations and the plague! Grain is the general currency,
    measured in bushels. The following will help you in your decisions:

      * Each person needs at least 20 bushels of grain per year to survive.
      * Each person can farm at most 10 acres of land.
      * It takes 2 bushels of grain to farm an acre of land.
      * The market price for land fluctuates yearly.

    Rule wisely and you will be showered with appreciation at the end of
    your term. Rule poorly and you will be kicked out of office.""")
  }



  def hammurabi(): Unit = {

    var starved = 0 // how many people starved
    var immigrants = 5 // how many people came to the city
    var population = 100
    var harvest = 3000 // total bushels harvested
    var bushelsPerAcre = 3 // amount harvested for each acre planted
    var rats_ate = 200 // bushels destroyed by rats
    var bushelsInStorage = 2800
    var acresOwned = 1000
    var pricePerAcre = 19 // each acre costs this many bushels
    var plagueDeaths = 0
    var year = 1

    printIntroductoryMessage()

    for (year <- 1 to 10) {

      printf(
        """
          O great Hammurabi!
          You are in year %d of your ten year rule.
          In the previous year %d people starved to death.
          In the previous year %d people entered the kingdom.
          The population is now %d.
          We harvested %d bushels at %d bushels per acre.
          Rats destroyed %d bushels, leaving %d bushels in storage.
          The city owns %d acres of land.
          Land is currently worth %d bushels per acre.
          There were %d deaths from the plague.

        """, year, plagueDeaths, immigrants, population, harvest, bushelsPerAcre, rats_ate, bushelsInStorage,
        acresOwned, pricePerAcre, plagueDeaths)

      var acresToBuy = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      acresOwned = acresOwned + acresToBuy
      bushelsInStorage -= acresToBuy * pricePerAcre

      if (acresToBuy == 0) {
        var acresToSell = askHowMuchLandToSell(acresOwned)
        acresOwned = acresOwned - acresToSell
        bushelsInStorage += acresToSell * pricePerAcre

      }

      var grainToFeed = askHowMuchGrainToFeedThePeople(bushelsInStorage)
      bushelsInStorage -= grainToFeed
    }
  }

  //noinspection ScalaDeprecation
  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _: Throwable =>
        println("That’s not an integer. Please enter an integer.")
        readInt(message)
    }
  }

  def askHowMuchLandToBuy(bushels: Int, price: Int): Int = {
    var acresToBuy = readInt("How many acres will you buy? ")
    while (acresToBuy < 0 || acresToBuy * price > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      acresToBuy = readInt("How many acres will you buy? ")
    }
    acresToBuy
  }

  def askHowMuchLandToSell(acresOwned : Int): Int = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell < 0 || acresToSell > acresOwned) {
      println("O Great Hammurabi, we have but " + acresOwned + " acres of land!")
      acresToSell = readInt("How many acres will you sell?")
    }
    acresToSell
  }

  def askHowMuchGrainToFeedThePeople(bushels: Int): Int = {
    var grainToFeed = readInt("How much grain do you wish to feed the people with?")
    while (grainToFeed < 0 || grainToFeed > bushels) {
      println("O Great Hammurabi, we have but " + bushels + " bushels of grain!")
      grainToFeed = readInt("How much grain do you wish to feed the people with?")
    }
    grainToFeed
  }



}
