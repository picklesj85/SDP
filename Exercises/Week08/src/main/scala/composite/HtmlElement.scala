package composite


case class HtmlElement(s: String) extends HtmlTag(s) {

  var startTag = ""
  var endTag = ""

  override def setStartTag(tag: String): Unit = {
    startTag = tag
  }

  override def setEndTag(tag: String): Unit = {
    endTag = tag
  }

  override def generateHtml: Unit = {
    print(startTag)
    print(tagBody)
    println(endTag)
  }
}
