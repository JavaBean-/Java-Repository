package xu.barry.stu.jcth.generic;

/**
 * 实现接口时，指定T类型
 * 同时确定方法add的
 * 参数，返回值类型
 * @param <T>
 */
@FunctionalInterface
public interface GenericInterface<T> {
    T add(T operand1,T operand2);
}

/**
 * IntegerCalculator是现实确定了接口泛型类型
 */
class IntegerCalculator implements GenericInterface<Integer>{
    @Override
    public Integer add(Integer operand1, Integer operand2) {
        return operand1 + operand2;
    }

    public static void main(String[] argv){
        GenericInterface<Integer> c2 = new IntegerCalculator();
        System.out.println(c2.add(1,2));
    }

}

/**
 * IntervalCalculator实现了
 * 双层泛型嵌套
 */
class IntervalCalculator implements GenericInterface<Interval<Integer>>{

    @Override
    public Interval<Integer> add(Interval<Integer> operand1, Interval<Integer> operand2) {
        int lower = operand1.getLower() + operand2.getLower();
        int upper = operand1.getUpper() + operand2.getUpper();
        return new Interval<>(lower,upper);
    }


    public static void main(String[] argv){
        GenericInterface<Interval<Integer>> ic = new IntervalCalculator();
        Interval<Integer> a = new Interval<>(1, 10);
        Interval<Integer> b = new Interval<>(2, 20);
       System.out.println(new IntervalCalculator().add(a,b));
    }
}

