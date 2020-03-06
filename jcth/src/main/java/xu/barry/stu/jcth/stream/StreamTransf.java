package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
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

        contan1(l).forEach(System.out::println);
        System.out.println("-----------------------------");
        contan2(l).forEach(System.out::println);
        System.out.println("-----------------------------");
        contan3(Arrays.asList(a),c,c2).forEach(System.out::println);
    }

    private Stream<String> contan1(List<Collection<String>> collections) {
        return collections.stream().map(a->a.stream()).reduce(Stream::concat).get();
    }

    private Stream<String> contan2(List<Collection<String>> collections) {
        return collections.stream().flatMap(Collection::stream);
    }

    private Stream<String> contan3(List<String> s1,String[] s2, Set<String> s3) {
        return Stream.of(s1.stream(), Arrays.stream(s2), s3.stream()).flatMap(Function.identity());
    }
}


