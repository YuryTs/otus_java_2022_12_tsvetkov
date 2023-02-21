package homework;

public class Demo {
    public static void main(String[] args) {
        TestLogging testLogging = Ioc.createTestLoggingInstance();
        testLogging.calculation(6, 8);
    }
}
