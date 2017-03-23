package bc

import vm.VirtualMachine

class Iswap extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("iswap")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    val a = vm.pop()
    val b = a._2.pop()
    b._2.push(a._1).push(b._1)
  }
}