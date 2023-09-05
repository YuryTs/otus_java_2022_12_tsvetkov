package cvetkov.homework.creational.factorymethod;

public class MainFactoryMethod {
    public static void main(String[] args) {
        CarVehicle carVehicle1 = new SedanCarVehicle();
        Car sedanCar = carVehicle1.create();
        sedanCar.getMeet();

        CarVehicle carVehicle2 = new CoupeCarVehicle();
        Car coupeCar = carVehicle2.create();
        coupeCar.getMeet();

        Car sedanCar2 = carVehicle1.create();
        sedanCar2.getMeet();
    }
}
