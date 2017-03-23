package bc
import vm.VirtualMachine


class Iconst(num: Int) extends ByteCode with ByteCodeValues {

  override val code: Byte = bytecode("iconst")

  override def execute(vm: VirtualMachine): VirtualMachine = vm.push(num)
}
