package bc

import vm.VirtualMachine

class Ineg extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("ineg")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.pop()._2.push(- vm.pop()._1)
}
