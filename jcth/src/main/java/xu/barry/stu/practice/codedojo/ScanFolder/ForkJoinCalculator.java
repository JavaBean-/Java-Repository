package xu.barry.stu.practice.codedojo.ScanFolder;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculator {

    private ForkJoinPool pool;

    //执行任务RecursiveTask：有返回值  RecursiveAction：无返回值
    private static class SumTask extends RecursiveTask<Long> {

        private Path filePaths;
        private Long num;

        public SumTask(Path filePaths, Long num) {
            this.num = num;
            this.filePaths = filePaths;
        }

        //此方法为ForkJoin的核心方法：对任务进行拆分  拆分的好坏决定了效率的高低
        @Override
        protected Long compute() {
            File[] files = filePaths.toFile().listFiles();
            ArrayList<SumTask> taskList = new ArrayList<>(1000);

            for (File f : files) {
                if (f.isDirectory()) {
                    SumTask subTask = new SumTask(f.toPath(), 0L);
                    subTask.fork();
                    taskList.add(subTask);
                } else {
                    num++;
                }
            }

            for(SumTask t :taskList){
                num += t.join();
            }
            return num;
        }
    }


    @Test()
    public void sumUp() {
        pool = ForkJoinPool.commonPool();
        long start = System.currentTimeMillis();
        Long result = pool.invoke(new SumTask(Paths.get("C:\\New folder\\kibana-7.10.1-windows-x86_64\\kibana-7.10.1-windows-x86_64"), 0L));
        long end = System.currentTimeMillis();
        Printer.partition("file num:" + result + " "+ (end - start));
        pool.shutdown();
    }
}
