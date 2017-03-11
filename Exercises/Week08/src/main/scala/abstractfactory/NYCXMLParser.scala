package abstractfactory

abstract class NYCXMLParser extends XMLParser {

  def parse(parserType: String): Unit = {
    println("NYC Parsing " + parserType + " XML...")
  }
}

class NYCErrorXMLParser extends NYCXMLParser {
  override def parse(): String = {
    super.parse("error")
    val msg = "NYC Error XML Message"
    msg
  }
}

class NYCFeedbackXMLParser extends NYCXMLParser {
  override def parse(): String = {
    super.parse("feedback")
    val msg = "NYC Feedback XML Message"
    msg
  }
}

class NYCOrderXMLParser extends NYCXMLParser {
  override def parse(): String = {
    super.parse("order")
    val msg = "NYC Order XML Message"
    msg
  }
}

class NYCResponseXMLParser extends NYCXMLParser {
  override def parse(): String = {
    super.parse("response")
    val msg = "NYC Response XML Message"
    msg
  }
}


