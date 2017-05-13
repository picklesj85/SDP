package vendor

import scala.io.Source

/** A parser for vendor programs which parses the contents of a file or newline
  * separated string into an InstructionList.
  */
class ProgramParserImpl extends ProgramParser {

  // Details of instructions that are and aren't expected to have arguments
  private val argInstructions = List("iconst")
  private val noargInstructions = List("iadd","isub","imul","idiv","irem","ineg","iinc","idec","idup","iswap","print")

  /** Returns a Vector of integers from a given List of strings
    *
    * @param a list of Strings containing arguments
    * @return returns a Vector of integers
    * @throws InvalidInstructionFormatException if an argument is not an integer
    */
  private def parseArgs(a: List[String]): Vector[Int] = a match {
    case Nil => Vector.empty[Int]
    case h :: t => try
    {
      h.toInt +: parseArgs(t)
    } catch {
      case e: NumberFormatException => throw new InvalidInstructionFormatException(s"Argument $h is not an integer")
    }
  }

  /** Parses a line of input splitting out the command and any arbitrary number of
    * arguemnts (by recursively calling parseArgs).
    *
    * @param s line of input to be parsed
    * @return Optionally returns an Instruction
    * @throws InvalidInstructionFormatException if arguments are present for an instruction that should have none
    * @throws InvalidInstructionFormatException if the command is not recognised
    */
  private def parseLine(s: String): Option[Instruction] = s.split("\\s+").toList match {
    case Nil => None
    case h :: t => {
      if (argInstructions contains h) {
        Some(new Instruction(h, parseArgs(t)))
      }
      else if (noargInstructions contains h) {
        if (t.isEmpty) {
          Some(new Instruction(h, Vector.empty[Int]))
        } else {
          throw new InvalidInstructionFormatException(s"Arguments not expected for command $h")
        }
      }
      else {
        throw new InvalidInstructionFormatException(s"Command $h not recognised")
      }
    }
  }

  /** Parses multiple lines (by recursively calling parseLine) and builds an InstructionList
    *
    * @param s list of Strings for the lines to be parsed
    * @return returns an InstructionList containing the Instructions parsed from the lines
    */
  private def parseLines(s: List[String]): InstructionList = s match {
    case Nil => Vector.empty[Instruction]
    case h :: t => Vector(parseLine(h).get) ++ parseLines(t)
  }

  /** Parse a given file
    *
    * @param file the file to parse
    * @return an instruction list
    */
  def parse(file: String): InstructionList = {
    parseLines(Source.fromFile(file).getLines().toList)
  }

  /** Parses a string containing a program to be parsed
    * with each command separated by a newline.
    *
    * @param string the string of commands to parse
    * @return an instruction list
    */
  def parseString(string: String): InstructionList = {
    parseLines(string.split("\\n").toList)
  }
}