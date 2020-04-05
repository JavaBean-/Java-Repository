package xu.barry.stu.jcth.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ActionHandler implements InvocationHandler {

    private Object subject;

    ActionHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Action before Invoke");

        Object result = method.invoke(subject, args);

        System.out.println("Action after Invoke");
        return result;
    }
}
