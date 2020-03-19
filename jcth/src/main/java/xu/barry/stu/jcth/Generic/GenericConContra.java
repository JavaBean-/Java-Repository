package xu.barry.stu.jcth.Generic;

import org.junit.Test;

import java.util.ArrayList;

class A {
}

class B extends A {
}

class C extends B {
}

/**
 * Generic Co- and Contra
 * 泛型的协变与逆变
 */
public class GenericConContra {

    /**
     * 类型变化关系(type variance)概念
     *  更复杂类型中的子类型关系，与子类型之间的关系相关联
     *  协变：if A extends B
     *          then f(A) extends f(B)
     *  逆变：if A < B
     *          then f(B) extends f(A)
     *  不变：既不是协变也不是逆变
     *  双变：if A extends B
     *          then f(A) extends f(B) and f(B) extends f(A)
     */

    /**
     * Java数组是协变的
     * if B extends A
     * then B[] extends a[]
     */
    @Test
    public void array() {
        B[] bs = new B[5];
        A[] as = bs;

        try {
            as[0] = new A();//compile is ok ,runtime error
        } catch (ArrayStoreException e) {
            e.printStackTrace();
        }
        try {
            as[0] = new C();//compile is ok ,runtime ok
        } catch (ArrayStoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java 泛型是不变的
     * ArrayList<String> 与 ArrayList<Object>
     * 没有任何继承关系
     */
    @Test
    public void generic() {
        /**
         * Incompatible types.
         * Required:    ArrayList<java.lang.Object>
         * Found:       ArrayList<java.lang.String>
         * ArrayList<Object> a = new ArrayList<String>();
         */

        /**
         * <? extends T> 协变
         */
        ArrayList<? extends A> listE = new ArrayList<B>();
        A a = listE.get(1);

        /**
         * <? super T> 逆变
         */
        ArrayList<? super B> listS = new ArrayList<A>();
        Object b = listS.get(0);
    }

}

/**
 * JDK1.5版本以后
 * 方法重写返回值，可以协变
 * 子类重写方法的返回值可以是父类方法的返回值的子类
 */
class Son extends Father {
    public C f(B obj) {
        return new C();
    }
}

class Father {
    public B f(B obj) {
        return new B();
    }
}