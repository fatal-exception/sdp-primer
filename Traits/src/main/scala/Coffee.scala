class Coffee(val shots: Int = 2,
             val decaf: Int = 0,
             val milk: Boolean = false,
             val toGo: Boolean = false,
             val syrup: String = "") {

  var result = ""
  println(shots, decaf, milk, toGo, syrup)

  def caf: Int = {
    shots - decaf
  }

  def getCup(): Unit = {
    if(toGo)
      result += "ToGoCup "
    else
      result += "HereCup "
  }

  def pourShots(): Unit = {
    for(s <- 0 until shots)
      if(decaf > 0)
        result += s"$decaf decaf shot(s) "
      else
        result += "shot "
  }

  def addMilk(): Unit = {
    if(milk)
      result += "milk "
  }

  def addSyrup(): Unit = {
    result += syrup
  }

  getCup()
  pourShots()
  addMilk()
  addSyrup()

}
