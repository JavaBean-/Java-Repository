package xu.barry.stu.jcth.lambda;

/**
 * 自定义函数式接口
 * 常用函数接口
 * Predicate T Boolean 接受一个参数，返回Boolean
 * Consumer T void 接受一个参数，无返回
 * Function T,R 接受一个参数返回一个值
 * Supplier None,T 数据工厂
 */
@FunctionalInterface
public interface FunctionalInterfaceManual {

    boolean test(String s);

    /**
     * 因为FunctionalInterfaceManual继承Object
     * 所以object内的方法
     * 可以没有实现
     *
     * @param obj
     * @return
     */
    boolean equals(Object obj);

}
