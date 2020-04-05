package xu.barry.stu.jcth.lambda;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 闭包包含自由（未绑定到特定对象）变量；
 * 这些变量不是在这个代码块内或者任何全局上下文中定义的，而是在定义代码块的环境中定义（局部变量）。
 * “闭包”一词来源于以下两者的结合：要执行的代码块
 * （由于自由变量被包含在代码块中，这些自由变量以及它们引用的对象没有被释放）
 * 和为自由变量提供绑定的计算环境（作用域）。
 */
public class Closures {

    private static class Closure {

        public int value;

        public Closure(int initValue) {
            this.value = initValue;
        }

    }

    public static Map<String, Supplier> createCounter(int initValue) {
        Closure closure = new Closure(initValue);
        Map<String, Supplier> counter = new HashMap<>();
        counter.put("val", () -> closure.value);
        counter.put("inc", () -> closure.value++);
        return counter;
    }

    @Test
    public void getCounter() {
        Map<String, Supplier> v = createCounter(42);
        v.get("val").get(); // returns 42
        v.get("inc").get(); // returns 42
        v.get("val").get(); // returns 43
    }

}
