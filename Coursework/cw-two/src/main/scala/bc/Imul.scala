package bc
import vm.VirtualMachine

class Imul extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("imul")

  override def execute(vm: VirtualMachine): VirtualMachine = {
    val a = vm.pop()
    val b = a._2.pop()
    b._2.push(a._1 * b._1)
  }
}

