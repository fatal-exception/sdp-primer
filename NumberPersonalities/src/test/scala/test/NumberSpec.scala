package test
import org.scalatest.FlatSpec
import main.NumberPersonalities

class NumberSpec extends FlatSpec {
  "A Prime" should "return true from isPrime" in {
    val res: Boolean = NumberPersonalities.isPrime(2)
    assert(res === true)
  }
}
