package xu.barry.stu.jcth.proxy.self;

import java.lang.reflect.Method;

public interface InvocationHandler {
	
	void invoke(Object target, Method m);
	
}
