package xu.barry.stu.jcth.lambda;

import java.util.Arrays;
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
public class LambdaSample {

	public static String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Saturn", "Jupiter", "Uranus",
			"Neptune" };

	@Test
	public void sort() {

		Arrays.sort(planets, (a, b) -> a.length() - b.length());

		System.out.println(Arrays.toString(planets));

		
		
		
		/*
		 * Supplier提供者，functionSupplier提供一个函数
		 * () ->  Arrays::asList为lambda表达式
		 * Supplier.get返回  Arrays::asList 结果
		 */
		Supplier<Function<Integer[], List<Integer>>> functionSupplier = () ->  Arrays::asList;
		Function<Integer[],List<Integer>> mapper = functionSupplier.get();
		Function<Integer[],List<Integer>> mapper2 = Arrays::asList;
		
		/**
		 * functionSupplier2
		 * 第一个参数()表示Supplier输入是一个方法
		 */
		Supplier<Function> functionSupplier2 = () -> null;
		Function<Integer[],List<Integer>> function = Arrays::asList;
		Function<Stream<String>, Stream<String>> identity = LambdaSample.identity();
		/**
		 * Consumer消费者，使用传入的参数变量
		 */
		Consumer<String> action = LambdaSample::consumerToPrintln;
		action.accept("Consumer");
		Stream.of(Arrays.stream(planets), Arrays.asList(planets).stream())
		.flatMap(identity)
		.forEach(action);
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
