import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControlUnitTest {

    private ControlUnit cu;

    @Before
    public void setUp() {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new FireSensor("Kitchen"));
        sensors.add(new SmokeSensor("Bedroom"));
        cu = new ControlUnit(sensors);
    }
    @Test
    public void testPollHazardSensorsRepeatedly() {
        for (int i = 0; i < 100; i++) {
            cu.pollHazardSensors();
            System.out.println();
        }
    }

}
