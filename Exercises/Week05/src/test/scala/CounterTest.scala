import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class CounterTest extends FunSuite with BeforeAndAfter {

  val testCounter = new Counter(10)

  test("count returns correct") {
    assert(testCounter.count == 10)
  }

  test("inc by one") {
    assert(testCounter.inc.count == 11)
  }

  test("dec by one") {
    assert(testCounter.dec.count == 9)
  }
}
