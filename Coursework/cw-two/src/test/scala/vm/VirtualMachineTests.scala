package vm

import org.scalatest.FunSuite

class VirtualMachineTests extends FunSuite {

  val vm = new VirtualMachineImpl(Vector(2, 4, 6))

  test("state returns current stack") {
    assert(vm.state == Vector(2, 4, 6))
  }

  test("state returns empty stack") {
    val vm1 = new VirtualMachineImpl(Vector())
    assert(vm1.state == Vector())
  }

  test("Pop underflow exception") {
    intercept[MachineUnderflowException] {
      vm.pop()._2.pop()._2.pop()
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

}
