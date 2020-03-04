package xu.barry.stu.jcth.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Test;

/**
 * 
 * 一串元素
 *
 */
public class StreamOverview {

	String[] names = new String[] { "barry", "lily", "ci", "clark" };

	@Test
	public void method() {

		List<String> nlist = Arrays.asList(names);

		long c3 = nlist.stream().filter(n -> n.length() > 3).count();

		// 并行流，多个cpu并行操作，分段同时执行
		long c5 = nlist.parallelStream().filter(n -> n.length() > 4).count();
		System.out.println(c3);
		System.out.println(c5);
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
		list.add("");

		list.parallelStream() // in parallel, not just concurrently!
				.filter(s -> !s.isEmpty()) // remove empty strings
				.distinct() // remove duplicates
				.sorted() // sort them
				.forEachOrdered(System.out::println);

		list.stream() //
				.filter(s -> !s.isEmpty()) // remove empty strings
				.distinct() // remove duplicates
				.sorted(Comparator.naturalOrder()) // sort them
				.forEach(System.out::println);
	}

}
