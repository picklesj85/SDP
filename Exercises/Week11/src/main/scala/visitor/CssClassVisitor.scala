package visitor

case class CssClassVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    element.setStartTag(element.getStartTag().dropRight(1) + " class=’visitor’>")
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    parentElement.setStartTag(parentElement.getStartTag().dropRight(1) + " class=’visitor’>")
  }
}
