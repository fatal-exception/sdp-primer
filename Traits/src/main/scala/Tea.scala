class Tea(var describe: String = "",
          decaf: Boolean = false,
          sugar: Boolean = false,
          milk: Boolean = false,
          name: String = ""){

  describe = getDescription

  private def getDescription: String = {
    var result = ""
    if (describe == "" && name == "") result = "Earl Grey"
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
