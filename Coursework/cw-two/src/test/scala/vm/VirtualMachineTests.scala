package vm

import org.scalatest.FunSuite
import bc._
import factory._
import vendor.InvalidInstructionFormatException

class VirtualMachineTests extends FunSuite {

  val vm = new VirtualMachineImpl(Vector(2, 4, 6))
  val vmp = VirtualMachineFactory.virtualMachineParser
  val testVM  = VirtualMachineFactory.virtualMachine


  test("state returns current stack") {
    assert(vm.state == Vector(2, 4, 6))
  }

  test("state returns empty stack") {
    val vm1 = new VirtualMachineImpl(Vector())
    assert(vm1.state.isEmpty)
  }

  test("Pop a few underflow exception") {
    intercept[MachineUnderflowException] {
      vm.pop()._2.pop()._2.pop()._2.pop()
    }
  }

  test("empty stack underflow exception") {
    intercept[MachineUnderflowException] {
      val vm1 = new VirtualMachineImpl(Vector())
      vm1.pop()
    }
  }

  test("pop one") {
    val vm1 = vm.pop()
    assert(vm1._1 == 2)
    assert(vm1._2.state == Vector(4, 6))
  }

  test("pop a few") {
    val vm1 = vm.pop()._2.pop()
    assert(vm1._1 == 4)
    assert(vm1._2.state == Vector(6))
  }

  test("push one on to stack") {
    val vm1 = vm.push(8)
    assert(vm1.state == Vector(8, 2, 4, 6))
  }

  test("push a few onto stack") {
    val vm1 = vm.push(1).push(2).push(3)
    assert(vm1.state == Vector(3, 2, 1, 2, 4, 6))
  }

  test("push and pop") {
    val vm1 = vm.pop()._2.push(3).push(4).pop()._2.push(7)
    assert(vm1.state == Vector(7, 3, 4, 6))
  }

  test("execute one iconst") {
    val vm1 = vm.executeOne(Vector(new Iconst(5)))
    assert(vm1._2.state == Vector(5, 2, 4, 6))
    assert(vm1._1.isEmpty)
  }

  test("ex one two iconst") {
    val vm1 = vm.executeOne(Vector(new Iconst(1), new Iconst(2)))
    assert(vm1._2.state == Vector(1, 2, 4, 6))
    assert(vm1._1.length == 1)
  }

  test("ex one iadd") {
    val vm1 = vm.executeOne(Vector(new Iadd))
    assert(vm1._2.state == Vector(6, 6))
  }

  test("ex one isub") {
    val vm1 = vm.executeOne(Vector(new Isub))
    assert(vm1._2.state == Vector(-2, 6))
  }


  test("ex one imul") {
    val vm1 = vm.executeOne(Vector(new Imul))
    assert(vm1._2.state == Vector(8, 6))
  }

  test("ex one idiv") {
    val vm1 = vm.executeOne(Vector(new Idiv))
    assert(vm1._2.state == Vector(0, 6))
  }

  test("ex one irem") {
    val vm1 = vm.push(5).executeOne(Vector(new Irem))
    assert(vm1._2.state == Vector(1, 4, 6))
  }

  test("ex one ineg") {
    val vm1 = vm.executeOne(Vector(new Ineg))
    assert(vm1._2.state == Vector(-2, 4, 6))
  }

  test("ex one iinc") {
    val vm1 = vm.executeOne(Vector(new Iinc))
    assert(vm1._2.state == Vector(3, 4, 6))
  }

  test("ex one idec") {
    val vm1 = vm.executeOne(Vector(new Idec))
    assert(vm1._2.state == Vector(1, 4, 6))
  }

  test("ex one iswap") {
    val vm1 = vm.executeOne(Vector(new Iswap))
    assert(vm1._2.state == Vector(4, 2, 6))
  }

  test("ex one idup") {
    val vm1 = vm.executeOne(Vector(new Idup))
    assert(vm1._2.state == Vector(2, 2, 4, 6))
  }

  test("ex one print") {
    print("This should be a 2: ")
    val vm1 = vm.executeOne(Vector(new Print))
    assert(vm1._2.state == Vector(4, 6))
  }

  test("ex one underflow") {
    intercept[MachineUnderflowException] {
      val vm1 = new VirtualMachineImpl(Vector())
      val vm2 = vm1.executeOne(Vector(new Print))
    }
  }

  test("ex one with factory") {
    val iconst = VirtualMachineFactory.byteCodeFactory.make(1, 5)
    val vm2 = vm.executeOne(Vector(iconst))
    assert(vm2._2.state == Vector(5, 2, 4, 6))
    assert(vm2._1.isEmpty)
  }

  test("ex one with factory using byteCodeParser") {
    val args = VirtualMachineFactory.byteCodeParser.parse(Vector(2, 1, 8, 3))
    val vm1 = vm.executeOne(args)
    assert(vm1._2.state == Vector(6, 6))
    assert(vm1._1.length == 2)
    assert(vm1._1.head.code == 1)
  }

  test("execute iconst") {
    val vm1 = vm.execute(Vector(new Iconst(1)))
    assert(vm1.state == Vector(1, 2, 4, 6))
  }

