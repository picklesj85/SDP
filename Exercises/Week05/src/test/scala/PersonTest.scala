import Q2._
import org.scalatest.FunSuite

class PersonTest extends FunSuite {

  test("create person with separate strings") {
    val p = new Person("John", "Doe")
    assert(p.getFirstName == "John" && p.getLastName == "Doe")
  }

  test("create person with one string") {
    val p = Person("John Doe")
    assert(p.getFirstName == "John" && p.getLastName == "Doe")
  }
}
