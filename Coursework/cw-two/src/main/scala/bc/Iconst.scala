package bc
import vm.VirtualMachine


class Iconst(num: Int) extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("iconst")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(num)
}
