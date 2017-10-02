import java.util.Timer;

public class TimeOutput {
    public static void main(String[] args) {
        Timer time = new Timer();
        time.schedule(new TimerTaskSysout(),0,1000);
    }
}