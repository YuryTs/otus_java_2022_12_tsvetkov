package cvetkov.homework.creational.factorymethod;

public abstract class CarVehicle {
    public Car create(){
        return createCar();
    }
    protected abstract Car createCar();
}
