package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 流的计算
 * 简单约简/聚合函数:count/max/min/
 * 自定义约简：reduce
 * 查看/遍历元素：iterator/forEach
 * 存放数据结构
 *
 */
public class StreamResult {

    int[] a = new int[]{1,2,3,4,5,6,7,8,9,0};

    @Test
    public void compute(){
        System.out.println(Arrays.stream(a).count());
        Stream<Integer> s = Arrays.stream(a).boxed();
        System.out.println(Arrays.stream(a).boxed().max(Comparator.comparing(Function.identity())));
        System.out.println(Arrays.stream(a).boxed().min(Comparator.comparing(Function.identity())));
        Stream<Integer> t = Stream.of(1, 2, 3, 4, 5);

    }

}
