package bc

import vm.VirtualMachine

class Idup extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("idup")

  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(vm.pop()._1)
}
