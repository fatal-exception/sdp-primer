package openingbid

import org.scalatest.FunSuite

class BidTest extends FunSuite {
  val hand = makeHand("5C	7H	AS	JD	9D	2C	KH	10H	4C	8H	8C	AD	10C")
  test("Testing	highCardPoints") {
    assertResult(12) {
      Bid.highCardPoints(hand)
    }
  }
  test("Testing	isBalanced") {
    assert(!Bid.isBalanced(hand))
  }
  Int.MinValue
}
