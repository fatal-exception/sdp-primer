package main

object NumberPersonalities {
  val limit = 100
  def main(args: Array[String]) = {

  }

  def isPrime(n: Int): Boolean = ! ((2 until n-1) exists (n % _ == 0))

}
