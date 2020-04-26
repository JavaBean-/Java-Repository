package xu.barry.stu.jcth.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkProxyTest {


    public static void main(String[] avgr) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Cat c = new Cat();
        ActionHandler ah = new ActionHandler(c);
        /**
         * 多个接口中，声明了同名方法
         * 虚拟机将按顺序掉用，第一个接口中声明的方法、
         */
        Eat catP = (Eat) Proxy.newProxyInstance(Cat.class.getClassLoader(), new Class[]{Eat.class}, ah);
        catP.eating();
    }

    @Test
    public void lambdaProxy() {
        Eat e = () -> System.out.println("Eating");
        ActionHandler ah = new ActionHandler(e);
        Eat catP = (Eat) Proxy.newProxyInstance(Cat.class.getClassLoader(), new Class[]{Eat.class}, ah);
        catP.eating();
    }
}
