package bc

class ByteCodeParserImpl(bcf: ByteCodeFactoryImpl) extends ByteCodeParser {

  override def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    parseHelper(bc.toList, List()).toVector
  }

  def parseHelper(bytes: List[Byte], byteCodeObjects: List[ByteCode]): List[ByteCode] = bytes match {
    case h :: t if h == bytecode("iconst") => parseHelper(t.tail, byteCodeObjects :+ bcf.make(h, t.head))
    case h :: t => parseHelper(t, byteCodeObjects :+ bcf.make(h))
    case Nil => byteCodeObjects
  }
}
