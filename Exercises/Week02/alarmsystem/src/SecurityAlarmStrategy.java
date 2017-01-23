/**
 * Created by James Pickles on 23/01/2017.
 */
public class SecurityAlarmStrategy implements AlarmStrategy {

    @Override
    public void raiseAlarm() {
        System.out.println("The Police have been called and the owner has been notified");
    }
}
