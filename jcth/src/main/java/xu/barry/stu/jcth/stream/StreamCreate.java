package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreate {

    @Test
    public void create() {
        createStream();

        collectionTransferStream();

        primitiveStream();

        parallelStream();

        otherFunction();
    }

    private void otherFunction() {
        IntUnaryOperator sss = IntUnaryOperator.identity();
        IntStream intStream4 = IntStream.iterate(1, sss);
    }

    private void parallelStream() {
        //并行流
        IntStream million = IntStream.range(1, 10000000);
        long evenNum = million.parallel().filter(n -> n % 2 == 0).count();
        System.out.println(evenNum);
    }

    private void collectionTransferStream() {
        //List transfer stream
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        list.stream().skip(1).limit(5).forEach(System.out::print);
    }

    private void primitiveStream() {
        //primitive int stream
        IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
        IntStream intStream2 = IntStream.range(1, 5);//1...4
        IntStream intStream3 = IntStream.rangeClosed(1, 5);//1...5

        //基本类型流转对象流
        Stream<Integer> si = intStream1.boxed();
        IntStream is = si.mapToInt(Integer::intValue);
    }

    private void createStream() {
        Stream<Integer> i = Stream.of(new Integer[]{1, 2, 3, 4, 5});
        Stream<String> s = Stream.of("a", "b", "c");
        Stream<String> empty = Stream.empty();
        Stream<String> hello = Stream.generate(() -> "hello");
        Stream<Double> d = Stream.generate(Math::random);
        Stream<BigInteger> b = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
    }

    /**
     * Read file
     * Regular expression
     *
     * @throws IOException
     */
    @Test
    public void other() throws IOException {

        String url = Files.lines(Paths.get("C:\\Users\\ezxuxzh\\Documents\\New Text Document.txt"))
                .filter(s -> s.contains("server: "))
                .map(t -> t.replace("server: ","").trim())
                .findAny()
                .orElse(null);
        System.out.println(url);

        Stream<String> works = Pattern.compile(",").splitAsStream("www,fds.gsg,gs,g,sg/,sdgs//g");
        works.forEach(System.out::println);
}
}
