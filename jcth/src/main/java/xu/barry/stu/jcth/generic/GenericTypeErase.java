package xu.barry.stu.jcth.generic;

/**
 * JDK1.5引入泛型
 * 编译器解释编译泛型类型，泛型方法
 * 编译后得class文件不存在泛型概念
 */

public class GenericTypeErase<T extends  Number ,Comparable,Cloneable> {
    /**
     * extends后只能有一个类，多个接口。
     * 因为Number是一个类所以必须放在第一位。
     * 编译后文件GenericTypeErase中T自动转为Number类型
     * 即：GenericTypeErase<Number>
     */
}

/**
 * 重载泛型方法（自动桥方法）
 * 编译后文件包含子类setFirst(Integer first)与父类setFirst(Object first)
 * 两个方法。
 * 下面称之为（自动桥方法）
 * 编译文件中父类setFirst(Object first)调用子类setFirst(Integer first)
 */
class IntPair extends Pair<Integer>{
    public void setFirst(Integer first) {
        this.first = first;
    }
    public void setSecond(Integer second) {
        this.second = second;
    }
}