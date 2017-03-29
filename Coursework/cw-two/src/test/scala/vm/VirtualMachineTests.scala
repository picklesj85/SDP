package vm

import org.scalatest.FunSuite
import bc._
import factory._

class VirtualMachineTests extends FunSuite {

  val vm = new VirtualMachineImpl(Vector(2, 4, 6))

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
    assert(vm1._2.state == Vector(1, 6))
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
    val vm1 = vm.executeOne(Vector(new Print))
    assert(vm1._2.state == Vector(4, 6))
  }

  test("ex one underflow") {
    intercept[MachineUnderflowException] {
      val vm1 = new VirtualMachineImpl(Vector())
      val vm2 = vm1.executeOne(Vector(new Print))
    }
  }

  test("ex one with factory") {} //TO DO



}
