package vm

import bc.{ByteCode, ByteCodeFactoryImpl, ByteCodeParserImpl, ByteCodeValues}
import vendor.{Instruction, ProgramParserImpl}

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {

  private val vp = new ProgramParserImpl()
  private val bcp = new ByteCodeParserImpl(ByteCodeFactoryImpl)

  private def adapter(iv: Vector[Instruction]): Vector[ByteCode] = iv match {
      // convert our vector of instructions to a vector of bytes and use a
      // ByteCodeParser to convert into a corresponding vector of ByteCodes
      case h +: t => bcp.parse(bytecode(h.name) +: h.args.map(_.toByte)) ++ adapter(t)
      case _ => Vector.empty[ByteCode]
  }

  def parse(file: String): Vector[ByteCode] = {
    adapter(vp.parse(file))
  }

  def parseString(str: String): Vector[ByteCode] = {
    adapter(vp.parseString(str))
  }

}
