import org.scalatest.{BeforeAndAfter, FunSuite}
import main.sml._

class InstructionTest extends FunSuite {
  val m = new Machine(new Labels, Vector())

  // test AddInstruction
  test("Add toString") {
    assert(AddInstruction("L1", 1, 2, 3).toString() == "L1: add 2 + 3 to 1")
  }

  test("add execute 3 different registers") {
    m.regs(1) = 5
    m.regs(2) = 5
    val add = AddInstruction("L1", 3, 1, 2)
    add.execute(m)
    assert(m.regs(3) == 10)
  }

  test("add execute with only one register") {
    m.regs(0) = 1
    val add = AddInstruction("L1", 0, 0, 0)
    add.execute(m)
    assert(m.regs(0) == 2)
  }

  // test SubInstruction
  test("Sub toString") {
    assert(SubInstruction("L1", 1, 2, 3).toString() == "L1: sub 2 - 3 to 1")
  }

  test("sub execute 3 different registers") {
    m.regs(1) = 5
    m.regs(2) = 3
    val sub = SubInstruction("L1", 3, 1, 2)
    sub.execute(m)
    assert(m.regs(3) == 2)
  }

  test("sub execute with only one register") {
    m.regs(0) = 1
    val sub = SubInstruction("L1", 0, 0, 0)
    sub.execute(m)
    assert(m.regs(0) == 0)
  }
}
