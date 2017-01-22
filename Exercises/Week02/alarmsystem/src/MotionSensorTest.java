import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


/**
 * Created by James Pickles on 22/01/2017.
 */
public class MotionSensorTest {

    private MotionSensor sensor;

    @Before
    public void setUp() {

        sensor = new MotionSensor("Back Garden");
    }

    @Test
    public void isTriggered() {
        assertFalse(sensor.isTriggered());

    }

    @Test
    public void getLocation() {
        String location = sensor.getLocation();
        assertEquals("Back Garden", location);

    }

    @Test
    public void getSensorType() {
        String type = sensor.getSensorType();
        assertEquals("Security", type);

    }

}