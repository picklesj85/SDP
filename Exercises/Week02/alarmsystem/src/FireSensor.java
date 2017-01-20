public class FireSensor implements Sensor {

  private String location;
  private double batteryPercentage;

  public FireSensor(String location) {
    this.location = location;
    //batteryPercentage = 100;
  }

  @Override
  public boolean isTriggered() {
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
    return -1;
  }
}
