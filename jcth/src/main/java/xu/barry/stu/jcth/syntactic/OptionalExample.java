package xu.barry.stu.jcth.syntactic;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.util.Optional;

public class OptionalExample {

    @Test
    public void getOrElse(){
        Optional<String> str = Optional.of("NotEmpty");
        Printer.print(str.orElseGet(()->{
            Printer.partition();
            return "Gets a result.";
        }));
    }
}
