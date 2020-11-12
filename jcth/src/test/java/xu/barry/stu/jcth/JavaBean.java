package xu.barry.stu.jcth;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaBean {

    private List<String> strings = new ArrayList<>(5);


    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings.add(null);
        this.strings.add(null);
        this.strings.add(null);
        this.strings.add(null);
        this.strings.add(null);
        Collections.copy(this.strings , strings);
    }

    public void printList(){
        strings.forEach(System.out::println);
    }

    @Test
    public void test(){
        ArrayList<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");

        JavaBean jb = new JavaBean();
        jb.setStrings(s);
        s.remove("a");
        s.forEach(System.out::println);
        System.out.println("----------- --------------");
        jb.printList();
    }
}
