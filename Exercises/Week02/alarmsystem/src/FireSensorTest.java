import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalseAroundNinetyFivePerCentOfTheTime() {
    FireSensor sensor = new FireSensor("bedroom");
    int falseCount = 0;
    int trueCount = 0;
    for (int i = 0; i < 100; i++) {
      if (sensor.isTriggered()) {
        trueCount++;
      } else {
        falseCount++;
      }
    }
    System.out.printf("False: %d  True: %d\n", falseCount, trueCount);
    assertTrue(falseCount > 90 && falseCount < 100);
  }


  @Test
  public void testThatGetLocationReturnsLocation() {
    FireSensor sensor = new FireSensor("Bedroom");
    String location = sensor.getLocation();
    assertEquals("Bedroom", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsType() {
    FireSensor sensor = new FireSensor("Bedroom");
    String sensorType = sensor.getSensorType();
    System.out.println(sensorType);
    assertEquals("FireSensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor("Bedroom");
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage, 0.01);
  }
}
