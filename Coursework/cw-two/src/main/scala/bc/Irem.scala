package bc
import vm.VirtualMachine

class Irem extends ByteCode with ByteCodeValues {

  val ZERO = 0
  override val code: Byte = bytecode("irem")

  /**
    * Executes the bytecode operation on the given
    * virtual machine.
    *
    * This throws an ArithmeticException when attempting to divide
    * by zero.
    *
    * @param vm the Virtual Machine to perform the operation on
    * @return the new Virtual Machine that is the result of the operation
    */
  override def execute(vm: VirtualMachine): VirtualMachine = {
    val a = vm.pop()
    val b = a._2.pop()
    if (b._1 == ZERO) {
      throw new ArithmeticException("Cannot divide by Zero")
    }
    b._2.push(a._1 % b._1)
  }
}
