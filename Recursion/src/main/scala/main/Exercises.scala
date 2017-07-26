package main
import org.apache.commons.math3.stat.Frequency

object Exercises {

  def max(ints: List[Int]): Int = {
    def max(ints: List[Int], maxSoFar: Int): Int = {
      if (ints == Nil) maxSoFar // end of list, return max
      else if (ints.head > maxSoFar) {
        max(ints.tail, ints.head)
      } else {
        max(ints.tail, maxSoFar)
      }
    }
    max(ints, 0)
  }

  def sumIt(toSum: List[Int], sum: Int = 0): Int =
    if (toSum.isEmpty)
      sum
    else
      sumIt(toSum.tail, sum + toSum.head)

  def sumItReduce(toSum: List[Int], sum: Int = 0): Int =
    toSum.reduce((x, y) => x + y)

  val f = new Frequency
  // add values for cat, dog, cat, bird,
  // cat, cat, kitten, mouse here
  for (_ <- 0 to 3) f.addValue("cat")
  assert(f.getCount("cat") == 4)

  def calcFreq(l: List[String], str: String, times: Int = 0): Int =  {
    if (l == Nil) times
    else if (l.head == str) calcFreq(l.tail, str, times +1 )
    else calcFreq(l.tail, str, times)
  }

  def main(args: Array[String]): Unit = {
    val aList = List(10, 20, 45, 15, 30)
    assert(max(aList) == 45)

    assert(sumIt(List(10, 20, 30, 40, 50)) == 150)

    assert(sumItReduce(List(1, 2, 3)) == 6)
    assert(sumItReduce(List(45, 45, 45, 60)) == 195)

    val animalList: List[String] = List("cat","cat","cat","dog","fish","cat")
    assert(calcFreq(animalList, "cat") == 4)
    assert(calcFreq(animalList, "dog") == 1)
  }

}
