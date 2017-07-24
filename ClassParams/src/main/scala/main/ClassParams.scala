package main

object ClassParams {
  class Family(members: String*) {
    def familySize(): Int = members.length
  }

  class FlexibleFamily(mum: String, dad: String, kids: String*) {
    def familySize(): Int = kids.length + 2
  }

  class Cup(var percentFull: Int) {
    val max = 100
    def add(increase:Int):Int = {
      percentFull += increase
      if(percentFull > max) {
        percentFull = max
      }
      percentFull // Return this value
    }
  }

  class Cup5(var percentFull: Int) {
    val max = 100
    def increase(amounts: Int*):Int = {
      for (i <- amounts) {
        percentFull += i
        percentFull = if (percentFull > 100) 100 else if (percentFull < 0) 0 else percentFull
      }
      percentFull
    }
  }

  def squareThem(ns: Int*): Int = {
    ns.map(n => n * n).sum
  }

  class SimpleTime(val hours: Int, val minutes: Int)

  class SimpleTime2(val hours: Int, val minutes: Int) {
    def this(hours: Int) {
      this(hours, 0)
    }
  }

  def main(args: Array[String]) {
    val family1 = new Family("Mom", "Dad", "Sally", "Dick")
    assert(family1.familySize() == 4)
    val family2 = new Family("Dad", "Mom", "Harry")
    assert(family2.familySize() == 3)

    val family3 = new FlexibleFamily("Mom", "Dad", "Sally", "Dick")
    assert(family3.familySize() == 4)
    val family4 = new FlexibleFamily("Dad", "Mom", "Harry")
    assert(family4.familySize() == 3)

    val familyNoKids = new FlexibleFamily("Mom", "Dad")
    assert(familyNoKids.familySize() == 2)

    val cup5 = new Cup5(0)
    assert(cup5.increase(20, 30, 50, 20, 10, -10, -40, 10, 50) == 100)
    assert(cup5.increase(10, 10, -10, 10, 90, 70, -70) == 30)

    assert(squareThem(2) == 4)
    assert(squareThem(2, 4) == 20)
    assert(squareThem(1, 2, 4) == 21 )

    val t = new SimpleTime(hours=5, minutes=30)
    assert(t.hours == 5)
    assert(t.minutes == 30)

    val t2 = new SimpleTime2(hours=10)
    assert(t2.hours == 10)
    assert(t2.minutes == 0)
  }
}
