package xu.barry.stu.jcth.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class JdkProxyTest {

    @Test
    public void jdkProxy() {
        Cat c = new Cat();
        ActionHandler ah = new ActionHandler(c);
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
