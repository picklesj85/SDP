package bc

import vm.VirtualMachine

class Idec extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("idec")

  override def execute(vm: VirtualMachine): VirtualMachine = vm.pop()._2.push(vm.pop()._1 - 1)
}