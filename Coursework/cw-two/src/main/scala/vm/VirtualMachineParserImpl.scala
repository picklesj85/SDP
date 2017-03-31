package vm

import bc.{ByteCode, ByteCodeFactoryImpl, ByteCodeParserImpl, ByteCodeValues}
import vendor.{Instruction, ProgramParserImpl}

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {

  private val vp = new ProgramParserImpl()
  private val bcp = new ByteCodeParserImpl(ByteCodeFactoryImpl)

  private def adapter(iv: Vector[Instruction]): Vector[ByteCode] = iv match {
      // Convert our vector of instructions to a vector of bytes and use a
      // ByteCodeParser to convert into the corresponding vector of ByteCodes.
      //
      // Instructions with no arguments are represented as Vector.empty[Int] by
      // VendorProgramParserImpl hence require no special handling here as
      // Vector(1) + Vector.empty[Int] == Vector(1)
      //
      case h +: t => bcp.parse(bytecode(h.name) +: h.args.map(_.toByte)) ++ adapter(t)
      case _ => Vector.empty[ByteCode]
  }

  def parse(file: String): Vector[ByteCode] = {
    try {
      adapter(vp.parse(file))
    } catch {
      case e: vendor.InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(e.getMessage)
    }
  }

  def parseString(str: String): Vector[ByteCode] = {
    try {
      adapter(vp.parseString(str))
    } catch {
      case e: vendor.InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(e.getMessage)
    }
  }

}
