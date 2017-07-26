object Driver {
  def main(args: Array[String]): Unit = {
    val doubleHalfCaf = new Coffee(shots=2, decaf=1)
    val tripleHalfCaf = new Coffee(shots=3, decaf=2)
    assert(doubleHalfCaf.decaf == 1)
    assert(doubleHalfCaf.caf == 1)
    assert(doubleHalfCaf.shots == 2)
    assert(tripleHalfCaf.decaf == 2)
    assert(tripleHalfCaf.caf == 1)
    assert(tripleHalfCaf.shots == 3)
  }

}
