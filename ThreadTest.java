import java.util.Calendar;
import java.lang.Thread;

public class ThreadTest extends Thread {
    public void run() {
        while (true) {
            Calendar cld = Calendar.getInstance();
            System.out.println(cld.getTime());
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) {

            }            
        }
    }

    public static void main(String[] args) {
        ThreadTest timeOutput = new ThreadTest();
        timeOutput.start();
    }
}