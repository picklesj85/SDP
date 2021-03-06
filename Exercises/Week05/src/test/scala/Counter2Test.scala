import Q1.{Adder, Counter2}
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class Counter2Test extends FunSuite with BeforeAndAfter {

  val testCounter2 = Counter2()

  test("count returns correct") {
    assert(testCounter2.count == 0)
  }

  test("inc by one") {
    assert(testCounter2.inc.count == 1)
  }

  test("dec by one") {
    assert(testCounter2.dec.count == -1)
  }

  test("multiple incs and decs by one") {
    assert(testCounter2.inc.dec.inc.inc.count == 2)
  }

  test("increment by 5") {
    assert(testCounter2.inc(5).count == 5)
  }

  test("decrement by 5") {
    assert(testCounter2.dec(5).count == -5)
  }

  test("adder applied to counter") {
    val adder = new Adder(10)
    assert(testCounter2.adjust(adder).count == 10)
  }

  test("more complicated adder and adjust") {
    val adder = new Adder(5)
    assert(testCounter2.inc(10).dec(4).adjust(adder).count == 11)
  }
}
