package xu.barry.stu.jcth.utils;

public class Printer {

    private static final String PARTITION = "------------------------------------------------------";

    private static StackTraceElement stackTraceElement = Thread.getAllStackTraces().get(Thread.currentThread())[3];

    private Printer(){};

    public static void println(Object s){
        System.out.println(s);
    }

    public static void print(CharSequence s){
        System.out.print(s);
    }

    public static void partition(CharSequence message){
        println(PARTITION+message+PARTITION);
    }
    public static void partition(){
        partition("");
    }
    public static void line(CharSequence s){
        print(s);
        int n = 120 - s.length()%120;
        for(int i = n ; i>0; i--) print(" ");
        String[] name = stackTraceElement.getClassName().split("\\.");
        println(name[name.length-1] +"->" + stackTraceElement.getLineNumber());
    }
}
