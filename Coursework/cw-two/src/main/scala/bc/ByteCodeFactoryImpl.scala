package bc

object ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {

  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * The method uses reflection to determine which ByteCode object
    * to create in order to allow future additions of new ByteCode
    * objects.
    *
    * This method throws an [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    val reversedByteValues: Map[Byte, String] = bytecode.map(_.swap) // reverse the map to get the name from the value
    if (reversedByteValues.contains(byte)) {
      val cl = Class.forName("bc." + reversedByteValues(byte).capitalize) // future additions follow naming convention
      val constructor = cl.getConstructors()(0)
      if (args.nonEmpty) {
        // constructor takes an argument so box the Int as an Integer
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
