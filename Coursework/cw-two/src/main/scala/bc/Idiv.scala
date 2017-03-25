package bc

import vm.VirtualMachine

class Idiv extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("idiv")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    val a = vm.pop()
    val b = a._2.pop()
    if (b._1 == 0) {
      throw new ArithmeticException("Cannot divide by Zero")
    }
    b._2.push(a._1 / b._1)
  }
}