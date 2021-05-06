package xu.barry.stu.jcth.juc.lock;

import org.junit.Test;
import xu.barry.stu.jcth.utils.SleepTools;

import java.util.concurrent.locks.Lock;

public  class SelfLockTest {

    public void test() {
        final Lock lock = new SelfLock();
        class Worker extends Thread {

            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName());
                try {
                    SleepTools.second(1);
                } finally {
                    lock.unlock();
                }
            }
        }
        // 启动4个子线程
        for (int i = 0; i < 4; i++) {
            Worker w = new Worker();
            //w.setDaemon(true);
            w.start();
        }
        // 主线程每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            //System.out.println();
        }
    }

    @Test
    public void main() {
        SelfLockTest testMyLock = new SelfLockTest();
        testMyLock.test();
    }
}
