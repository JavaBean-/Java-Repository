package xu.barry.stu.jcth.nestedclass;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

/**
 *  It can access static data members of outer class including private.
 *  Static nested class cannot access non-static (instance) data member or method.
 */
public class StaticNested {
    private static String staticMessage = "Some static private message";
    private String nonStaticMessage = "Some private message";
    static class Inner{
        Inner(){
            Printer.println("Initnal Inner");
        }
        public void accessMessage(){
            Printer.println(staticMessage);
            //Printer.println(nonStaticMessage); Non-static field 'nonStaticMessage' cannot be referenced from a static context
        }
    }

    @Test
    public void initnal(){
        StaticNested.Inner nestInner = new StaticNested.Inner();
        nestInner.accessMessage();
        Printer.println("Initnal Over ");
    }

}

