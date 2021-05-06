package xu.barry.stu.jcth.juc.executors;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;
import xu.barry.stu.jcth.utils.SleepTools;

public class CompletableFuture {

    /**
     * 两个CompletionStage，谁计算的快，我就用那个CompletionStage的结果进行下一步的消耗操作。
     */
    @Test
    public void acceptEither() {
        java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(3);
            return "s1";
        }).acceptEither(java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            return "hello world";
        }), Printer::println);
        while (true){}
    }

    @Test
    public void runAsync() throws Exception {
        java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(2);
            System.out.println("run end ...");
            return "s1";
        });

        while (true){
            System.out.println("while (true)");
            SleepTools.second(1);
        }
    }

    /**
     * 两个CompletionStage，任何一个完成了都会执行下一步的操作（Runnable）。
     */
    @Test
    public void runAfterEither() {
        java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(3);
            return "s1";
        }).runAfterEither(java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(3);
            return "s2";
        }), () -> Printer.println("hello world"));
        while (true) {
        }
    }

    /**
     * 当运行完成时，对结果的记录。这里的完成时有两种情况，一种是正常执行，返回值。
     * 另外一种是遇到异常抛出造成程序的中断。这里为什么要说成记录，因为这几个方法都会返回CompletableFuture，
     * 当Action执行完毕后它的结果返回原始的CompletableFuture的计算结果或者返回异常。
     * 所以不会对结果产生任何的作用。
     */
    @Test
    public void whenComplete() {
        String result = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(3);
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).whenComplete((s, t) -> {
            Printer.println(s);
            Printer.println(t.getMessage());
        }).exceptionally(e -> {
            Printer.println(e.getMessage());
            return "hello world";
        }).join();
        Printer.println(result);
    }

    /**
     * 运行完成时，对结果的处理。这里的完成时有两种情况，一种是正常执行，返回值。
     * 另外一种是遇到异常抛出造成程序的中断。
     */
    @Test
    public void handle() {
        String result = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            SleepTools.second(3);

            //出现异常
            if (1 == 1) {
                throw new RuntimeException("测试一下异常情况");
            }
            return "s1";
        }).handle((s, t) -> {
            if (t != null) {
                return "hello world";
            }
            return s;
        }).join();
        Printer.println(result);
    }
}
