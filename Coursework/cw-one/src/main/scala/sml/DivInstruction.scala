package main.sml

class DivInstruction(label: String, op: String, val result: Int, val op1: Int, val op2: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    super.execute(m, result, op1, op2, _ / _)
  }

  override def toString(): String = {
    super.toString() + " " + op1 + " / " + op2 + " to " + result + "\n"
  }
}

object DivInstruction {
  def apply(label: String, result: Int, op1: Int, op2: Int): DivInstruction =
    new DivInstruction(label, "div", result, op1, op2)
}
