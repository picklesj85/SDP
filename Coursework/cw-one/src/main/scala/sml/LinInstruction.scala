package main.sml

case class LinInstruction(label: String, opcode: String, register: Int, value: Int) extends Instruction(label, opcode) {

  private final val ZERO = 0
  private final val ONE = 1
  private final val TWO = 2
  private final val THREE = 3

  def this(args: Array[String]) {
    this(args(ZERO), args(ONE), args(TWO).toInt, args(THREE).toInt)
  }

  def this(args: String) {
    this(args.split(" "))
  }

  override def execute(m: Machine) =
    m.regs(register) = value

  override def toString(): String = {
    super.toString + " register " + register + " value is " + value + "\n"
  }
}

object LinInstruction {
  def apply(label: String, register: Int, value: Int) =
    new LinInstruction(label, "lin", register, value)
}