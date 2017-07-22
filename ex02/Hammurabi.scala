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
      // TODO interpolate
      println(
        s"""
          |O great Hammurabi!
          |You are in year $year of your ten year rule.
          |In the previous year $starved people starved to death.
          |In the previous year $immigrants people entered the kingdom.
          |The population is now $population.
          |We harvested $harvest bushels at $bushelsPerAcre bushels per acre.
          |Rats destroyed $rats_ate bushels, leaving $bushelsInStorage bushels in storage.
          |The city owns $acresOwned acres of land.
          |Land is currently worth $pricePerAcre bushels per acre.
          |There were $plagueDeaths deaths from the plague.
        """.stripMargin)

      // buying or selling land
      val landBought: Int = askHowMuchLandToBuy(bushelsInStorage, pricePerAcre)
      if (landBought == 0) {
        val landSold: Int = askHowMuchLandToSell(acresOwned)
        acresOwned -= landSold
        bushelsInStorage += landSold * pricePerAcre
      } else {
        acresOwned += landBought
        bushelsInStorage -= (landBought * pricePerAcre)
      }

      // feeding
      val amountToFeedThePeople: Int = askHowMuchGrainToFeedThePeople(bushelsInStorage)
      bushelsInStorage -= amountToFeedThePeople

      // seeding
      val acresPlantedWithSeed: Int = askHowManyAcresToPlantWithSeed(acresOwned)
      println("-----")

      // plague
      population = checkPlague(population)

      // starvation
      val (fedPopulation: Option[Int], peopleStarved: Boolean) = checkStarvation(population, amountToFeedThePeople)
      if (fedPopulation.isEmpty) throwOutOfOffice()
      else population = fedPopulation.get

      // migration
      immigrants = checkMigration(population, peopleStarved, bushelsInStorage, acresOwned)
      population += immigrants

      // harvest
      bushelsPerAcre = checkCropYield()
      harvest = checkHarvest(acresPlantedWithSeed, bushelsPerAcre)
      bushelsInStorage += harvest

      // rats
      val (newBushelsInStorage: Int, new_rats_ate: Int) = checkRats(bushelsInStorage)
      bushelsInStorage = newBushelsInStorage
      rats_ate = new_rats_ate
      println("-----")

      // land price
      pricePerAcre = newLandPrice()
    }
  }

  /**
    * Land costs from 17 to 23 bushels per year at random
    * @return the cost of land for next year
    */
  def newLandPrice(): Int = {
    return Random.nextInt(8) + 17
  }

  def checkRats(bushelsInStorage: Int): (Int, Int) = {
    if (Random.nextInt(100) < 40) {
      println("Oh no! Your great kingdom has been plagued by rats...")
      val tenthsOfGrainEaten: Int = Random.nextInt(3) + 1
      val ratsAte:Int = (bushelsInStorage / 10) * tenthsOfGrainEaten
      (bushelsInStorage - ratsAte, ratsAte)
    }
    else {
      println("Well done your highness! No rats this year")
      (bushelsInStorage, 0)
    }
  }

  def checkCropYield(): Int = {
    return Random.nextInt(8) + 1
  }

  def checkHarvest(acresPlantedWithSeed: Int, cropYield: Int): Int = {
    acresPlantedWithSeed * cropYield
  }

  def checkMigration(population: Int, peopleStarved: Boolean, bushelsInStorage: Int, acresOwned: Int) = {
    if (peopleStarved) 0
    else (20 * acresOwned + bushelsInStorage) / (100 * population) + 1
  }

  def throwOutOfOffice() = {
    println("Too many of the people starved. You have been thrown out of office!")
    System.exit(1)
  }

  def checkStarvation(population: Int, amountToFeedThePeople: Int): (Option[Int], Boolean) = {
    var peopleStarved = false
    var howManyStarved = (population * 20) - amountToFeedThePeople

    if (howManyStarved <= 0) {
      howManyStarved = 0  // no negative numbers of starving people
      println("Nobody starved - just what we would expect with Hammurabi on the throne.")
    } else {
      peopleStarved = true
      println("Due to no fault of yours, wonderful ruler, sadly " + howManyStarved + " people starved.")
    }

    if ( howManyStarved.toDouble / population.toDouble >= 0.45) (None, peopleStarved)
    else (Option(population), peopleStarved)
  }

  def checkPlague(population: Int): Int = {
    if (Random.nextInt(100) < 15) {
      println("Oh no! A horrible plague has hit your land. Your population has fallen from " +
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
    var grainToFeed = readInt("How much grain will you feed the people? ")
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
      acresToSeed = readInt("How many acres will you plant with seed, O lord? ")
    }
    acresToSeed
  }
  def main(args: Array[String]) = {
    hammurabi()
  }
}
