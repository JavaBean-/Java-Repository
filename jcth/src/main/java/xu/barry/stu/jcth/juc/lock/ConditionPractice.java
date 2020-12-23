package xu.barry.stu.jcth.juc.lock;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionPractice {

    char[] s = "ABCDEFGHIJ".toCharArray();
    char[] n = "1234567890".toCharArray();

    @Test
    public void AlternatePrint() throws InterruptedException {

        ReentrantLock rl = new ReentrantLock();
        CountDownLatch cd = new CountDownLatch(1);

        Condition sCondition = rl.newCondition();
        Condition nCondition = rl.newCondition();


        Thread ts = new Thread(() -> {

            try {
                cd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < s.length; i++) {
                try {
                    rl.lock();
                    System.out.println(s[i]);
                    nCondition.signal();
                    sCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rl.unlock();
                }
            }
        });

        Thread tn = new Thread(() -> {

            for (int i = 0; i < n.length; i++) {
                try {
                    rl.lock();
                    System.out.println(n[i]);
                    cd.countDown();
                    sCondition.signal();
                    nCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    rl.unlock();
                }
            }
        });
        ts.start();
        tn.start();
        Thread.sleep(1000);
    }

}
