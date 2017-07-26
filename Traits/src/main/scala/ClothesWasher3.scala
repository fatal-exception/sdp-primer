class ClothesWasher3(val model: String = "", val capacity: Double = 0d) {
  def wash(): String = "Simple wash"
  def wash(bleach: Int, fabricSoftener: Int): String = s"Wash used $bleach bleach and $fabricSoftener fabric softener"
}

