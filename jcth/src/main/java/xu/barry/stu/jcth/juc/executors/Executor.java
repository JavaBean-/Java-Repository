package xu.barry.stu.jcth.juc.executors;


import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;
import xu.barry.stu.jcth.utils.SleepTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cpu 密集型程序
 * 线程数量 = 机器cpu核心数+1
 * IO 密集型程序
 * 线程数量 = 机器cpu核心数*2
 * Nthreads = NCPU * UCPU * ( 1 + W/C)
 * NCPU 物理核数
 * UCPU 利用率
 * W/C 等待时间与计算时间的比例
 *
 * 如果 混合型程序
 * 尽量分割任务为：cpu密集型 + IO密集型
 */
public class Executor {

    private static int i = 0;

    @Test
    public void singleExecutor(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor2 = Executors.newFixedThreadPool(2);

        /**
         *  1.核心线程数为零
         *  2.最大线程数为无限
         *  3.无任务时，线程存活的最大时间为60s
         *  4.任务队列为同步移交队列，该队列没有缓冲区，即不会有任务会在该队列中排队，
         *  每当有任务要入队时，队列都会将任务移交给一个可用的线程
         */
        ExecutorService executor3 = Executors.newCachedThreadPool();
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
