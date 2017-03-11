package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String) = {
    s match {
      case "NYCFactory" => new NYCParserFactory
      case "LondonFactory" => new LondonParserFactory
    }
  }

  // TODO

}
