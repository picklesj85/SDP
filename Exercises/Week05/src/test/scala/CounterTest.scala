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

  test("multiple incs and decs by one") {
    assert(testCounter.inc.dec.inc.inc.count == 12)
  }

  test("increment by 5") {
    assert(testCounter.inc(5).count == 15)
  }

  test("decrement by 5") {
    assert(testCounter.dec(5).count == 5)
  }
}
