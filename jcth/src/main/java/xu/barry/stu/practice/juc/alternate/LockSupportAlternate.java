package xu.barry.stu.practice.juc.alternate;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class LockSupportAlternate {

    private CountDownLatch waitingPrint = new CountDownLatch(2);
    private Thread ts = null;
    private Thread tn = null;
    private char[] s = "ABCDEFGHIJ".toCharArray();
    private char[] n = "1234567890".toCharArray();

    @Test
    public void AlternatePrint() throws InterruptedException {
        ts = new Thread(() -> {

            for (int i = 0; i < s.length; i++) {
                LockSupport.park();
                System.out.println(s[i]);
                LockSupport.unpark(tn);
            }
            waitingPrint.countDown();
        });

        tn = new Thread(() -> {

            for (int i = 0; i < n.length; i++) {
                System.out.println(n[i]);
                LockSupport.unpark(ts);
                LockSupport.park();
            }
            waitingPrint.countDown();
        });
        ts.start();
        tn.start();
        waitingPrint.await();
        Printer.println("Test case end!");
    }
}
