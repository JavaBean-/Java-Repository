package xu.barry.stu.jcth.syntactic;

import org.junit.Test;

/**
 * 自动装箱，自动拆箱
 */
public class Boxing {

    /**
     * 自动装箱/拆箱是编译器
     * 做的优化
     * ==：基本类型是内容相同
     *     对象是指针是否相同
     *     基本类型没有空值
     *     对象存在null值，可能触发NullPointerException
     * 基础类型 与包装类进行==，+，-，*，/运算时
     * 会将包装类进行拆箱。对基础数据类型进行运算
     */
    @Test
    public void autoBoxing(){
        Integer autoboxing5 = 5;
        Integer boxing5= Integer.valueOf(5);
        Integer autoboxing10 = 10;
        Long long10 = 10L;

        int autoUnboxing5 = autoboxing5;
        int unboxing5 = boxing5.intValue();

        System.out.println(autoboxing5 == autoUnboxing5);//true
        System.out.println(autoboxing5 == boxing5);//true

        System.out.println(long10.equals(autoboxing5 + 5));//false隐含自动拆箱，相加计算，自动装箱(Integer)，最后比较
        System.out.println(long10.equals(autoboxing5 + 5L));//true,隐含自动拆箱，相加计算，自动装箱(Long)，最后比较
        System.out.println(long10.equals((long)(autoboxing5 + 5)));//true
    }

    /**
     * int + long = long
     * int + float = float
     * long + float = float
     * float + double = double
     * long + double = double
     * 8种 基础类型
     * int byte short long float double boolean char
     */
    @Test
    public void castNum(){
        int a = 2;
        long b = 4;
        long c = a + b;
        float d = 1.0f + c;
        float e = a + (short)123;
        double f = 3.4;
        double g = e + f;
        double h = c + g;
    }

    /**
     * Integer -128~127 范围常量池保存对象
     */
    @Test
    public void integer() {
        Integer autoboxing128A = 128;
        Integer autoboxing128B = 128;
        Integer boxing128= Integer.valueOf(128);
        System.out.println(autoboxing128A == boxing128);//false
        System.out.println(autoboxing128A == autoboxing128B);//false
        System.out.println(autoboxing128A.equals(boxing128));
    }
}
