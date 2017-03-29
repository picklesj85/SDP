package vm
import bc.ByteCode

class VirtualMachineImpl(stack: Vector[Int]) extends VirtualMachine {
  /**
    * Executes a vector of bytecodes.
    *
    * Note, that this is an "immutable" object. That is, it
    * will return a new virtual machine after executing each
    * of the bytecode objects in the vector.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = ???

  /**
    * Executes the next bytecode in the vector of bytecodes.
    *
    * This method only executes a single byte code in the vector of bytecodes.
    * It returns a tuple of the new vector of bytecodes (with the executed
    * bytecode removed) and the new virtual machine.
    *
    * You may assume that `bc` contains at least 1 bytecode.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???


  override def push(value: Int): VirtualMachine = new VirtualMachineImpl(value +: stack)


  override def pop(): (Int, VirtualMachine) = {

    if (stack.isEmpty) throw new MachineUnderflowException("Stack is empty")

    (stack.head, new VirtualMachineImpl(stack.tail))
  }


  override def state: Vector[Int] = stack


}
