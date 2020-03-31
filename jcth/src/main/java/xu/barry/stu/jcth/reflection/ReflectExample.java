package xu.barry.stu.jcth.reflection;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Refection（可以弥补静态语言灵活性不足）
 * <p>
 * 运行中分析类的能力
 * 运行中查看和操作对象
 * 基于反射自由创建对象
 * 反射构建无法直接访问的类
 * set或者get到无法访问的成员变量
 * 调用不可访问的方法
 * 实现通用的数组操作代码
 * 类似函数指针的功能
 */
public class ReflectExample implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Test
    public void newInstance() throws CloneNotSupportedException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //静态new
        ReflectExample re = new ReflectExample();
        re.hello();

        /**
         * 实现clone接口
         * 1,首先调用父类的super.clone方法（父类必须实现clone方法）
         * 这个方法将最终调用Object的中native型的clone方法完成浅拷贝
         * 2,对类中的引用类型进行单独拷贝
         * 3,检查clone中是否有不完全拷贝(例如，链表），进行额外的复制
         *
         */
        ReflectExample cre = (ReflectExample) re.clone();
        cre.hello();

        /**
         * Java 后续版本明确不推荐使用
         * 通过序列化/反序列化加载对象（不安全）
         */
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ezxuxzh\\Documents\\data.obj"));
        out.writeObject(re);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\ezxuxzh\\Documents\\data.obj"));
        ReflectExample sre = (ReflectExample) in.readObject();
        in.close();
        sre.hello();

        /**
         * 反射调用类无参构造器
         * ReflectExample rre = (ReflectExample) Class.forName("xu.barry.stu.jcth.reflection.ReflectExample").newInstance();
         * has been deprecated since 9
         */
        ReflectExample rdre = (ReflectExample) Class.forName("xu.barry.stu.jcth.reflection.ReflectExample").getDeclaredConstructor().newInstance();
        rdre.hello();
        Method m = Class.forName("xu.barry.stu.jcth.reflection.ReflectExample").getDeclaredMethod("hello");
        m.invoke(rdre);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    private void hello() {
        System.out.println(" hello " + serialVersionUID);
        System.out.println(" hashCode " + hashCode());
    }

}
