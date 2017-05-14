package sml

abstract class Instruction(label: String, opcode: String) {

  override def toString(): String = label + ": " + opcode

  def execute(m: Machine, result: Int, op1: Int, op2: Int, f: (Int, Int) => Int) {
    m.regs(result) = f(m.regs(op1), m.regs(op2))
  }

  def execute(m: Machine): Unit
}