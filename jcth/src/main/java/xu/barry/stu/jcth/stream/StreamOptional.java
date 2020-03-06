package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamOptional {

    Integer[] a = new Integer[]{2, 1, 3, 4, 5, 6};

    @Test
    public void caseOne() {
        Stream<Integer> s = Stream.of(a);
        Optional<Integer> maxResult = s.max((n1, n2) ->  - n1 + n2);
        System.out.println("the max result of s is " + maxResult.get());

        Stream<Integer> sa = Stream.of(a);
        maxResult = sa.filter(n -> n > 10).max((n1, n2) -> n1 - n2);
        System.out.println("the max result of sa is " + maxResult.get());

    }

    @Test
    public void optional(){
        Optional<String> h = Optional.of(new String("hello!"));
        String o = h.get();
        System.out.println("o: "+o);

        Optional<String> e = Optional.empty();
        String d = e.orElse("ddd");
        System.out.println("d: "+d);

        Optional<String> n = Optional.ofNullable(d);
        n.ifPresent(System.out::println);
        Optional<Integer> x = Optional.of(1);
        x.ifPresent(System.out::println);
    }



}
