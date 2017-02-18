package main.sml

class OutInstruction(label: String, op: String, val reg: Int) extends Instruction(label, op) {

  def this(args: Array[String]) {
    this(args(0), args(1), args(2).toInt)
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
  def apply(label: String, reg: Int): OutInstruction =
    new OutInstruction(label, "out", reg)
}
