package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

/**
 * 可以添加属性/构造函数/方法
 * 构造函数只能是package-private(default)或者private，
 * 内部调用
 */
enum Enumsuger {

    SMALL(1), MEDIUM(2), LARGE(3), EXTRA_LARGE(4);

    private int size;

    Enumsuger(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

public class EnumExample {
    Enumsuger es1 = Enumsuger.SMALL;
    Enumsuger es2 = Enumsuger.SMALL;
    Enumsuger es3 = Enumsuger.valueOf("SMALL");
    Enumsuger es4 = Enum.valueOf(Enumsuger.class, "SMALL");

    Enumsuger em1 = Enumsuger.MEDIUM;
    Enumsuger em2 = Enumsuger.MEDIUM;
    @Test
    public void en() {
        singletonInstance();

        internalProperty();

        ordinalAndCompare();
    }

    private void ordinalAndCompare() {
        System.out.println("Enumsuger.SMALL  ordinal:" + es1.ordinal());
        System.out.println("Enumsuger.MEDIUM ordinal:" + em1.ordinal());
        System.out.println(em2.compareTo(es1));

        Enumsuger el1 = Enumsuger.LARGE;
        System.out.println(el1.compareTo(es1));
    }

    private void internalProperty() {
        System.out.println(em1.getSize());//2
        em1.setSize(20);
        System.out.println(em1 == em2);//true
        System.out.println(em1.getSize() + "  " + em2.getSize());//20  20
    }

    private void singletonInstance() {
        System.out.println(es1 == es2);//true
        System.out.println(es1.getSize() + "  " + es2.getSize());//1  1
        es1.setSize(3);
        System.out.println(es1.getSize() + "  " + es2.getSize());//3  3
        System.out.println(es1 == es2);//true

        System.out.println(es1 == es3);//true
        System.out.println(es1 == es4);//true
        System.out.println(es4.getSize());//3
    }
}