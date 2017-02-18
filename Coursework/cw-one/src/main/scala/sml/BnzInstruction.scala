package main.sml

class BnzInstruction(label: String, op: String, val reg: Int, val next: String) extends Instruction(label, op) {

  private final val ZERO = 0
  private final val ONE = 1
  private final val TWO = 2
  private final val THREE = 3

  def this(args: Array[String]) {
    this(args(ZERO), args(ONE), args(TWO).toInt, args(THREE))
  }

  def this(args: String) {
    this(args.split(" "))
  }

  override def execute(m: Machine) {
    if (m.regs(reg) != 0) m.pc = m.labels.labels.indexOf(next)
  }

  override def toString(): String =
    super.toString() + " register " + reg + " instruction " + next + "\n"
}
object BnzInstruction {
  def apply(label: String, reg: Int, next: String) =
    new BnzInstruction(label, "bnz", reg, next)
}
