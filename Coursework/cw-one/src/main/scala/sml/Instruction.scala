package main.sml

abstract class Instruction(label: String, opcode: String) {

  override def toString(): String = label + ": " + opcode

  def execute(m: Machine, result: Int, op1: Int, op2: Int, f: (Int, Int) => Int) {
    val value1 = m.regs(op1)
    val value2 = m.regs(op2)
    m.regs(result) = f(value1, value2)
  }

  def execute(m: Machine): Unit
}