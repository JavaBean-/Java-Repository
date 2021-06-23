package xu.barry.stu.jcth.juc.tools;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocalTest {

    private static ThreadLocal<List<String>> collectResults = ThreadLocal.withInitial(ArrayList::new);


    public static void main(String[] args) throws InterruptedException {
        List<String> list = collectResults.get();
        System.out.println(list);
        collectResults.remove();
        List<String> list2 = collectResults.get();
        System.out.println(list2);
    }
}
