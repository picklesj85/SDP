package main.sml

class BnzInstruction(label: String, op: String, val reg: Int, val next: String) extends Instruction(label, op) {

  def this(args: Array[String]) {
    this(args(0), args(1), args(2).toInt, args(3))
  }

  def this(args: String) {
    this(args.split(" "))
  }

  override def execute(m: Machine) {
    if (m.regs(reg) != 0) m.pc = m.labels.labels.indexOf(next)
  }

  override def toString(): String =
    super.toString() + " register " + reg + " instruction " + next +"\n"
}
object BnzInstruction {
  def apply(label: String, reg: Int, next: String) =
    new BnzInstruction(label, "bnz", reg, next)
}
