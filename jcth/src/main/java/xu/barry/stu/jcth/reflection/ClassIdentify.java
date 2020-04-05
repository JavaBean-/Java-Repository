package xu.barry.stu.jcth.reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.Stream;

public class ClassIdentify {

    public String publicClassProperty = "publicClassProperty";

    private String privateClassProperty = "privateClassProperty";

    String property;

    public ClassIdentify() {
    }

    ClassIdentify(String property) {
        this.property = property;
    }

    private ClassIdentify(String property, String... property2) {
    }

    @Test
    public void classType() throws ClassNotFoundException {
        String str = "";
        Class c1 = str.getClass();
        System.out.println("方法一：" + c1.getName());
        Class c2 = Class.forName("java.lang.Integer");
        System.out.println("方法二：" + c2.getName());
        Class c3 = Long.class;
        System.out.println("方法三：" + c3.getName());
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class c4 = classLoader.loadClass("xu.barry.stu.jcth.reflection.ClassIdentify");
        System.out.println("方法四：" + c4.getName());

    }

    @Test
    public void getConstructor() {
        Constructor<?>[] c1 = ClassIdentify.class.getConstructors();

        Constructor<?>[] c2 = ClassIdentify.class.getDeclaredConstructors();

        Stream.of(c2).forEach(c ->
                System.out.println(
                        c.getClass().getCanonicalName() + " Parameter type :" + Arrays.toString(c.getParameterTypes()) + " : " + Arrays.toString(c.getParameters())));
    }

    @Test
    public void getProperty() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Object instance = new ClassIdentify();

        Stream.of(ClassIdentify.class.getFields()).forEach(System.out::println);
        Stream.of(ClassIdentify.class.getDeclaredFields()).forEach(System.out::println);

        System.out.println(ClassIdentify.class.getField(publicClassProperty));
        System.out.println(ClassIdentify.class.getDeclaredField(privateClassProperty));
        Field field = ClassIdentify.class.getDeclaredField(privateClassProperty);
        field.setAccessible(true);
        System.out.println(field.get(instance));
        field.set(instance,"new value");
        System.out.println(field.get(instance));
        /**
         * 重新获取 field 对象，不可以访问私有变量
         * java.lang.NoSuchFieldException: privateClassProperty
         */
        //System.out.println(ClassIdentify.class.getField(privateClassProperty).get(instance));
    }

    public static final String modifiers = "modifiers";

    @Test
    public void getModifiers() throws NoSuchFieldException {
        Field field = ClassIdentify.class.getDeclaredField(modifiers);
        System.out.println(field.getModifiers());
        String binary = Integer.toBinaryString(field.getModifiers());
        /**
         *  volatile
         *  1000000
         *  static
         *  1000
         *  public
         *  1
         *  public static volatile
         *  1001001
         */
        System.out.println(binary);
    }
}
