package main.sml

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
        val fullName = "main.sml." + fields(1).capitalize + "Instruction"
        try {
          val cl = Class.forName(fullName)
          val cons = cl.getConstructor(classOf[String])
          val ins = cons.newInstance(line).asInstanceOf[Instruction]
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
