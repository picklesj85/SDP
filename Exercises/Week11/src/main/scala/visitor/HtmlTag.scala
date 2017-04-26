package visitor

abstract class HtmlTag extends Element {
  def getTagName(): String
  def setStartTag(tag: String): Unit
  def getStartTag(): String
  def getEndTag(): String
  def setEndTag(tag: String): Unit

  def setTagBody(tagBody: String): Unit = println("Not Implemented")
  def addChildTag(htmlTag: HtmlTag): Unit = println("Not Implemented")
  def removeChildTag(htmlTag: HtmlTag): Unit = println("Not Implemented")
  def getChildren(): List[HtmlTag] = {println("Not Implemented"); List()}
  def generateHtml(): Unit
}
