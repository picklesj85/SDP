package vm

import bc.{ByteCode, ByteCodeParser, ByteCodeValues}
import vendor.{Instruction, ProgramParser}

/** A VirtualMachineParser which links vendor.ProgramParser and bc.ByteCodeParser
  * implementations.  Allows for parsing of files and strings using a specified ProgramParser
  * (i.e. vendor specific implementations) and an adapter to convert into the bytecode
  * specific to the VM implementation.
  *
  * @param vp an instance of vendor.ProgramParserImpl
  * @param bcp
  */
class VirtualMachineParserImpl(vp: ProgramParser, bcp: ByteCodeParser) extends VirtualMachineParser with ByteCodeValues {

  /** An adapater for converting a vendor specific Vector of Instruction(s) to a
    * Vector of ByteCode(s)
    *
    * @param iv vector of Instructions to be converted
    * @return vector of ByteCodes for given Instructions
    */
  private def adapter(iv: Vector[Instruction]): Vector[ByteCode] = iv match {
      // Convert our vector of instructions to a vector of bytes and use a
      // ByteCodeParser to convert into the corresponding vector of ByteCodes.
      //
      // Instructions with no arguments are represented as Vector.empty[Int] by
      // VendorProgramParserImpl hence require no special handling here as
      // Vector(1) ++ Vector.empty[Int] == Vector(1)
      //
      case h +: t => bcp.parse(bytecode(h.name) +: h.args.map(_.toByte)) ++ adapter(t)
      case _ => Vector.empty[ByteCode]
  }

  /** Parse a program contained in a specified file returning the resultant vector of ByteCode(s)
    *
    * @param file to be read and parsed
    * @return vector of resultant ByteCode(s)
    * @throws bc.InvalidBytecodeException if file contains an unknown command or invalid arguemnt signature
    */
  def parse(file: String): Vector[ByteCode] = {
    try {
      adapter(vp.parse(file))
    } catch {
      case e: vendor.InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(e.getMessage)
    }
  }

  /** Parse a program contained in a string with each command separated by a newline returning the resultant
    * vector of ByteCode(s)
    *
    * @param str Program string to be parsed
    * @return vector of resultant ByteCode(s)
    * @throws bc.InvalidBytecodeException if file contains an unknown command or invalid arguemnt signature
    */
  def parseString(str: String): Vector[ByteCode] = {
    try {
      adapter(vp.parseString(str))
    } catch {
      case e: vendor.InvalidInstructionFormatException => throw new bc.InvalidBytecodeException(e.getMessage)
    }
  }

}
