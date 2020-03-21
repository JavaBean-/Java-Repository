package xu.barry.stu.jcth.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;

public class MethodReference {

    public static String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Saturn", "Jupiter", "Uranus",
            "Neptune"};

    /**
     * 方法引用：method Reference
     * Class::staticMethod  如：String::compareToIgnoreCaseMath::abs
     * Class::instanceMethod  如：String::compareToIgnoreCase
     * object::instanceMethod   如：System.out::println
     *      this::instanceMethod
     *      super::instanceMethod
     * Class::new 调用某类构造函数，支持单个对象构建
     * Class::new 调用某类构造函数，支持数组对象构建
     */
    @Test
    public void method() {
        /**
         * String::compareToIgnoreCase较为特殊
         * 为Class::instanceMethod引用
         * 方法签名为 int compareToIgnoreCase(String str)
         */
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        /**
         * 对应lambda表达式有两个入参
         * 第一个参数将变成方法的执行体，
         * 调用compareToIgnoreCase，并传入第二个参数
         */
        Comparator<String> compareToIgnoreCase2 = (a, b) -> a.compareToIgnoreCase(b);
        Arrays.sort(planets, compareToIgnoreCase);

        /**
         * object::instanceMethod
         * 等同于x -> System.out.println(x)
         * 也支持this super 关键字
         */
        Consumer<Double> print = System.out::print;
        print(System.out::print,2.3);

        /**
         * 使用new关键字构造
         * Class[]::new
         * 支持数组对象创建
         */
        Supplier<MethodReference> s = MethodReference::new;
        MethodReference methodReference = s.get();
        methodReference.hashCode();
        IntFunction<int[]> intArray = int[]::new;
        int[] nums = intArray.apply(10);
        Function<Integer,MethodReference[]> methodReferenceArray = MethodReference[]::new;
        MethodReference[] mrs = methodReferenceArray.apply(5);

    }

    /**
     *  work(Function<T,R> nf, T num)
     *  接收一个 Function 得函数时接口实例
     *  传入num调用Function nf中得apply()方法
     *  算出返回结果返回
     *
     *  work(Math::abs, a)
     *  Math::abs方法填充Function中的apply    //double abs(double a)
     *  Function实例完成
     */
    @Test
    public void FunctionUsage() {
        double a = -5.6;
        double b = work(Math::abs, a);
        System.out.println(b);

        double c = work(Math::floor, a);
        System.out.println(c);

        double d = work(Math::ceil, a);
        System.out.println(d);

        long e = work(Math::round, a);
        System.out.println(e);

        Function<Double,Long> fr = f -> Math.round(f);
        Long e2 = fr.apply(a);
        System.out.println(e2);
    }

    public static <T,R> R work(Function<T,R> nf, T num) {
        return nf.apply(num);
    }
     public static <T> void  print(Consumer<T> nc, T num) {
        nc.accept(num);
    }
}
