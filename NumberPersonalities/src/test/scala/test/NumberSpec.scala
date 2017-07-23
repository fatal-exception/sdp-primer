package test
import org.scalatest.FlatSpec
import main.NumberPersonalities

class NumberSpec extends FlatSpec {
  "A Prime" should "return true from isPrime" in {
    val res: Boolean = NumberPersonalities.isPrime(2)
    assert(res)
  }

  "1" should "be happy" in {
    val res: Boolean = NumberPersonalities.isHappy(1)
    assert(res)
  }

  "19" should "be happy" in {
    val res: Boolean = NumberPersonalities.isHappy(19)
    assert(res)
  }

  "37" should "be unhappy" in {
    val res: Boolean = NumberPersonalities.isHappy(37)
    assert(! res)
  }

  "0" should "be unhappy" in {
    val res: Boolean = NumberPersonalities.isHappy(0)
    assert(! res)
  }

  "3" should "be triangular" in {
    val res: Boolean = NumberPersonalities.isTriangular(3)
    assert(res)
  }

  "4" should "not be triangular" in {
    val res: Boolean = NumberPersonalities.isTriangular(4)
    assert(! res)
  }

  "3" should "not be square" in {
    val res: Boolean = NumberPersonalities.isSquare(3)
    assert(! res)
  }

  "4" should "be square" in {
    val res: Boolean = NumberPersonalities.isSquare(4)
    assert(res)
  }

  "13" should "be smug" in {
    val res: Boolean = NumberPersonalities.isSmug(13)
    assert(res)
  }

  "12" should "not be smug" in {
    val res: Boolean = NumberPersonalities.isSmug(12)
    assert(! res)
  }

  /**
    * 5 / 2 makes 5 dishonest
    */
  "5" should "be dishonest" in {
    val res: Boolean = NumberPersonalities.isDishonest(5)
    assert(res)
  }

  "4" should "not be dishonest" in {
    val res: Boolean = NumberPersonalities.isDishonest(4)
    assert(! res)
  }

  "0" should "not be dishonest" in {
    val res: Boolean = NumberPersonalities.isDishonest(0)
    assert(! res)
  }

  "0" should "be honest" in {
    val res: Boolean = NumberPersonalities.isHonest(0)
    assert(res)
  }

  "6" should "be pronic" in {
    val res: Boolean = NumberPersonalities.isPronic(6)
    assert(res)
  }

  "7" should "not be pronic" in {
    val res: Boolean = NumberPersonalities.isPronic(7)
    assert(! res)
  }

  "Sum of positive Integers of 24" should "be 36" in {
    val res: Int = NumberPersonalities.sumOfPositiveDivisorsOf(24)
    assert(res == 36)
  }

  "24" should "be abundant" in {
    val res: Boolean = NumberPersonalities.isAbundant(24)
    assert(res)
  }

}
