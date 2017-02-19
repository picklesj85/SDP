package sml

class OutInstruction(label: String, op: String, val reg: Int) extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(reg))
  }

  override def toString(): String = {
    super.toString() + " register " + reg + "\n"
  }
}

object OutInstruction {
  def apply(label: String, reg: Int): OutInstruction =
    new OutInstruction(label, "out", reg)
}
