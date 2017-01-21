public class FireSensor implements BatteryPoweredSensor {

  private String location;
  private double batteryPercentage;

  public FireSensor(String location) {
    this.location = location;
    batteryPercentage = 100;
  }

  @Override
  public boolean isTriggered() {
    batteryPercentage = batteryPercentage - 10;
    return (Math.random() < 0.05);
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public String getSensorType() {
    return this.getClass().getName();
  }

  @Override
  public double getBatteryPercentage() {
    return batteryPercentage;
  }
}