  test("execute isub") {
    val vm1 = vm.execute(Vector(new Isub))
    assert(vm1.state == Vector(-2, 6))
  }

  test("execute iadd") {
    val vm1 = vm.execute(Vector(new Iadd))
    assert(vm1.state == Vector(6, 6))
  }

  test("execute imul") {
    val vm1 = vm.execute(Vector(new Imul))
    assert(vm1.state == Vector(8, 6))
  }

  test("execute idiv") {
    val vm1 = vm.execute(Vector(new Idiv))
    assert(vm1.state == Vector(0, 6))
  }

  test("execute irem") {
    val vm1 = vm.push(7)execute(Vector(new Irem))
    assert(vm1.state == Vector(1, 4, 6))
  }

  test("execute ineg") {
    val vm1 = vm.execute(Vector(new Ineg))
    assert(vm1.state == Vector(-2, 4, 6))
  }

  test("execute iinc") {
    val vm1 = vm.execute(Vector(new Iinc))
    assert(vm1.state == Vector(3, 4, 6))
  }

  test("execute idec") {
    val vm1 = vm.execute(Vector(new Idec))
    assert(vm1.state == Vector(1, 4, 6))
  }

  test("execute iswap") {
    val vm1 = vm.execute(Vector(new Iswap))
    assert(vm1.state == Vector(4, 2, 6))
  }

  test("execute idup") {
    val vm1 = vm.execute(Vector(new Idup))
    assert(vm1.state == Vector(2, 2, 4, 6))
  }

  test("execute print") {
    print("This should be a 2: ")
    val vm1 = vm.execute(Vector(new Print))
    assert(vm1.state == Vector(4, 6))
  }

  test("divide by 0"){
    intercept[ArithmeticException] {
      val vm1 = vm.push(0).push(2)
      vm1.execute(Vector(new Idiv))
    }
  }

  test("irem divide by 0") {
    intercept[ArithmeticException] {
      val vm1 = vm.push(0).push(2)
      vm1.execute(Vector(new Irem))
    }
  }

  test("execute underflow") {
    intercept[MachineUnderflowException] {
      vm.execute(Vector(new Iadd, new Iadd, new Iadd))
    }
  }

  test("execute multiple iadd") {
    val args = VirtualMachineFactory.byteCodeParser.parse(Vector(2, 2, 12))
    print("This should be a 12: ")
    val vm1 = vm.execute(args)
    assert(vm1.state.isEmpty)
  }

  test("execute with every type of instruction") {
    val args = VirtualMachineFactory.byteCodeParser.parse(Vector(1, 1, 2, 3, 1, 2, 7, 4, 1,
                                                                 8, 5, 11, 9, 6, 8, 10, 6, 12))
    print("This should be a 0: ")
    val vm1 = vm.execute(args)
    assert(vm1.state.isEmpty)
  }

  test("made with factory") {
    val args = Vector(VirtualMachineFactory.byteCodeFactory.make(1, 1))
    val vm1 = VirtualMachineFactory.virtualMachine
    val (bc2, vm2) = vm1.executeOne(args)
    assert(vm2.state.head == 1)
  }

  test("iadd with factory") {
    val vm1 = VirtualMachineFactory.virtualMachine
    val args  = VirtualMachineFactory.byteCodeParser.parse(Vector(1, 1, 1, 2, 2))
    var next = vm1.executeOne(args)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 3)
  }

  test("isub with factory") {
    val vm1 = VirtualMachineFactory.virtualMachine
    val args  = VirtualMachineFactory.byteCodeParser.parse(Vector(1, 1, 1, 2, 3))
    var next = vm1.executeOne(args)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 1)
  }

  test("iswap with factory") {
    val vm1 = VirtualMachineFactory.virtualMachine
    val args  = VirtualMachineFactory.byteCodeParser.parse(Vector(1, 1, 1, 2, 11))
    var next = vm1.executeOne(args)
    assert(next._2.state.head == 1)
    next = next._2.executeOne(next._1)
    assert(next._2.state.head == 2)
    next = next._2.executeOne(next._1)
    assert(next._2.state(0) == 1)
    assert(next._2.state(1) == 2)
  }

  test("program 1") {
    val args = vmp.parse("programs/p01.vm")
    print("This should be a 9: ")
    val vm1 = testVM.execute(args)
    assert(vm1.state.isEmpty)
  }

  test("program 2") {
    intercept[MachineUnderflowException] {
      val args = vmp.parse("programs/p02-bad-stack.vm")
      testVM.execute(args)
    }
  }

  test("program 3") {
    intercept[ArithmeticException] {
      val args = vmp.parse("programs/p03.vm")
      testVM.execute(args)
    }
  }

  test("program 4") {
    intercept[InvalidBytecodeException] {
      val args = vmp.parse("programs/p04-bad-program.vm")
      testVM.execute(args)
    }
  }

  test("program 5") {
    val args = vmp.parse("programs/p05.vm")
    println("This should be a 21 and a 4:")
    val vm1 = testVM.execute(args)
    assert(vm1.state.isEmpty)
  }
}