package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {

    @Test
    public void create() {
        Stream<Integer> i = Stream.of(new Integer[]{1, 2, 3, 4, 5});
        Stream<String> s = Stream.of("a", "b", "c");
        Stream<String> empty = Stream.empty();
        Stream<String> hello = Stream.generate(() -> "hello");
        Stream<Double> d = Stream.generate(Math::random);
        Stream<BigInteger> b = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream intStream2 = IntStream.range(1, 5);//1...4
        IntStream intStream3 = IntStream.rangeClosed(1, 5);//1...5
        //基本类型流转对象流
        Stream<Integer> si = intStream1.boxed();
        IntStream is = si.mapToInt(Integer::intValue);
        //???
        IntUnaryOperator sss = IntUnaryOperator.identity();
        IntStream intStream4 = IntStream.iterate(1, sss);
        //并行流
        IntStream million = IntStream.range(1, 10000000);
        long evenNum = million.parallel().filter(n -> n % 2 == 0).count();
        System.out.println(evenNum);


    }

    /**
     *  Read file
     * @throws IOException
     */
    @Test
    public void other() throws IOException {

        Stream<String> contents = Files.lines(Paths.get("C:\\Users\\ezxuxzh\\Documents\\New Text Document.txt"));
        contents.forEach(System.out::println);

        Stream<String> works = Pattern.compile(",").splitAsStream("www,fds.gsg,gs,g,sg,sdgsg");
        works.forEach(System.out::println);
    }
}
