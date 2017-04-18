package bc

import vm.VirtualMachine

class Idec extends ByteCode with ByteCodeValues {

  val ONE = 1
  override val code: Byte = bytecode("idec")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.pop()._2.push(vm.pop()._1 - ONE)
}