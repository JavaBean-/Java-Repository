package xu.barry.stu.jcth.stream;

import org.junit.Test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 过滤，去重
 * 排序
 * 转化
 * 抽取/跳过/连接
 * 其他
 */
public class StreamTransf {

    String[] a = new String[]{"a1","a2","a3","a4"};
    String[] b = new String[]{"b1","b2","b3","b4"};
    String[] c = new String[]{"c1","c2","c3","c4"};
    Integer[] d = new Integer[]{23,434,5545,54,21,87};
    @Test
    public void contact(){
        Collection<String> c1 = Arrays.asList(a);
        HashSet<String> c2 = new HashSet<>(Arrays.asList(b));
        List<Collection<String>> l = new ArrayList<>();

        System.out.println("-----------------------------");
        Stream.of("String",a,b,c,c,c1).forEach(System.out::println);
        System.out.println("-----------------------------");
        l.add(c2);
        l.add(c1);
        System.out.println("-----------contan1(l)------------------");
        contan1(l).forEach(System.out::println);
        System.out.println("-----------contan2(l)------------------");
        contan2(l).forEach(System.out::println);
        System.out.println("-----------------------------");
        contan3(Arrays.asList(a),c,c2).forEach(System.out::println);

        System.out.println("----------- Sorted ------------------");
        Stream.of(d).sorted().forEach(System.out::println);
        System.out.println("----------- Sorted Comparator------------------");
        Stream.of(d).sorted(Comparator.comparing(Integer::intValue,(a,b)->b-a)).forEach(System.out::println);

    }

    /**
     * 拼接不同集合获得流
     * @param collections
     * @return
     */
    private Stream<String> contan1(List<Collection<String>> collections) {
        return collections.stream().map(a->a.stream()).reduce(Stream::concat).get();
    }

    private Stream<String> contan2(List<Collection<String>> collections) {
        return collections.stream().flatMap(Collection::stream);
    }

    private Stream<String> contan3(List<String> s1,String[] s2, Set<String> s3) {
        return Stream.of(s1.stream(), Arrays.stream(s2), s3.stream()).flatMap(Function.identity());
    }

    @Test
    public void mapToMap(){
        HashMap<String, Object> original = new HashMap<>();
        original.put("1",new Object());
        original.put("2",new Object());
        Map<String, String> copy = original.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
    }
}


