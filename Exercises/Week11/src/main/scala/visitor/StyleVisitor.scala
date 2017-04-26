package visitor

case class StyleVisitor() extends Visitor {
  override def visit(element: HtmlElement): Unit = {
    element.setStartTag(element.getStartTag().dropRight(1) + " style=’width:46px;’>")
  }
  override def visit(parentElement: HtmlParentElement): Unit = {
    parentElement.setStartTag(parentElement.getStartTag().dropRight(1) + " style=’width:58px;’>")
  }
}
