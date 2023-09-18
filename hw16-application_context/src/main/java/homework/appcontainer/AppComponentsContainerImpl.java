package homework.appcontainer;

import homework.appcontainer.api.AppComponent;
import homework.appcontainer.api.AppComponentsContainer;
import homework.appcontainer.api.AppComponentsContainerConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public class AppComponentsContainerImpl implements AppComponentsContainer {

    private final List<Object> appComponents = new ArrayList<>();
    private final Map<String, Object> appComponentsByName = new HashMap<>();

    public AppComponentsContainerImpl(Class<?>... initialConfigClasses) throws Exception {

            for (Class<?> initialConfigClass : initialConfigClasses) {
                checkConfigClass(initialConfigClass);
            }

            List<Class<?>> configClasses = Arrays.stream(initialConfigClasses).sorted(Comparator.comparingInt(m -> m.getAnnotation(AppComponentsContainerConfig.class).order())).toList();
            for (Class<?> configClass : configClasses) {
                processConfig(configClass);
            }
    }

    private void processConfig(Class<?> configClass) throws Exception {
        // You code here...
        Object configClassInstance = configClass.getConstructor().newInstance();
        List<Method> methods = Arrays.stream(configClass.getMethods()).filter(method -> method.isAnnotationPresent(AppComponent.class))
                .sorted(Comparator.comparingInt(m -> m.getAnnotation(AppComponent.class).order())).toList();
        String componentName;
        Object component;
        for (Method method : methods) {
            componentName = getComponentName(method);
            component = method.invoke(configClassInstance, getArgs(method.getParameters()));
            appComponentsByName.put(componentName, component);
            appComponents.add(component);
        }

    }

    private void checkConfigClass(Class<?> configClass) {
        if (!configClass.isAnnotationPresent(AppComponentsContainerConfig.class)) {
            throw new IllegalArgumentException(String.format("Given class is not config %s", configClass.getName()));
        }
    }

    @Override
    public <C> C getAppComponent(Class<C> componentClass) {
        List<Object> components = appComponents.stream().filter(component -> componentClass.isAssignableFrom(component.getClass())).toList();
        if (components.size() > 1) {
            throw new AppContainerException("getting component is present in container more then one instance");
        } else if (components.size() == 0) {
            throw new AppContainerException("getting component is absent in container");
        }
        return (C) components.get(0);
    }

    @Override
    public <C> C getAppComponent(String componentName) {
        return (C) Optional.ofNullable(appComponentsByName.get(componentName)).orElseThrow(() -> new AppContainerException("Component is not in container"));
    }

    private String getComponentName(Method method) {
        return method.getAnnotation(AppComponent.class).name();
    }


    private Object[] getArgs(Parameter[] parameters) {
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < args.length; i++) {
            args[i] = getAppComponent(parameters[i].getType());
        }
        return args;
    }
}
