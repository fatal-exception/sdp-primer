class Sailboat {
  def raise(): Unit = {
    println("Sails raised")
  }

  def lower(): Unit = {
    println("Sails lowered")
  }

  def signal(): String = {
    new Flare().light()
  }

}
