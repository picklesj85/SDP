package bc

import vm.VirtualMachine

class Print extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("print")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    println(vm.pop()._1)
    vm.pop()._2
  }
}