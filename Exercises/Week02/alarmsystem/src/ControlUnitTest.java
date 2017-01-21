import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ControlUnitTest {

    @Test
    public void testPollSensors() {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new FireSensor("Kitchen"));
        sensors.add(new SmokeSensor("Bedroom"));
        ControlUnit cu = new ControlUnit(sensors);
        cu.pollSensors();
    }
}
