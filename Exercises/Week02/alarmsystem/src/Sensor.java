public interface Sensor {

  boolean isTriggered();

  String getLocation();

  default String getSensorType() {
    return "Hazard";
  }

}
