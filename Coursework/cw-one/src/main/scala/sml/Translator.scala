package sml

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {

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
        try {
          val cl = Class.forName("sml." + fields(1).capitalize + "Instruction")
          val constructor = cl.getConstructors()(0)
          val labelAndOpcode = fields.take(2) // label and opcode will always be first two.
          // now for the operands check if they are a number in which case box as an Integer,
          // otherwise keep as a string. We don't know how many there will be so use drop.
          val operands = fields.drop(2).map(x => if (x.matches("[0-9]+")) new Integer(x) else x)
          val conArgs = labelAndOpcode ++ operands
          val ins = constructor.newInstance(conArgs:_*).asInstanceOf[Instruction]
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
