package xu.barry.stu.jcth.juc.executors;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;
import xu.barry.stu.jcth.utils.SleepTools;

public class AsyncTask {

    /**
     * Unit test or TestNg will call exit(0);
     * So async/sub thread killed after main thread finished.
     */
    @Test
    public void async() {
        Printer.partition("print main line message");
        Runnable task = () -> handleBundle();
        Thread t = new Thread(task);
        t.setDaemon(true);
        t.start();

        for (int i = 3; i > 0; i--) {
            SleepTools.ms(1000);
            Printer.partition("print main line message");
        }
    }

    private void handleBundle() {
        for (int i = 10; i > 0; i--) {
            SleepTools.ms(1000);
            Printer.partition("print sub line message");
        }
    }

}
