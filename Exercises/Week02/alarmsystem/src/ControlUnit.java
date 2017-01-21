import java.util.List;

public class ControlUnit {

  private List<Sensor> sensors;

  public ControlUnit(List<Sensor> sensors) {
    this.sensors = sensors;
  }

  public void pollHazardSensors() {
    for (Sensor sensor : sensors) {
      if (sensor instanceof HazardSensor) {
        if (((HazardSensor)sensor).isHazardTriggered()) {
          System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
        } else {
          System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
        }
      }
    }
  }

  public void pollSecuritySensors() {
    for (Sensor sensor : sensors) {
      if (sensor instanceof SecuritySensor) {
        if (((SecuritySensor)sensor).isSecurityTriggered()) {
          System.out.println("A " + sensor.getSensorType() + " sensor was triggered at " + sensor.getLocation());
        } else {
          System.out.println("Polled " + sensor.getSensorType() + " at " + sensor.getLocation() + " successfully");
        }
      }
    }
  }
}
