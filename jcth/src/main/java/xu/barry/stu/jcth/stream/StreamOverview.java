package xu.barry.stu.jcth.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Detail Document for Stream
 * <a>https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html#StreamOps</a>
 * Stream operations are divided into intermediate and terminal operations
 *
 * terminal operations
 * forEach()
 * forEachOrdered()
 * toArray()
 * reduce()
 * collect()
 * min()
 * max()
 * count()
 * anyMatch()
 * allMatch()
 * noneMatch()
 * findFirst()
 * findAny()
 *
 * intermediate
 */
public class StreamOverview {

	String[] names = new String[] { "barry", "lily", "ci", "clark" };

	@Test
	public void stream() {
		List<String> nlist = Arrays.asList(names);
		long c3 = nlist.stream()
				.filter(n -> n.length() > 3)
				.count();
		// 并行流，多个cpu并行操作，分段同时执行
		long c5 = nlist.parallelStream().filter(n -> n.length() > 4).count();
	}

	@Test
	public void parallel() {
		List<String> list = new ArrayList<>();
		list.add("C");
		list.add("H");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("F");
		list.add("--");

		list.parallelStream() // in parallel, not just concurrently!
				.filter(s -> !s.isEmpty()) // remove empty strings
				.distinct() // remove duplicates
				.peek(a -> System.out.println("before:"+a))
				.sorted() // sort them
				.peek(b -> System.out.println("after:"+b))
				.forEachOrdered(System.out::println);
	}

}
