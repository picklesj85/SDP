package visitor

case class HtmlElement(var tagName: String) extends HtmlTag {
  var startTag: String = ""
  var endTag: String = ""

  private var tagBody: String = ""

  override def setTagBody(tagBody: String): Unit = this.tagBody = tagBody
  override def generateHtml(): Unit = {
    println(startTag + tagBody + endTag)
  }
  override def accept(visitor: Visitor): Unit = visitor.visit(this)

  def getEndTag(): String = endTag
  def getStartTag(): String = startTag
  def getTagName(): String = tagName
  def setEndTag(tag: String): Unit = endTag = tag
  def setStartTag(tag: String): Unit = startTag = tag
}
