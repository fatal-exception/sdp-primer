class Tea2(var describe: String = "",
          val decaf: Boolean = false,
          val sugar: Boolean = false,
          val milk: Boolean = false,
          var name: String = ""){

  describe = getDescription

  private def getDescription: String = {
    var result = ""
    if (describe == "" && name == "") { result = "Earl Grey" ; name = result }
    else if (describe == "") result = name

    if (decaf) result += " decaf"
    if (milk) result += " + milk"
    if (sugar) result += " + sugar"
    result
  }

  def calories: Int = {
    var result = 0
    if (milk) result += 100
    if (sugar) result += 16
    result
  }
}

