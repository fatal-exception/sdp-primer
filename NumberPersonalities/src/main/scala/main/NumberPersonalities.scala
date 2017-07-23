package main
import scala.math.pow
import scala.collection.immutable.TreeMap

object NumberPersonalities {
  val limit = 100

  def printPersonalities(limit: Int) = {
    val personalities: Map[String, (Int => Boolean)] = TreeMap(
      "c" -> isComposite,
      "dis" -> isDishonest,
      "h" -> isHappy,
      "ht" -> isHonest,
      "per" -> isPerfect,
      "p" -> isPrime,
      "pr" -> isPronic,
      "sm" -> isSmug,
      "s" -> isSquare,
      "t" -> isTriangular,
      "u" -> isUnhappy,
    )
    for (n <- 0 to limit) {
      var line: String = n.toString
      for ((s, f) <- personalities) {
        if (f(n)) line = line + " " + s
      }
      println(line)
      }
  }

  def main(args: Array[String]) = {
    printPersonalities(limit)
  }

  def isPrime(n: Int): Boolean = ! ((2 until n-1) exists (n % _ == 0))
  def isComposite(n: Int): Boolean = ! isPrime(n)

  def isHappy(n: Int): Boolean = {
    var worker = n
    def happify(i: Int): Int = i.toString.map(_.asDigit).map(v => pow(v, 2)).sum.toInt
    val unhappyNumbers = List(4, 16, 37, 58, 89, 145, 42, 20, 0)
    while ((! unhappyNumbers.contains(worker)) && worker != 1) {
      worker = happify(worker)
    }
    worker == 1
  }

  def isUnhappy(n: Int): Boolean = ! isHappy(n)

  def isTriangular(n: Int): Boolean = {
    var worker = n
    var dec = 1
    while (worker > 0) {
      worker -= dec
      dec +=1
    }
    worker == 0
  }

  def isSquare(n: Int): Boolean = {
    var worker = n
    var dec = 1
    while (worker > 0) {
      worker -= dec
      dec +=2
    }
    worker == 0
  }

  def isSmug(n: Int): Boolean = {
    var squareRoot = 1
    var remainder = 2
    while (pow(squareRoot,2) < remainder) {
      remainder = n - pow(squareRoot, 2).toInt
      if (isSquare(remainder)) return true
      squareRoot += 1
    }
    false
  }

  def isDishonest(n: Int): Boolean = {
    var k = 1
    while ((k <= n) && (n / k) >= k) {
      if (n / k == k) {
        if (k * k != n) return true
      }
      k += 1
    }
    false
  }

  def isHonest(n: Int): Boolean = ! isDishonest(n)

  def isPronic(n: Int): Boolean = {
    var k = 1
    while (k <= n) {
      if ((k * (k+1)) == n) return true
      k += 1
    }
    false
  }

  def sumOfPositiveDivisorsOf(n: Int): Int = {
    var k = 1
    var counter = 0
    while (k <= n / 2) {
      if (n % k == 0) {
        counter += k
      }
      k += 1
    }
    counter
  }

  def isAbundant(n: Int): Boolean = sumOfPositiveDivisorsOf(n) > n
  def isPerfect(n: Int): Boolean = sumOfPositiveDivisorsOf(n) == n
  def isDeficient(n: Int): Boolean = sumOfPositiveDivisorsOf(n) < n

}
