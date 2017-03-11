package abstractfactory

class NYCParserFactory extends AbstractParserFactory {

  override def getParserInstance(parserType: String): XMLParser = {
    parserType match {
      case "NYCERROR" => new NYCErrorXMLParser
      case "NYCFEEDBACK" => new NYCFeedbackXMLParser
      case "NYCORDER" => new NYCOrderXMLParser
      case "NYCRESPONSE" => new NYCResponseXMLParser
    }
  }
}



