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
    * It recursively executes each ByteCode command until there
    * are no more left (so the Vector is empty). It then returns
    * a Virtual Machine with an empty stack - assuming it is a
    * valid program.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */
  override def execute(bc: Vector[ByteCode]): VirtualMachine = bc match {
    case Seq() => this // no more ByteCode to execute
    case _     => val (nextVector, nextVM) = executeOne(bc)
                  nextVM.execute(nextVector)
  }

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
  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = (bc.tail, bc.head.execute(this))

  /**
    * Pushes an integer value onto the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */
  override def push(value: Int): VirtualMachine = new VirtualMachineImpl(value +: stack)

  /**
    * Pops an integer value off of the virtual machine stack.
    *
    * Throws a MachineUnderFlowException if the stack is empty
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */
  override def pop(): (Int, VirtualMachine) = {
    if (stack.isEmpty) throw new MachineUnderflowException("Stack is empty")
    (stack.head, new VirtualMachineImpl(stack.tail))
  }

  /**
    * Returns the state of the virtual machine stack.
    *
    * The value at index 0 is the value on the top of the stack.
    *
    * @return the state of the stack
    */
  override def state: Vector[Int] = stack


}
