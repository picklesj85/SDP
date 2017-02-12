package main.sml

class OutInstruction(label: String, op: String, reg: Int) extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(reg))
  }

  override def toString(): String = {
    super.toString() + " " + reg + "\n"
  }
}

object OutInstruction {
  def apply(label: String, reg: Int) =
    new OutInstruction(label, "out", reg)
}