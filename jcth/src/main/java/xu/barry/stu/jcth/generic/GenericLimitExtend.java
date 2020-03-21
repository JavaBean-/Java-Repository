package xu.barry.stu.jcth.generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenericLimitExtend{

    @Test
    public void test(){
        Pair<Apple> apples = new Pair<>(new Apple(),new Apple());
        Pair<Fruit> fruits = new Pair<>(new Orange(),new Apple());
        limitExtend(apples);
        limitExtend(fruits);

    }

    /**
     * 上限界定符
     * Pair<? extends Fruit>
     * 只能get数据，不能set数据
     * 所以一般只在方法入参类型使用
     * @param fruit
     */
    public void limitExtend(Pair<? extends Fruit> fruit){
        Fruit f  =  fruit.getFirst();
        System.out.println("f:"+f);
        Fruit s  =  fruit.getSecond();
        System.out.println("s:"+s);
    }

    /**
     * 下限通配符
     * 只能set数据，get无法知道类型，
     * 只能使用Object接元素
     * Arrays sort(T[] a, Comparator<? super T> c)
     */
    @Test
    public void limitSuper(){
        Pair<? super Apple> fruits = new Pair<Fruit>();
        fruits.setFirst(new Apple());
        fruits.setSecond(new GreenApple());
        Object fruitFirs = fruits.getFirst();
        System.out.println(fruitFirs);

        Pair<? super Apple> apples = new Pair<Apple>();
        apples.setFirst(new Apple());
        apples.setSecond(new GreenApple());
        Object appleFirst = apples.getFirst();
        System.out.println(appleFirst);
    }

    /**
     * Pair<Apple> 与 Pair<Fruit>
     * 没有继承关系，没有任何关系
     * 编译报错。
     * 一个泛型类，因为传入不同类型T，
     * 产生的泛型变量，
     * 变量之间没有任何关系。
     */
    @Test
    public void generic(){
        Pair<Apple> apples = new Pair<>(new Apple(),new Apple());

        //Pair<Fruit> fruits = apples;//compile error
        //List<Fruit> fruits = new ArrayList<Orange>();//compile error

        /**
         * ArrayList是List子类可以向上转型
         */
        List<Fruit> Fruit = new ArrayList<Fruit>();
        //List<Fruit> oranges = new ArrayList<Orange>();//compile error
    }

    @Test
    public void noLimit() {
        //无限定通配符

        Pair<?> p = new Pair<>( new Apple(),new Orange());
        //无法set任何类型元素 compile error
        //p.setFirst(new Object());
        //get只能获取Object类型对象
        Object a = p.getFirst();
        System.out.println(a);
    }

    public void testMethod(){
        ArrayList<GreenApple> greenApples = new ArrayList<GreenApple>();
        ArrayList<Apple> apples = new ArrayList<Apple>();
        ArrayList<Fruit> fruits = new ArrayList<Fruit>();
        /**
         * 因为入参限定 List<? super Apple>
         * 要求入参必须是 List<? super Apple> 或父类
         * insertElements(greenApples);//compile error
         */
        insertElements(apples);
        insertElements(fruits);
    }

    public void insertElements(List<? super Apple> list){
        list.add(new GreenApple());
        list.add(new Apple());
        Object a = list.get(0);
        //list.add(new Fruit());
    }
}


class Pair<T> {

    T first;
    T second;

    public Pair() {
    }

    public Pair(T first) {
        this.first = first;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
