import org.scalatest.{BeforeAndAfter, FunSuite}
import main.sml._

class AddInstructionTest extends FunSuite {
  val m = new Machine(new Labels, Vector())

  test("toString") {
    assert(AddInstruction("L1", 1, 2, 3).toString() == "L1: add 2 + 3 to 1")
  }

  test("execute 3 different registers") {
    m.regs(1) = 5
    m.regs(2) = 5
    val add = AddInstruction("L1", 3, 1, 2)
    add.execute(m)
    assert(m.regs(3) == 10)
  }

  test("execute with only one register") {
    m.regs(0) = 1
    val add = AddInstruction("L1", 0, 0, 0)
    add.execute(m)
    assert(m.regs(0) == 2)
  }
}
