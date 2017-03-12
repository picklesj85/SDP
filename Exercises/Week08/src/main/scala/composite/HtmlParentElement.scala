package composite

case class HtmlParentElement(s: String) extends HtmlTag(s) {
  var startTag = ""
  var endTag = ""

  override def setStartTag(tag: String): Unit = {
    startTag = tag
  }

  override def setEndTag(tag: String): Unit = {
    endTag = tag
  }

  override def generateHtml: Unit = {
    println(startTag)
    getChildren.forEach(child => child.generateHtml)
    println(endTag)
  }
}
