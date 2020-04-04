package xu.barry.stu.jcth.proxy.self;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeInvocationHandler implements InvocationHandler {

	Object object;
	
	public TimeInvocationHandler(Object o) {
		object = o;
	}
	
	@Override
	public void invoke(Object target, Method m) {
		try {
			System.out.println("Add action before Invocation");
			m.invoke(object, null);
			System.out.println("Add action after Invocation");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
