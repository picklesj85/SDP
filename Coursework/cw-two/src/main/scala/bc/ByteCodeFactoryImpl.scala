package bc

class ByteCodeFactoryImpl extends ByteCodeFactory {

  override def make(byte: Byte, args: Int*): ByteCode = byte match {
    case 1 => new Iconst(args.head)
    case 2 => new Iadd
    case 3 => new Isub
    case 4 => new Imul
    case 5 => new Idiv
    case 6 => new Irem
    case 7 => new Ineg
    case 8 => new Iinc
    case 9 => new Idec
    case 10 => new Idup
    case 11 => new Iswap
    case 12 => new Print
    case _ => throw new InvalidBytecodeException("Bytecode value unknown")
  }
}
