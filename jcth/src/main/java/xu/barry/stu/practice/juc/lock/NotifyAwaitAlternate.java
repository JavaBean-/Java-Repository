package xu.barry.stu.practice.juc.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class NotifyAwaitAlternate {
    private static CountDownLatch count = new CountDownLatch(1);
    char[] s = "ABCDEFGHIJ".toCharArray();
    char[] n = "1234567890".toCharArray();
    @Test
    public void AlternatePrint() {
       Thread ts = new Thread(() -> {
           try {
               count.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
            for (int i = 0; i < s.length; i++) {
                synchronized (this){
                    System.out.println(s[i]);
                    try {
                        this.notify();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread tn = new Thread(() -> {
            count.countDown();
            for (int i = 0; i < n.length; i++) {
                synchronized (this){
                    System.out.println(n[i]);
                    try {
                        this.notify();
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        ts.start();
        tn.start();
    }
}
