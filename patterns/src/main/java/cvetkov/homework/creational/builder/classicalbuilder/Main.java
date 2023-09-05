package cvetkov.homework.creational.builder.classicalbuilder;

public class Main {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilderImpl();
        carBuilder.setChassis("W23NH");
        carBuilder.setColor("Orange");
        carBuilder.setMarka("ChanGun");
        carBuilder.setYear(1);

        carBuilder.build();

        System.out.println(carBuilder);
    }
}
