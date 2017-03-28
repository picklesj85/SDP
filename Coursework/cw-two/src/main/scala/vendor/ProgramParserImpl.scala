package vendor

class ProgramParserImpl extends ProgramParser {

  private val argInstructions = List("iconst")
  private val noargInstructions = List("iadd","isub","imul","idiv","irem","ineg","idec","idup","iswap","print")

  private def parseArgs(a: List[String]): Vector[Int] = a match {
    case Nil => Vector.empty[Int]
    case h :: t => try
    {
      h.toInt +: parseArgs(t)
    } catch {
      case e: NumberFormatException => throw new InvalidInstructionFormatException(s"Argument $h is not an integer")
    }
  }

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

  def parse(file: String): InstructionList = ???

  def parseString(string: String): InstructionList = ???

}
