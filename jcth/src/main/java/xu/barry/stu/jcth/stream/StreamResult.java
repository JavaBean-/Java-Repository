package xu.barry.stu.jcth.stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    Integer[] integers = new Integer[]{1,2,3,4,5,6,7,8,9,0};

    List<Integer> integerList = Arrays.asList(integers);

    @Test
    public void compute(){
        System.out.println(integerList.stream().count());
        //create stream
        Stream<Integer> s = Arrays.stream(a).boxed();

        //primitive int Stream transfer to Wrapped Integer Stream
        IntStream p = integerList.stream().mapToInt(Integer::intValue);

        //find max or min value
        System.out.println(Arrays.stream(a).boxed().max(Comparator.comparing(Function.identity())));
        System.out.println(Arrays.stream(a).boxed().min(Comparator.comparing(Function.identity())));

        //Create a wrapper int stream
        Stream<Integer> t = Stream.of(1, 2, 3, 4, 5);
        Object[] array = t.toArray();
        Collector();

        //Just test @FunctionalInterface
        Supplier<Function<Integer, List<Integer>>> functionSupplier = () ->  Arrays::asList;
        integerList.stream().map(functionSupplier.get());
        integerList.stream().map(Arrays::asList);

        //Collector is not a @FunctionalInterface
        //List<Integer> liste = integerList.stream().collect(Collectors::toList);
    }

   @Test
    public void Collector() {
        //stream covert to List or map or set
        List<Integer> listr = integerList.stream().collect(Collectors.toList());
        Set<Integer> set = integerList.stream().collect(Collectors.toSet());
        Map<Integer, Integer> map = integerList.stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue));
    }

    @Test
    public void sumOfStream() {
        //make value power of by 2 and sum them then print
        integerList.stream()
                .map(a -> Math.pow(a,2))
                .reduce((a,b) -> a+b)
                .ifPresent(System.out::println);
        integerList.stream()
                .map(a -> Math.pow(a, 2))
                .reduce(Double::sum)
                .ifPresent(System.out::println);
        integerList.stream()
                .map(a -> Double.valueOf(Math.pow(a, 2)).intValue())
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }

    @Test
    public void test1(){
        String url = "[2001:1b70:8201:b53::1a]:5000";
        String registryHost = url.substring(url.indexOf('[')+1,url.indexOf(']'));

        registryHost = StringUtils.substringBetween(url, "[","]");

    }

}
