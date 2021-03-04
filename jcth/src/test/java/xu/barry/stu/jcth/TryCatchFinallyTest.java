package xu.barry.stu.jcth;

public class TryCatchFinallyTest {

    static int i = 0;

    @org.junit.Test
    public void test(){
//        i = 0 ;
//        i = i ++;
//        System.out.println(i);
//        i = ++ i;
        System.out.println(i);
        throw new IndexOutOfBoundsException();
    }

    @org.junit.Test
    public void in(){
        System.out.println("result: "+testException());
    }

    public int testException(){
        try{
            test();
            System.out.println("aa");
            return i;
        }catch (Exception e){
            e.printStackTrace();
            //return 5;
        } finally {
            //return ++i;
        }
        return i;
    }


    @org.junit.Test
    public void out(){
        for(;;){
            //无限循环
            System.out.println(returnFinally());
        }
    }
    public int returnFinally() {
        int i=0;
        try {
            i = 1;
            return i;
        } finally {
            i = 2;
            return i;
        }
    }


//    try 中 return 表达式执行但不返回的例子
//    一般来说 finally 块在任何时候都会执行，一般他会负责资源的回收，而且也会进行结果的返回，但有几点需要注意：
//
//    finally 块中一旦包含了 return 语句后，finally 块之后的语句中便不能再出现 return 否则编译错误
//    finally 块中的 return 语句会覆盖 try 语句中的 return
//    及时 finally 块中的 return 语句覆盖了 try 块中的 return 语句，但是 try 本该执行的 return 的表达式会执行；
//    这个过程实际是在 try 执行到 return 语句准备返回时执行 return 的表达式，然后跳入 finally 块中。


//    public static void main(String[] args) {
//        System.out.println(fun(2));
//    }

    public static int fun(int n) {
        try {
            return n += 1;
        } finally {
            return n + 2;
        }
    }

}
