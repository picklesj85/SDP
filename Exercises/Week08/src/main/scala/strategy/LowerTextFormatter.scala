package strategy

//TODO
case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = {
    val lower = text.toLowerCase
    println("[LowerTextFormatter]: " + lower)
  }
}
