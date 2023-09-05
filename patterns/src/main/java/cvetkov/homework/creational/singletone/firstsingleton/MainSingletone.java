package cvetkov.homework.creational.singletone.firstsingleton;

public class MainSingletone {
    public static void main(String[] args) {
        System.out.println("_______begin__________");
        Car car1 = Car.instance();
        Car car2 = Car.instance();
        System.out.println(car1);
        System.out.println(car2);

        System.out.printf("car1 == car2 => %b\n", car1 == car2);
        System.out.println("_________end__________");

    }
}
