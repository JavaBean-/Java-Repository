package xu.barry.stu.jcth.Generic;

import org.junit.Test;

public class GenericMethod {

    /**
     * 普通类中的泛型方法
     * @param a
     * @param <T> 引入类型
     * @return
     */
    public static <T> T getMiddle(T... a){
        return a[a.length/2];
    }

    @Test
    public void call(){

        /**
         *  在调用方法之前可以通过尖括号
         *  指定泛型参数的类型
         *  这时编译器会强制检查
         */
        System.out.println(new GenericMethod().<String>getMiddle("abc","def","hij"));
        System.out.println(GenericMethod.<String>getMiddle("abc","def","hij"));

        /**
         * 当未指定类型，
         * 虚拟机会转型为共同超类
         * null不影响接值
         */
        System.out.println(getMiddle(1,2,null,new GenericMethod(),"","aaaas",new GenericMethod()));
        System.out.println(getMiddle(1,2.0,3f,4L));
        System.out.println(getMiddle(new GenericMethod(),1,true,"aaaas"));

        /**
         * 控制台输出null
         */
        GenericMethod a = null;
        System.out.println(a);
    }

}
