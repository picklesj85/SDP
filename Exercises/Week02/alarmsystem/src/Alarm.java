/**
 * Created by James Pickles on 23/01/2017.
 */
public class Alarm {

    private AlarmStrategy strategy;


    public Alarm(AlarmStrategy strategy) {
        this.strategy = strategy;
    }

    public void raiseAlarm() {
        strategy.raiseAlarm();
    }

}
