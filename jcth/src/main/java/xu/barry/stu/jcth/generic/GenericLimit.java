package xu.barry.stu.jcth.generic;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * 泛型类型的限定
 * <T extends Comparable .....>
 *     extends ....
 *     只能实现一个类，多个接口
 *     并且类必须排在第一个
 */
public class GenericLimit {
    /**
     *
     * @param s
     * @param <T> 限定泛型T实现Comparable类
     *           具有compareTo方法，可以比较
     * @return
     */
    public static <T extends Comparable> T getMin(T... s){
        return Stream.of(s).min((a,b)-> a.compareTo(b)).orElse(null);
    }

    @Test
    public void getMin(){
        /**
         * Integer实现了Comparable<Integer>接口
         * public final class Integer extends Number implements Comparable<Integer>
         */
        System.out.println(getMin(1,2,3,4,65,-2,11));
        /**
         * String 类实现了Comparable<T> 接口
         * public final class String implements java.io.Serializable, Comparable<String>, CharSequence
         */
        System.out.println(getMin("a","b","c","d","e","*"));
    }

}
