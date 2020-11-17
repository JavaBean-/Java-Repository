package xu.barry.stu.practice.array;

import org.junit.Test;
import xu.barry.stu.jcth.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsCopy {

    private List<String> strings = new ArrayList<>(5);


    public void setStrings(List<String> strings) {
        /**
         * 放入等长null占位
         */
        strings.forEach(a -> this.strings.add(null));
        /**
         * Collections.copy(desc , src);
         * 接口需要desc初始化后，并填入对象/null，需等长地址的占位。
         * 否则会抛出异常 java.lang.IndexOutOfBoundsException: Source does not fit in dest
         */
        Collections.copy(this.strings , strings);
    }

    public void printList(){
        strings.forEach(System.out::println);
    }

    @Test
    public void test(){
        /**
         * 注意：调用Arrays.asList()时，其返回值类型是ArrayList，
         * 但此ArrayList是Array的内部类，调用add()时，会报错：java.lang.UnsupportedOperationException，
         * 并且结果会因为array的某个值的改变而改变，故需要再次构造一个新的ArrayList。
         */
        List<String> s= new ArrayList<>(Arrays.asList("a","b","c","d","e"));

        CollectionsCopy bean = new CollectionsCopy();
        bean.setStrings(s);
        s.remove("a");
        s.forEach(System.out::println);
        Printer.line("----------- 深度复制，source 被移除 \"a\" 元素，dest 并没有移除 --------------");
        bean.printList();
    }
}
