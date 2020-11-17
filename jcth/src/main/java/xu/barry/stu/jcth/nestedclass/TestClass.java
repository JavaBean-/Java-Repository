package xu.barry.stu.jcth.nestedclass;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

/**
 *  It can access static data members of outer class including private.
 *  Static nested class cannot access non-static (instance) data member or method.
 *  静态内部类 可以 访问外部类静态属性，并且可以修改
 *  内部类 可以 访问外部类静/非静态属性，并且可以修改
 */
public class TestClass{
    @Test
    public void initial(){
        NestedClass.StaticInner staticInner = new NestedClass.StaticInner();
        staticInner.accessMessage();

        Printer.partition();


        NestedClass sn = new NestedClass();
        NestedClass.Inner i = sn.new Inner();
        i.accessMessage();

    }
}

class NestedClass {
    private static String staticMessage = "Some static private message";
    private String nonStaticMessage = "Some non static private message";

    static class StaticInner{
        StaticInner(){
            Printer.println("Initial Static Inner ");
        }
        public void accessMessage(){
            Printer.println(staticMessage);
            staticMessage =  "static message -- change inner static class";
            //Printer.println(nonStaticMessage); Non-static field 'nonStaticMessage' cannot be referenced from a static context
        }
    }

    public class Inner{
        Inner(){
            Printer.println("Initial Inner");
        }
        public void accessMessage(){
            Printer.println(staticMessage);
            Printer.println(nonStaticMessage);
            nonStaticMessage = "non static Message -- change inner class";
            Printer.println(nonStaticMessage);
        }
    }



}


