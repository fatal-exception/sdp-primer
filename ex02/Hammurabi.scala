import scala.io.StdIn.readLine
import scala.util.Random
object Hammurabi {
  def hammurabi() = {

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

    printIntroductoryMessage()

    for (year <- 1 to 10) {
      println(
        s"""
          |O great Hammurabi!
          |You are in year $year of your ten year rule.
          |In the previous year 0 people starved to death.
          |In the previous year 5 people entered the kingdom.
          |The population is now 100.
          |We harvested 3000 bushels at 3 bushels per acre.
          |Rats destroyed 200 bushels, leaving 2800 bushels in storage.
          |The city owns 1000 acres of land.
          |Land is currently worth 19 bushels per acre.
          |There were 0 deaths from the plague.
        """.stripMargin)

      // buying or selling
      val landBought: Int = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      if (landBought == 0) {
        val landSold: Int = askHowMuchLandToSell(acresOwned)
        acresOwned -= landSold
        bushelsInStorage += landSold * pricePerAcre
      } else {
        acresOwned += landBought
        bushelsInStorage -= landBought * pricePerAcre
      }

      // feeding
      val amountToFeedThePeople: Int = askHowMuchGrainToFeedThePeople(bushelsInStorage)
      bushelsInStorage -= amountToFeedThePeople

      // seeding
      val acresPlantedWithSeed: Int = askHowManyAcresToPlantWithSeed(acresOwned)
      bushelsInStorage = bushelsInStorage + (acresPlantedWithSeed * bushelsPerAcre)
      population = checkPlague(population)
      val fedPopulation: Option[Int] = checkStarvation(population, amountToFeedThePeople)
      if (fedPopulation.isEmpty) throwOutOfOffice()
      else population = fedPopulation.get
    }
  }

  def throwOutOfOffice() = {
    println("Too many of the people starved. You have been thrown out of office!")
    System.exit(1)
  }

  def checkStarvation(population: Int, amountToFeedThePeople: Int): Option[Int] = {
    var howManyStarved = (population * 20) - amountToFeedThePeople
    howManyStarved = if (howManyStarved < 0) 0 else howManyStarved  // no negative numbers of starving people
    if ( howManyStarved.toDouble / population.toDouble >= 0.45) None
    else Option(population)
  }

  def checkPlague(population: Int): Int = {
    if (Random.nextInt(100 + 1) < 16) {
      println("Oh no! A horrible plague has hit your land. Your population has fallen from" +
      population + " to " + population / 2)
      return population / 2
    }
    else {
      println("No plague this year, well done glorious leader")
      return population
    }


  }

  def printIntroductoryMessage() = {
    println(
      """
  |Congratulations, you are the newest ruler of ancient Samaria, elected
  |for a ten year term of office. Your duties are to dispense food, direct
  |farming, and buy and sell land as needed to support your people. Watch
  |out for rat infestations and the plague! Grain is the general currency,
  |measured in bushels. The following will help you in your decisions:
  |  * Each person needs at least 20 bushels of grain per year to survive.
  |  * Each person can farm at most 10 acres of land.
  |  * It takes 2 bushels of grain to farm an acre of land.
  |  * The market price for land fluctuates yearly.
  |  Rule wisely and you will be showered with appreciation at the end of
  |your term. Rule poorly and you will be kicked out of office!
  """.stripMargin)
  }

  def readInt(message: String): Int = {
    try {
      readLine(message).toInt
    } catch {
      case _ : Throwable =>
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

  def askHowMuchLandToSell(acresOwned: Int) = {
    var acresToSell = readInt("How many acres will you sell? ")
    while (acresToSell < 0 || acresToSell > acresOwned) {
      println("O Great Hammurabi, a witty answer, but please enlighten us again!")
      acresToSell = readInt("How many acres will you sell? ")
    }
    acresToSell
  }

  def askHowMuchGrainToFeedThePeople(bushelsInStorage: Int) = {
    var grainToFeed = readInt("How much grain will you feed the people?")
    while (grainToFeed > bushelsInStorage) {
      println("O Great Hammurabi, by our own failings, we do not have that much grain!")
      grainToFeed = readInt("How many acres will you buy? ")
    }
    grainToFeed
  }

  def askHowManyAcresToPlantWithSeed(acresOwned: Int) = {
    var acresToSeed = readInt("How many acres will you plant with seed, O lord? ")
    while (acresToSeed > acresOwned) {
      println("O Great Hammurabi, we are in stitches - you know full well we do not own that much land!")
      acresToSeed = readInt("How many acres will you eplant with seed, O lord? ")
    }
    acresToSeed
  }
  def main(args: Array[String]) = {
    hammurabi()
  }
}
