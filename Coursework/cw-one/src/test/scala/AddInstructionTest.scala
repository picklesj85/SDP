import org.scalatest.FunSuite
import main.sml._

class AddInstructionTest extends FunSuite{
  test("toString") {
    println(AddInstruction("L1", 1, 2, 3).toString())
  }
}
