package main

object Exercise {
  val dogYears: Int => Int = i => 7 * i

  val between: (Int,Int,Int) => Boolean = (temp, low, high) => low < temp && temp < high

  val squareMe: Int => Int = i => i * i

  val pluralise: String => String = s => s +"s"

  def sumIt(is: Int*): Int = is.reduce((i, j) => i + j)

  def yielding(v: List[Int]): List[Int]={
    for {
      n <- v
      if n < 10
      isOdd = n % 2 != 0
      if isOdd
    } yield n
  }

  def yielding2(v: Vector[Int]): Vector[Int]={
    val result: Vector[Int] = for {
      n <- v
      if n < 10
      if n % 2 != 0
    } yield n*10 + 2
    return result
  }

  case class Activity(date: String, activity: String)

  def getDates(activity: String, as: Seq[Activity]): Vector[String] = {
    as.filter(a => a.activity == activity).map(a => a.date).toVector
  }

  def getActivities(date: String, as: Vector[Activity]) : Vector[String] = {
    as.filter(a => a.date == date).map(a => a.activity)
  }

  def main(args: Array[String]) {
    val v = Vector(1, 2, 3, 4)
    val str: String = v.map((i: Int) => i.toString + ",").
      foldLeft(new StringBuilder){ (s1, s2) => s1.append(s2)}.toString
    assert(str == "1,2,3,4,")

    assert(dogYears(10) == 70)

    var s = ""
    val v2 = Vector(1, 5, 7, 8)
    v2.foreach(i => s += dogYears(i) + " ")
    assert(s == "7 35 49 56 ")

    var s3 = ""
    val v3 = Vector(1, 5, 7, 8)
    v2.foreach(i => s3 += (i * 7) + " ")
    assert(s3 == "7 35 49 56 ")

    assert(between(70, 80, 90) == false)
    assert(between(70, 60, 90))

    var s4 = ""
    val numbers = Vector(1, 2, 5, 3, 7)
    numbers.foreach(i => s4 += squareMe(i) + " ")
    assert(s4 == "1 4 25 9 49 ")

    var s5 = ""
    val words = Vector("word", "cat", "animal")
    words.foreach(w => s5 += pluralise(w) + " ")
    assert(s5 == "words cats animals ")

    val v4 = Vector(1, 2, 3, 4)
    assert(v4.map(n => (n * 11) + 10) == Vector(21, 32, 43, 54))

    val v5 = for (i <- v4)
      yield (i * 11) + 10

    // uing reduce
    val v6 = Vector(1, 10, 100, 1000)
    assert(v6.reduce((sum, n) => sum + n) == 1111 )
    // using for loop
    var result = 0
    for (i <- v6) result += i
    assert(result == 1111)

    assert(sumIt(1, 2, 3) == 6)
    assert(sumIt(45, 45, 45, 60) == 195)

    val theList = List(1,2,3,5,6,7,8,10,13,14,17)
    assert(yielding(theList) == List(1,3,5,7))

    val v7 = Vector(1,2,3,5,6,7,8,10,13,14,17)
    assert(yielding2(v7) == Vector(12,32,52,72))

    val activities = Vector(
      Activity("01-01", "Run"),
      Activity("01-03", "Ski"),
      Activity("01-04", "Run"),
      Activity("01-10", "Ski"),
      Activity("01-03", "Run"))

    assert(getDates("Ski", activities) == Vector("01-03", "01-10"))
    assert(getDates("Run", activities) == Vector("01-01", "01-04", "01-03"))
    assert(getDates("Bike", activities) == Vector())

    assert(getActivities("01-01", activities) == Vector("Run"))
    assert(getActivities("01-02", activities) == Vector())
    assert(getActivities("01-03", activities) == Vector("Ski", "Run"))
    assert(getActivities("01-04", activities) == Vector("Run"))
    assert(getActivities("01-10", activities) == Vector("Ski"))
  }


}
