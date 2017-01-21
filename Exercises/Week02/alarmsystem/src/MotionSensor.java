/**
 * Created by James Pickles on 21/01/2017.
 */
public class MotionSensor implements SecuritySensor {

    private String location;

    public MotionSensor(String location) {
        this.location = location;
    }

    @Override
    public boolean isSecurityTriggered() {
        return false;
    }

    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getSensorType() {
        return this.getClass().getName();
    }
}
