package main.sml

case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  def this(args: Array[String]) {
    this(args(0), args(1), args(2).toInt, args(3).toInt)
  }

  def this(args: String) {
    this(args.split(" "))
  }

  override def execute(m: Machine): Unit =
    m.regs(register) = value

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int): LinInstruction =
    new LinInstruction(label, "lin", register, value)
}