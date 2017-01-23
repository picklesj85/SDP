import java.time.LocalTime;
import java.util.List;

/**
 * Created by James Pickles on 23/01/2017.
 */
public class SecurityControlUnit extends ControlUnit {


    public SecurityControlUnit(List<Sensor> sensors) {
        super(sensors);
    }

    public void pollSensors() {
        LocalTime time = LocalTime.now();
        LocalTime start = LocalTime.of(22, 0);
        LocalTime end = LocalTime.of(6, 0);
        if (time.isAfter(start) || time.isBefore(end)) {
            super.pollSensors();
        }
    }


}
