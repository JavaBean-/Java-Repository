package xu.barry.stu.jcth.juc.executors;

import xu.barry.stu.jcth.utils.model.SleepTools;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableServiceExample {

    public static void main(String[] args) throws Exception, InterruptedException {

//      test1();

      test2();

//        test3();
    }


    //这种方式提交的任务，有可能任务A是第一个执行完的，但是返回的顺序却不是第一个
    public static void test1() throws Exception, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable> task = IntStream.range(0, 5).boxed().map(CompletableServiceExample::toTask).collect(Collectors.toList());
        List<Future<String>> futures = new ArrayList<>();
        task.forEach(r -> futures.add(executorService.submit(r)));

        System.out.println(futures.get(4).get());
        System.out.println("======4======");

        System.out.println(futures.get(3).get());
        System.out.println("======3======");
    }

    //这种方式可以保证假如任务A是第一个执行完的，那么他也是第一个返回的
    public static void test2() throws Exception, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Callable> task = IntStream.range(0, 5).boxed().map(CompletableServiceExample::toTask).collect(Collectors.toList());
        CompletionService completionService = new ExecutorCompletionService(executorService);
        task.forEach(r -> completionService.submit(r));
        Future<?> future = null;
        while ((future = completionService.take()) != null) {
            System.out.println(future.get());
        }

    }

    //由于调用线程池的shutdownNow方法，可能正在执行的任务被中断后，任务的状态丢失。该任务不包含在shutdownNow的返回值中
    //解决的办法是在任务里定义一个状态，表示是否完成
    public static void test3() throws Exception, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<Callable> task = IntStream.range(0, 5).boxed().map(MyTask::new).collect(Collectors.toList());
        task.forEach(r -> executorService.submit(r));
        SleepTools.second(20);
        executorService.shutdownNow(); //这里虽然返回了未执行完的任务，但是不可性
        //由于调用shutdownNow方法，任务被中断没有成功执行完的任务
        task.stream()
                .filter(c -> !((MyTask) c).isSuccess())
                .forEach(c -> {
                    System.out.println("task value : " + ((MyTask) c).value);
                });

    }

    public static class MyTask implements Callable<String> {
        private final Integer value;
        private boolean success = false;

        MyTask(int value) {
            this.value = value;
        }

        @Override
        public String call() throws Exception {
            System.out.println("task  [" + value + "] will be executed");
            SleepTools.second(value * 10 + 5);
            System.out.println("task  [" + value + "]  executes done");
            success = true;
            return "task result - " + value;
        }

        public boolean isSuccess() {
            return success;
        }
    }


    private static Callable<String> toTask(int i) {
        return () -> {
            System.out.println("task  [" + i + "] will be executed");
            SleepTools.second(i * 10 + 5);
            System.out.println("task  [" + i + "]  executes done");
            return "task result - " + i;
        };

    }
}
