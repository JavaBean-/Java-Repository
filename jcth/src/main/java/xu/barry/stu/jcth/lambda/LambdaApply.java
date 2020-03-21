package xu.barry.stu.jcth.lambda;

import org.junit.Test;

/**
 * Lambda表达式
 * 类似匿名方法，一个没有名字的方法
 * x -> x * 2
 * 被赋值后，可以看作是一个函数式接口的实例对象
 * 但是Lambda表达式没有存储目标类型(target type)的信息
 */
public class LambdaApply {

    /**
     * Lambda 表达式并没有类型
     * 考编译器推断，或者手动赋给类型
     */
    @Test
    public void nullType(){
        IntOperation iop = x -> x * 2;
        DoubleOperation dop = x -> x * 2;
    }


}
interface IntOperation{
    int operate(int i);
}
interface DoubleOperation{
    double operate(double i);
}