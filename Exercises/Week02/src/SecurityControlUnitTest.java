import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by James Pickles on 23/01/2017.
 */
public class SecurityControlUnitTest {
    private SecurityControlUnit secConUnit;

    @Before
    public void setup() {
        List<Sensor> sensors = new ArrayList<>();
        sensors.add(new MotionSensor("Back Garden"));
        secConUnit = new SecurityControlUnit(sensors);
    }

    @Test
    public void pollSensors() {
        secConUnit.pollSensors();
    }

}