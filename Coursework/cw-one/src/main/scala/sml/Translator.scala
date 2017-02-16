package main.sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"
  private final val DIV = "div"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        val fullName = "main.sml." + fields(1).capitalize + "Instruction" //PLAY AROUND WITH PACKAGE NAME GET RID OF PREFIX
        try {
          val cl = Class.forName(fullName)
          val cons = cl.getConstructors()(0)
          val conargs = fields.map(x => if (x.matches("[0-9]+")) new java.lang.Integer(x) else x )
          for (elem <- conargs) {println(elem.getClass)}
          val ins = cons.newInstance(conargs:_*).asInstanceOf[Instruction]
          program = program :+ ins
        }
        catch {
          case ex: ClassNotFoundException => {
            ex.printStackTrace()
          }
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
