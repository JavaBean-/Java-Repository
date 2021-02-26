package xu.barry.stu.jcth.juc.executors;

import org.testng.annotations.Test;
import xu.barry.stu.jcth.utils.model.SleepTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    private static int i = 0;

    @Test
    public void singleExecutor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int n = 0 ; n < 10 ; n ++){

            executor.submit( ()-> {


            //executor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Print Executor Output"+ (i++));
                if(i == 9 ){
                    throw new RuntimeException();
                }
            });
        }
        executor.shutdown();
        SleepTools.second(2);
    }
}
