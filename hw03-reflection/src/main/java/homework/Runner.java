package homework;

import java.lang.reflect.InvocationTargetException;

public interface Runner {
    <T> void run(Class<ClassTest> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
