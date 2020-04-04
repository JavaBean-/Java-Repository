package xu.barry.stu.jcth.proxy.self;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestProxy {
	public static void main(String[] argv) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		Working p = new Person();

		InvocationHandler h =new TimeInvocationHandler(p);

		p = (Working) Proxy.newProxyInstance(Working.class, h);

		p.working();
	}
}
