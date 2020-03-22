package xu.barry.stu.jcth.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Lambda表达式
 * 类似匿名方法，一个没有名字的方法
 * x -> x * 2
 * 被赋值后，可以看作是一个函数式接口的实例对象
 * 但是Lambda表达式没有存储目标类型(target type)的信息
 */
public class LambdaApply {

    private String var = "lambda var";

    /**
     * Lambda 表达式并没有类型
     * 考编译器推断，或者手动赋给类型
     */
    @Test
    public void nullType(){
        IntOperation iop = x -> x * 2;
        DoubleOperation dop = x -> x * 2;
    }

    /**
     * 测试方法重载
     * 编译器根据是否具有返回值
     * 推断调用方法
     * @throws Exception
     */
    @Test
    public void call() throws Exception {
        //没有返回值，编译器推测Runnable
        exec(  () -> {});
        //有返回值，编译器推测Callable
        String  hello = exec( () -> "done");
    }

    void exec(Runnable r)  {
        System.out.println("run");
        r.run();
    }
    <T> T exec(Callable<T> r) throws Exception {
        System.out.println("call");
        return r.call();
    }

    /**
     * Lambda表达式-访问局部变量
     * 和匿名内部类/局部内部类一样可以捕获变量，
     * 即访问外部嵌套块变量，变量应为final or effectively final
     * Lambda表达式-没有变量遮蔽问题
     * 表达式内容和嵌套块有相同的作用域
     * 不可以声明局部(外部嵌套代码块)同名变量,或参数
     */
    @Test
    public void lambdaVarAccess(){
        final String[] strs = new String[]{"Mega","Omega","alp","beta"};
        var = "var";
        var = "var2";
        String internalVar = "var";
        internalVar = "var2";
        Consumer<String> stringConsumer = str -> {
            //String var = "lambda internal var";//Variable 'var' is already defined in the scope
            System.out.println(Arrays.toString(strs));
            Arrays.sort(strs, Comparator.comparingInt( s -> s.length()));
            System.out.println(Arrays.toString(strs));
            /**
             * 全局变量可以不声明final，局部变量需要声明为final
             */
            System.out.println(var);
            /**
             * 编译失败必须声明为final
             * 如果初始化后变量引用未改变，编译器自动优化为effective final(即隐式final)
             * Variable used in lambda expression should be final or effectively final
             */
            //System.out.println(internalVar);
        };
        Arrays.stream(strs).forEach(stringConsumer);
    }

}
interface IntOperation{
    int operate(int i);
}
interface DoubleOperation{
    double operate(double i);
}