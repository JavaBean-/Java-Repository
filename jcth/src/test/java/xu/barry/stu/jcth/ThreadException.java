package xu.barry.stu.jcth;

import xu.barry.stu.jcth.utils.Printer;

/**
 * 测试new 子线程，方法中 finally{} 代码块内抛出异常。对主程序执行的影响
 */
public class ThreadException {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread);
        t.start();
        Printer.partition("main finish");
    }

}

class MyThread implements Runnable{

    @Override
    public void run() {
        Printer.partition();
        String a = null;
        try {
            Printer.partition("MyThread try");
        }catch (Exception e){
            Printer.partition("MyThread catch");
        }finally {
            a.endsWith("MyThread a");
        }

    }
}
