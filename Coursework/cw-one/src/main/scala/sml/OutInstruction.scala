package main.sml

class OutInstruction(label: String, op: String, val reg: Int) extends Instruction(label, op) {

  private final val ZERO = 0
  private final val ONE = 1
  private final val TWO = 2

  def this(args: Array[String]) {
    this(args(ZERO), args(ONE), args(TWO).toInt)
  }

  def this(args: String) {
    this(args.split(" "))
  }

  override def execute(m: Machine) {
    println(m.regs(reg))
  }

  override def toString(): String = {
    super.toString() + " register " + reg + "\n"
  }
}

object OutInstruction {
  def apply(label: String, reg: Int) =
    new OutInstruction(label, "out", reg)
}
