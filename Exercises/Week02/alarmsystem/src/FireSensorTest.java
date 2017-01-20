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
    assertEquals("FireSensor", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageDrainsCorrectly() {
    FireSensor sensor = new FireSensor("Bedroom");
    double batteryDrain = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryDrain, 0.01);
    for (int i = 9; i >= 0; i--) {

      sensor.isTriggered();
      batteryDrain = sensor.getBatteryPercentage();
      assertEquals((i * 10.0), batteryDrain, 0.01);
    }
  }
}
