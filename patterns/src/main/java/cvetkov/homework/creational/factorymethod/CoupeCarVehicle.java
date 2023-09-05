package cvetkov.homework.creational.factorymethod;

public class CoupeCarVehicle extends CarVehicle{
    @Override
    protected Car createCar() {
        return new CoupeCar();
    }
}
