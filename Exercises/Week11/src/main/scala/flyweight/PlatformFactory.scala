package flyweight


object PlatformFactory {

  private var map = Map("JAVA" -> new JavaPlatform, "C" -> new CPlatform, "RUBY" -> new RubyPlatform,
                        "SCALA" -> new ScalaPlatform)

  def getPlatformInstance(platformType: String): Platform = {
    map(platformType)
  }

}
