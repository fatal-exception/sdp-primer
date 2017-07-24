class Motorboat {
  def on = println("Motor on")
  def off = println("Motor off")
  def signal(): String = {
    new Flare().light()
  }

}
