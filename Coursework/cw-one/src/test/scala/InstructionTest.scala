import org.scalatest.FunSuite
import main.sml._

class InstructionTest extends FunSuite {
  val m = new Machine(new Labels, Vector())

  // test AddInstruction
  test("Add toString") {
    assert(AddInstruction("L1", 1, 2, 3).toString() == "L1: add 2 + 3 to 1\n")
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
    assert(SubInstruction("L1", 1, 2, 3).toString() == "L1: sub 2 - 3 to 1\n")
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
  
  // test MulInstruction
  test("mul toString") {
    assert(MulInstruction("L1", 1, 2, 3).toString() == "L1: mul 2 * 3 to 1\n")
  }

  test("mul execute 3 different registers") {
    m.regs(1) = 5
    m.regs(2) = 3
    val mul = MulInstruction("L1", 3, 1, 2)
    mul.execute(m)
    assert(m.regs(3) == 15)
  }

  test("mul execute with only one register") {
    m.regs(0) = 2
    val mul = MulInstruction("L1", 0, 0, 0)
    mul.execute(m)
    assert(m.regs(0) == 4)
  }

  // test DivInstruction
  test("div toString") {
    assert(DivInstruction("L1", 1, 2, 3).toString() == "L1: div 2 / 3 to 1\n")
  }

  test("div execute 3 different registers") {
    m.regs(1) = 15
    m.regs(2) = 3
    val div = DivInstruction("L1", 3, 1, 2)
    div.execute(m)
    assert(m.regs(3) == 5)
  }

  test("div execute with only one register") {
    m.regs(0) = 2
    val div = DivInstruction("L1", 0, 0, 0)
    div.execute(m)
    assert(m.regs(0) == 1)
  }
}
