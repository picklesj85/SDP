package abstractfactory

class LondonParserFactory extends AbstractParserFactory {

  override def getParserInstance(parserType: String): XMLParser = {
    parserType match {
      case "LondonERROR" => new LondonErrorXMLParser
      case "LondonFEEDBACK" => new LondonFeedbackXMLParser
      case "LondonORDER" => new LondonOrderXMLParser
      case "LondonRESPONSE" => new LondonResponseXMLParser
    }
  }
}
