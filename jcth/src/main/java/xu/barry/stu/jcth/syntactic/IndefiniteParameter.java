package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

/**
 * 不定项参数(可变参数)
 *
 * 一个方法只能有一个不定先参数，且必须位于列表最后
 * 重载优先级规则
 * 1：固定参数的方法，比可变参数优先级更高
 * 2：调用语句，同时与两个可变参数的方法匹配，报错
 */
public class IndefiniteParameter {

    @Test
    public void test(){
        print();

        print("aaaa");
        print("aaaa","bbbbb","ccccc");
    }

    public void print(String... argv){
        System.out.println(argv.length);
        for(String s :argv){
            System.out.println(s);
        }
    }

    /**
     * Ambiguous method call. Both
     * print(String...)
     * in IndefiniteParameter and
     * print(String, String...)
     * 声明方法时，并不报错，调用时会报错
     * @param a
     * @param argv
     */
//    public void print(String a,String... argv){
//        System.out.println(argv.length);
//        for(String s :argv){
//            System.out.println(s);
//        }
//    }

    public void print(String argv){
        System.out.println("definite: "+argv);
    }

}
