object Animals {

  class Hippo {}
  class Lion {}
  class Tiger {}
  class Monkey {}
  class Giraffe {}

  class Zebra { println("I have stripes!") }

  def main(args: Array[String]) {
    val h = new Hippo
    val l = new Lion
    val l2 = new Lion
    val t = new Tiger
    val m = new Monkey
    val g = new Giraffe
    val g2 = new Giraffe
    val g3 = new Giraffe

    val z = new Zebra
  }
}