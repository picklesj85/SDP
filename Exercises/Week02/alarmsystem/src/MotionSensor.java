/**
 * Created by James Pickles on 21/01/2017.
 */
public class MotionSensor implements Sensor {

    private String location;

    public MotionSensor(String location) {
        this.location = location;
    }

    @Override
    public boolean isTriggered() {
        return false;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return "Security";
    }
}
