/**
 * Created by James Pickles on 23/01/2017.
 */
public class FireAlarmStrategy implements AlarmStrategy {


    @Override
    public void raiseAlarm() {
        System.out.println("The Fire Brigade have been called and the owner has been notified.");
    }
}
