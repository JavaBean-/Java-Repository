package xu.barry.stu.jcth.juc.executors;


import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;
import xu.barry.stu.jcth.utils.model.SleepTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cpu 密集型程序
 * 线程数量 = 机器cpu核心数+1
 * IO 密集型程序
 * 线程数量 = 机器cpu核心数*2
 *
 * 如果 混合型程序
 * 尽量分割任务为：cpu密集型 + IO密集型
 */
public class Executor {

    private static int i = 0;

    @Test
    public void singleExecutor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int n = 0 ; n < 10 ; n ++){

            /**
             *  Callable 入参接口
             *  会吞掉exception
             *  只有调用future可以获得结果
             */
            //executor.submit( ()-> {

            /**
             *  Runnable 入参接口
             *  打印出exception
             *  newSingleThreadExecutor线程池执行
             *  遇到抛出异常，会重新创建新线程继续执行后续任务
             */
            executor.execute(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Printer.println("Print Executor Output"+ (i++));
                if(i == 9 ){
                    throw new RuntimeException();
                }
            });
        }
        executor.shutdown();
        SleepTools.second(2);
    }



}
