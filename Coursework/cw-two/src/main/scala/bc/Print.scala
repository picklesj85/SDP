package bc

import vm.VirtualMachine

class Print extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("print")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop()._1)
    vm.pop()._2
  }
}