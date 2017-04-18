package bc

class ByteCodeParserImpl(bcf: ByteCodeFactory) extends ByteCodeParser {

  /**
    * Parses a vector of `Byte` into a vector of `ByteCode`.
    *
    * @param bc a vector of bytes representing bytecodes
    * @return a vector of `ByteCode` objects
    */
  override def parse(bc: Vector[Byte]): Vector[ByteCode] = parseHelper(bc.toList, List()).toVector

  /**
    * This uses recursive pattern matching to turn a list of bytes
    * into a list of ByteCode. Each time it calls itself the list of bytes
    * reduces by one and the list of ByteCode increases by one. Once the list of
    * bytes is empty the full list of ByteCode is returned.
    *
    * Uses lists rather than vectors as they are easier to work with when pattern matching.
    *
    * @param bytes a list of bytes representing bytecodes
    * @param byteCodeObjects a list of ByteCode objects created so far
    * @return the list of ByteCode objects that have been created from the list of bytes
    */
  private def parseHelper(bytes: List[Byte], byteCodeObjects: List[ByteCode]): List[ByteCode] = bytes match {
    case h :: t if h == bytecode("iconst") => parseHelper(t.tail, byteCodeObjects :+ bcf.make(h, t.head))
    case h :: t => parseHelper(t, byteCodeObjects :+ bcf.make(h))
    case Nil => byteCodeObjects
  }
}
