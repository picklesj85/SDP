import xpay._
import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

class XpayToPayDAdapterTest extends FunSuite with BeforeAndAfter {
  val xpay = new XpayImpl
  val adapter = new XpayToPayDAdapter(xpay)
  before {
    xpay.setAmount(20.00)
    xpay.setCardCVVNo(583)
    xpay.setCardExpMonth("12")
    xpay.setCardExpYear("2020")
    xpay.setCreditCardNo("1234 1234 1234 1234")
    xpay.setCustomerName("Joe Bloggs")
  }

  test("get get amount") {
    assert(adapter.getTotalAmount == 20.00)
  }

  test("get cvv") {
    assert(adapter.getCVVNo == 583)
  }

  test("get exp date") {
    assert(adapter.getCardExpMonthDate == "12/2020")
  }

  test("get card number") {
    assert(adapter.getCustCardNo == "1234 1234 1234 1234")
  }

  test("get cust name") {
    assert(adapter.getCardOwnerName == "Joe Bloggs")
  }

  test("set amount") {
    adapter.setTotalAmount(50.00)
    assert(adapter.getTotalAmount == 50.00)
  }

  test("set cvv") {
    adapter.setCVVNo(444)
    assert(adapter.getCVVNo == 444)
  }

  test("set exp date") {
    adapter.setCardExpMonthDate("07/2019")
    assert(adapter.getCardExpMonthDate == "07/2019")
  }

  test("set card number") {
    adapter.setCustCardNo("4321 4321 4321 4321")
    assert(adapter.getCustCardNo == "4321 4321 4321 4321")
  }

  test("set cust name") {
    adapter.setCardOwnerName("John Doe")
    assert(adapter.getCardOwnerName == "John Doe")
  }
}
