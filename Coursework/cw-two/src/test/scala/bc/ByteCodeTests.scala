package bc

import org.scalatest.FunSuite
import vm.VirtualMachine


class ByteCodeTests extends FunSuite with ByteCodeValues {

  val m = new MockVM(Vector(2, 4))
  val bcf = new ByteCodeFactoryImpl

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

  test("idiv execute"){
    val vm = new Idiv().execute(m)
    assert(vm.state == Vector(2))
  }

  test("idiv divide by 0"){
    intercept[ArithmeticException] {
      val vm1 = m.push(0).push(5)
      val vm2 = new Idiv().execute(vm1)
    }
  }

  test("irem execute"){
    val vm1 = m.push(3).push(5)
    val vm2 = new Irem().execute(m)
    val vm3 = new Irem().execute(vm1)
    assert(vm2.state == Vector(0))
    assert(vm3.state == Vector(2, 4, 2))
  }

  test("irem div by 0"){
    intercept[ArithmeticException] {
      val vm1 = m.push(0).push(3)
      val vm2 = new Irem().execute(vm1)
    }
  }

  test("ineg execute") {
    val vm = new Ineg().execute(m)
    assert(vm.state == Vector(2, -4))
  }

  test("iinc execute") {
    val vm = new Iinc().execute(m)
    assert(vm.state == Vector(2, 5))
  }

  test("idec execute") {
    val vm = new Idec().execute(m)
    assert(vm.state == Vector(2, 3))
  }

  test("iswap execute"){
    val vm = new Iswap().execute(m)
    assert(vm.state == Vector(4, 2))
  }

  test("idup execute") {
    val vm = new Idup().execute(m)
    assert(vm.state == Vector(2, 4, 4))
  }

  test("iprint execute") {
    val vm = new Print().execute(m)
    assert(vm.state == Vector(2))
  }

  test("[5] all bytecodes should be made by factory") {
    // Tests that each bytecode (modulo "iconst") can be made.
    for ((name, code) <- (bytecode - "iconst")) {
      val bc = bcf.make(code)
      assert(bc.code == code, "invalid bytecode value")
    }

    // Test the iconst bytecode
    val bc = bcf.make(bytecode("iconst"), 4)
    assert(bc.code == bytecode("iconst"))
  }

  test("[3] an invalid bytecode should throw an exception") {
    intercept[InvalidBytecodeException] {
      bcf.make(99)
    }
  }
}



class MockVM(stack: Vector[Int]) extends VirtualMachine {

  override def execute(bc: Vector[ByteCode]): VirtualMachine = ???

  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???

  override def push(value: Int): VirtualMachine = new MockVM(stack :+ value)

  override def pop(): (Int, VirtualMachine) = (stack.last, new MockVM(stack.init))

  override def state: Vector[Int] = stack
}
