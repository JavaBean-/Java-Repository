package xu.barry.stu.jcth.proxy.self;

import java.lang.reflect.Method;

public interface InvocationHandler {
	
	public void invoke(Object target, Method m);
	
}
