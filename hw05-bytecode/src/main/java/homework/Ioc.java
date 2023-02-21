package homework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class Ioc {
    public Ioc() {
    }

    static TestLogging createTestLoggingInstance() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLoggingImpl());
        return (TestLogging) Proxy.newProxyInstance(TestLogging.class.getClassLoader(),
                new Class[]{TestLogging.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLogging testLogging;
        private final List<String> methodsToProxied = new ArrayList<>();

        DemoInvocationHandler(TestLogging testLogging) {
            Arrays.stream(testLogging.getClass().getDeclaredMethods()).filter(method -> method.isAnnotationPresent(Log.class))
                    .forEach(method -> methodsToProxied.add(method.getName() + Arrays.toString(method.getParameters())));
            this.testLogging = testLogging;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methodsToProxied.contains(method.getName() + Arrays.toString(method.getParameters()))) {
                System.out.println("executed method: " + method.getName() + " " + Arrays.toString(args));

            }
            return method.invoke(testLogging, args);
        }
    }
}
