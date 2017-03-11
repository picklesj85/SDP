package abstractfactory

abstract class LondonXMLParser extends XMLParser {

  def parse(parserType: String): Unit = {
    println("London Parsing " + parserType + " XML...")
  }
}

class LondonErrorXMLParser extends LondonXMLParser {
  override def parse(): String = {
    super.parse("error")
    val msg = "London Error XML Message"
    msg
  }
}

class LondonFeedbackXMLParser extends LondonXMLParser {
  override def parse(): String = {
    super.parse("feedback")
    val msg = "London Feedback XML Message"
    msg
  }
}

class LondonOrderXMLParser extends LondonXMLParser {
  override def parse(): String = {
    super.parse("order")
    val msg = "London Order XML Message"
    msg
  }
}

class LondonResponseXMLParser extends LondonXMLParser {
  override def parse(): String = {
    super.parse("response")
    val msg = "London Response XML Message"
    msg
  }
}


