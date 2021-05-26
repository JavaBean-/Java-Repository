package xu.barry.stu.practice.threadpool;

import xu.barry.stu.jcth.utils.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * call method signature default throw exception
 */
public class FutureTest {

   static Callable<Integer> task = () -> {
        for(int i = 10 ; i > 0 ; i--){
            Printer.partition(Thread.currentThread()+",Sleep 1 seconds");
            TimeUnit.SECONDS.sleep(1);
        }
        return 10;
    };

    public static void main(String[] argv){

        List<Future<Integer>> futures = new ArrayList<>();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 5; i > 0; i--) {
            futures.add(pool.submit(task));
        }

        try {
            futures.get(0).get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("End this method");
    }
}
