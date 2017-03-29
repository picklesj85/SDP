package bc

object ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {

  override def make(byte: Byte, args: Int*): ByteCode = {
    val reversedByteValues: Map[Byte, String] = bytecode.map(_.swap)
    if (reversedByteValues.contains(byte)) {
      val cl = Class.forName("bc." + reversedByteValues(byte).capitalize)
      val constructor = cl.getConstructors()(0)
      if (args.nonEmpty) {
        val conArgs = args.map(x => new Integer(x))
        constructor.newInstance(conArgs:_*).asInstanceOf[ByteCode]
      } else {
        constructor.newInstance().asInstanceOf[ByteCode]
      }
    } else {
      throw new InvalidBytecodeException("Bytecode value unknown")
    }
  }
}
