package xu.barry.stu.practice.codedojo.ScanFolder;

import java.io.File;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPool {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long start = System.currentTimeMillis();
        File directory = new File("C:\\New folder\\kibana-7.10.1-windows-x86_64\\kibana-7.10.1-windows-x86_64");
        ExecutorService pool = Executors.newCachedThreadPool();
        CopyOnWriteArrayList l = new CopyOnWriteArrayList();
        Future<Integer> future = pool.submit(new PoolMatchCounter(directory,l, pool));

        try {
            System.out.println(future.get() + " files match");
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        pool.shutdown();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) pool;
        long end = System.currentTimeMillis();
        System.out.println("Largest Pool Size: " + executor.getLargestPoolSize() + " " + (end - start));
    }
    static class PoolMatchCounter implements Callable<Integer> {
        private File directory;
        private ExecutorService pool;
        List<Future<Integer>> result;
        public PoolMatchCounter(File directory,List<Future<Integer>> result,  ExecutorService pool) {
            super();
            this.directory = directory;
            this.pool = pool;
            this.result = result;
        }
        @Override
        public Integer call() throws Exception {
            // TODO Auto-generated method stub
            File[] files = directory.listFiles();
            int count = 0;
            for (File f : files) {
                if (f.isDirectory()) {
                    Future<Integer> future = pool.submit(new PoolMatchCounter(f,result, pool));
                    result.add(future);
                } else {
                    ++count;
                }
            }
            return count;
        }
    }
}
