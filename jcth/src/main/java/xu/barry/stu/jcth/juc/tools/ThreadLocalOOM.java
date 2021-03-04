package xu.barry.stu.jcth.juc.tools;

import xu.barry.stu.jcth.utils.Printer;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 类说明：ThreadLocal造成的内存泄漏演示
 * -Xms32m -Xmx32m
 */
public class ThreadLocalOOM {
    private static final int TASK_LOOP_SIZE = 20;

    private static AtomicInteger timesBegan = new AtomicInteger(0);
    private static AtomicInteger timesAfter = new AtomicInteger(0);

    final static ThreadPoolExecutor poolExecutor
            = new ThreadPoolExecutor(5, 5,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());

    static class LocalVariable {
        private final String msg;
        private byte[] a = new byte[1024 * 1024 * 5];/*5M大小的数组*/

        LocalVariable(String msg) {
            this.msg = msg;
        }

        String getMsg() {
            return msg;
        }
    }

    final static ThreadLocal<LocalVariable> threadLocalVariable
            = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        /*5*5=25*/
        for (int i = 0; i < TASK_LOOP_SIZE; ++i) {
            poolExecutor.execute(() -> {
                String threadName = Thread.currentThread().getName();
                System.out.println("use local varaible" + ",here times:" + timesBegan.addAndGet(1));
                threadLocalVariable.set(new LocalVariable(threadName));
                Printer.println(threadLocalVariable.get().getMsg() + ",finished times with:" + timesAfter.addAndGet(1));
                //直接申请的内存会被回收
                //new LocalVariable(threadName);
                //调用remove，避免内存泄漏
                threadLocalVariable.remove();
            });
            Thread.sleep(100);
        }
        Printer.println("pool execute over");
        poolExecutor.shutdown();
        poolExecutor.awaitTermination(100, TimeUnit.MICROSECONDS);
        Printer.println("Apply 25 M memory");
        ArrayList<LocalVariable> list = new ArrayList<>();
        for (int i = 4; i > 0; i--) {
            Printer.println("time:" + i + ",Apply 5 M memory");
            list.add(new LocalVariable("Apply 5 M memory"));
        }
        Printer.println("Example Over");
    }

}