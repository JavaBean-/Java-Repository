package xu.barry.stu.jcth.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Functional interface:a functional interface has exactly one abstract method.
 * Java 自带函数式接口 package: java.util.function
 */
public class LambdaSample implements Comparable<LambdaSample>{

	public static LambdaSample instance = new LambdaSample();

	public static String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Saturn", "Jupiter", "Uranus",
			"Neptune" };
	public static Object[] objects = new Object[] { 1, "Venus", 1.0, "Mars", true, "Jupiter", "Uranus",
			"Neptune" };

	public static LambdaSample[] LambdaSamples = new LambdaSample[] { instance, instance,instance,instance,instance };

	@Test
	public void sort() {
		/**
		 * Comparator 接口定义，
		 * 返回 0 ，a == b
		 * 返回负数， a < b
		 * 返回正数， a > b
		 */
		Arrays.sort(planets, (a, b) -> a.length() - b.length());//直观表达下一条语句得逻辑
		Arrays.sort(planets, Comparator.comparingInt(x -> x.length()));//与上一条语句功能相同，可以替换上条语句，
		System.out.println("split~split~split~split~split~split~split~");
		System.out.println(Arrays.toString(planets));
		Arrays.sort(planets, Comparator.naturalOrder());
		System.out.println(Arrays.toString(planets));
		/**
		 * 因为Object没有实现Comparable<Object>接口
		 * 所以不能使用Comparator.naturalOrder()进行排序
		 * Comparator用来定义排序方法
		 * Comparable用来定义比较方法
		 *
		 */
		//Arrays.sort(objects, Comparator.naturalOrder());
		Arrays.sort(objects, (a,b) -> a.hashCode() - b.hashCode() );
		System.out.println(Arrays.toString(objects));
		Arrays.sort(LambdaSamples, Comparator.naturalOrder());
	}

	@Override
	public int compareTo(LambdaSample o) {
		return this.hashCode() - o.hashCode();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Test
	public void consumer() {
		/**
		 * Consumer消费者，使用传入的参数变量
		 */
		Function<Stream<String>, Stream<String>> identity = LambdaSample.identity();
		Consumer<String> action = LambdaSample::consumerToPrintln;
		action.accept("Consumer");
		Stream.of(Arrays.stream(planets), Arrays.asList(planets).stream())
		.flatMap(identity)
		.forEach(action);
	}

	/**
	 * Supplier提供者，functionSupplier提供一个函数
	 * () ->  Arrays::asList为lambda表达式
	 * Supplier.get返回  Arrays::asList 结果
	 */
	@Test
	public void supplier() {
		Supplier<Function<Integer[], List<Integer>>> functionSupplier = () ->  Arrays::asList;
		Function<Integer[],List<Integer>> mapper = functionSupplier.get();
		Function<Integer[],List<Integer>> mapper2 = Arrays::asList;
		/**
		 * functionSupplier2
		 * 第一个参数()表示准备实现Supplier的get方法
		 * 方法是现实逻辑是:return null
		 */
		Supplier<Function> functionSupplier2 = () -> null;
		Function<Integer[],List<Integer>> function = Arrays::asList;
	}

	// 没有返回结果，
	static <T> void consumerToPrintln(T a) {
		System.out.println(a.toString());
	}
	// 返回参数是一个Function对象
	static <T> Function<T, T> identity() {
		return t -> t;
	}


}
