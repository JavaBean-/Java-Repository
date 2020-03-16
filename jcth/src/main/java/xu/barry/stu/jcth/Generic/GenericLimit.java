package xu.barry.stu.jcth.Generic;

import java.util.Comparator;
import java.util.stream.Stream;



/**
 * 泛型类型的限定
 * <T extends Comparable>
 */
public class GenericLimit {
    /**
     *
     * @param s
     * @param <T> 限定泛型T集成Comparable类
     *           具有compareTo方法，可以比较
     * @return
     */
    public static <T extends Comparable> T getMin(T... s){
        return Stream.of(s).min((a,b)-> a.compareTo(b)).orElse(null);
    }

}
