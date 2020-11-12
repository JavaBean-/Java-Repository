package xu.barry.stu.practice.juc.alternate;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportAlternate {

    Thread ts = null;
    Thread tn = null;

    char[] s = "ABCDEFGHIJ".toCharArray();
    char[] n = "1234567890".toCharArray();

    @Test
    public void AlternatePrint() {
        ts = new Thread(() -> {
            for (int i = 0; i < s.length; i++) {
                LockSupport.park();
                System.out.println(s[i]);
                LockSupport.unpark(tn);
            }
        });
        tn = new Thread(() -> {
            for (int i = 0; i < n.length; i++) {
                System.out.println(n[i]);
                LockSupport.unpark(ts);
                LockSupport.park();
            }
        });
        ts.start();
        tn.start();
    }
}
