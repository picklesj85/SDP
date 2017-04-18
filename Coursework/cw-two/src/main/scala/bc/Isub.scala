package bc
import vm.VirtualMachine

class Isub extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("isub")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val a = vm.pop()
    val b = a._2.pop()
    b._2.push(a._1 - b._1)
  }

}
