package xu.barry.stu.jcth.nestedclass;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

public class Staticnested {

    Inner a  = new Inner();

     class Inner{
        Inner(){
            Printer.println("Initnal Inner");
        }
    }

    @Test
    public void initnal(){
        Printer.println("Initnal Over ");
    }



}

