package vm
import bc.ByteCode

class VirtualMachineImpl(stack: Vector[Int]) extends VirtualMachine {

  override def execute(bc: Vector[ByteCode]): VirtualMachine = bc.toList match {
    case Nil => this
    case _ => val (nextVector, nextVM) = executeOne(bc)
              nextVM.execute(nextVector)
  }

  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = (bc.tail, bc.head.execute(this))

  override def push(value: Int): VirtualMachine = new VirtualMachineImpl(value +: stack)

  override def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("Stack is empty")
    (stack.head, new VirtualMachineImpl(stack.tail))
  }

  override def state: Vector[Int] = stack


}
