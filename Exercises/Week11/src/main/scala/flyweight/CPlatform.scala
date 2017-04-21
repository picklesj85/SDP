package flyweight

class CPlatform extends Platform {

  println("CPlatform object created")

  override def execute(code: Code): Unit =
    println("Compiling and executing C code.")
}
