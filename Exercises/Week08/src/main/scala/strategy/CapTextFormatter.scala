package strategy


case class CapTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = {
    val caps = text.toUpperCase()
    println("[CapTextFormatter]: " + caps)
  }
}
