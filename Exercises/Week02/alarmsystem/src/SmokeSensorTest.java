import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalseAroundNinetyPerCent() {
    SmokeSensor sensor = new SmokeSensor("Kitchen");
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
    assertTrue(falseCount >= 85 && falseCount <= 95);
  }

  @Test
  public void testThatGetLocationReturnsLocation() {
    SmokeSensor sensor = new SmokeSensor("Kitchen");
    String location = sensor.getLocation();
    assertEquals("Kitchen", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsType() {
    SmokeSensor sensor = new SmokeSensor("Kitchen");
    String sensorType = sensor.getSensorType();
    assertEquals("SmokeSensor", sensorType);
  }

  @Test
  public void testBatteryPercentageDrainsCorrectly() {
    SmokeSensor sensor = new SmokeSensor("Kitchen");
    double batteryDrain = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryDrain, 0.01);
    for (int i = 8; i >= 0; i -= 2) {
      sensor.isTriggered();
      batteryDrain = sensor.getBatteryPercentage();
      assertEquals((i * 10.0), batteryDrain, 0.01);
    }
  }
}
