public class SmokeSensor implements BatteryPoweredSensor {

  private String location;
  private double batteryPercentage;

  public SmokeSensor(String location) {
    this.location = location;
    batteryPercentage = 100;
  }

  @Override
  public boolean isTriggered() {
    batteryPercentage -= 20;
    return (Math.random() < 0.1);
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
