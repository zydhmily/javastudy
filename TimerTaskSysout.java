import java.util.TimerTask;
import java.util.Calendar;

public class TimerTaskSysout extends TimerTask {
    public void run() {
        Calendar cld = Calendar.getInstance();
        System.out.println(cld.getTime());
    }
}