package bc

import org.scalatest.FunSuite
import vm.VirtualMachine


class ByteCodeTests extends FunSuite with ByteCodeValues {

  val m = new MockVM(Vector(2, 4))

  test("iconst code") {
    val iconst = new Iconst(5)
    assert(iconst.code == bytecode("iconst"))
  }

  test("iadd code") {
    val iadd = new Iadd
    assert(iadd.code == bytecode("iadd"))
  }

  test("isub code") {
    val isub = new Isub
    assert(isub.code == bytecode("isub"))
  }

  test("imul code") {
    val imul = new Imul
    assert(imul.code == bytecode("imul"))
  }

  test("idiv code") {
    val idiv = new Idiv
    assert(idiv.code == bytecode("idiv"))
  }

  test("irem code") {
    val irem = new Irem
    assert(irem.code == bytecode("irem"))
  }

  test("ineg code") {
    val ineg = new Ineg
    assert(ineg.code == bytecode("ineg"))
  }

  test("iinc code") {
    val iinc = new Iinc
    assert(iinc.code == bytecode("iinc"))
  }

  test("idec code") {
    val idec = new Idec
    assert(idec.code == bytecode("idec"))
  }

  test("iswap code") {
    val iswap = new Iswap
    assert(iswap.code == bytecode("iswap"))
  }

  test("idup code") {
    val idup = new Idup
    assert(idup.code == bytecode("idup"))
  }

  test("print code") {
    val print = new Print
    assert(print.code == bytecode("print"))
  }

  test("iconst execute") {
    val vm = new Iconst(5).execute(m)
    assert(vm.state == Vector(2, 4, 5))
  }

  test("iadd execute") {
    val vm = new Iadd().execute(m)
    assert(vm.state == Vector(6))
  }

  test("isub execute") {
    val vm = new Isub().execute(m)
    assert(vm.state == Vector(2))
  }

  test("imul execute") {
    val vm = new Imul().execute(m)
    assert(vm.state == Vector(8))
  }

  test("idiv execute"){} // TODO
  test("idiv divide by 0"){} // TODO
  test("irem execute"){} // TODO
  test("irem div by 0"){} // TODO
  test("ineg execute") {}// TODO
  test("iinc execute") {}// TODO
  test("idec execute") {}// TODO
  test("iswap execute"){} // TODO
  test("idup execute") {}// TODO
  test("iprint execute") {}// TODO

}

class MockVM(stack: Vector[Int]) extends VirtualMachine {

  override def execute(bc: Vector[ByteCode]): VirtualMachine = ???

  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???

  override def push(value: Int): VirtualMachine = new MockVM(stack :+ value)

  override def pop(): (Int, VirtualMachine) = (stack.last, new MockVM(stack.init))

  override def state: Vector[Int] = stack
}
