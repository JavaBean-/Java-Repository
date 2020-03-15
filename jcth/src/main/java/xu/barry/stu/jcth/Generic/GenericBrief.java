package xu.barry.stu.jcth.Generic;

import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 编写的代码可以被不同类型的对象所重用
 * 泛型类:ArrayList, HashSet, HashMap等
 * 泛型方法:Collections.binarySearch, Arrays.sort等
 * 泛型接口:List, Iterator等
 *
 * 泛型的本质
 * 参数化类型, 避免类型转换， 代码可复用
 *
 * E:Element
 * K:key
 * V:value
 * T:template(局部变量）
 */
public class GenericBrief {

    @Test
    public void example(){

        List<Integer> numberList = new ArrayList<>(Arrays.asList(0,5,6,7,1,2,3,4,12,-2));

        List<String> strList = new ArrayList<>(Arrays.asList("abc","ZXC","1","2"));
        /**
         * Collections.binarySearch 泛型方法
         * 需要序列正向排序
         */
        Collections.sort(numberList);
        System.out.println(numberList);
        System.out.println("Find 3 "+Collections.binarySearch(numberList,3));
        Collections.sort(strList);
        System.out.println(strList);
        System.out.println("Find str "+Collections.binarySearch(strList,"2"));
    }

}

class Interval<T>{

    private T lower;
    private T upper;

    public Interval(T lower,T upper){
        this.lower = lower;
        this.upper = upper;
    }

    public T getLower() {
        return lower;
    }
}