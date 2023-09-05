package cvetkov.homework.creational.singletone.firstsingleton;

public final class Car {
    private static final Car INSTANCE = new Car();

    public Car() {
        System.out.println("Constructor is running");
    }

    public static Car instance(){
        return INSTANCE;
    }
}
