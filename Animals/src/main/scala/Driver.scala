object Driver {
  def main(args: Array[String]): Unit = {
    val flare = new Flare
    val f1 = flare.light
    assert(f1 == "Flare used!", "Expected Flare used!, Got " + f1)

    val sailboat2 = new Sailboat
    val signal = sailboat2.signal()
    assert(signal == "Flare used!", "Expected Flare used! Got " + signal)
    val motorboat2 = new Motorboat
    val flare2 = motorboat2.signal()
    assert(flare2 == "Flare used!", "Expected Flare used!, Got " + flare2)
  }

}
