package cvetkov.homework.creational.factorymethod;

public class SedanCarVehicle extends CarVehicle {
    @Override
    protected Car createCar() {
        return new SedanCar();
    }
}
