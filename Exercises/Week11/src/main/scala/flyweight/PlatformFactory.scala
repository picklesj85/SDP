package flyweight

import java.util.{HashMap, Map}

object PlatformFactory {

  private var map: Map[String, Platform] = new HashMap[String, Platform]()

  def getPlatformInstance(platformType: String): Platform = platformType match {
    case "JAVA" => if (!map.containsKey("JAVA")) map.put("JAVA", new JavaPlatform)
                   map.get("JAVA")
    case "SCALA" => if (!map.containsKey("SCALA")) map.put("SCALA", new ScalaPlatform)
                    map.get("SCALA")
    case "C" => if (!map.containsKey("C")) map.put("C", new CPlatform)
                map.get("C")
    case "RUBY" => if (!map.containsKey("RUBY")) map.put("RUBY", new RubyPlatform)
                   map.get("RUBY")
  }
}
