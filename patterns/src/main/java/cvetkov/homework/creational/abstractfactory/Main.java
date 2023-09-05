package cvetkov.homework.creational.abstractfactory;

import cvetkov.homework.creational.abstractfactory.carsfactory.CarsFactry;
import cvetkov.homework.creational.abstractfactory.carsfactory.FordFactory;
import cvetkov.homework.creational.abstractfactory.carsfactory.ToyotaFactory;

public class Main {
    public static void main(String[] args) {
        CarsFactry toyotaFactory = new ToyotaFactory();
        CarsFactry fordFactory = new FordFactory();
        var car1 = toyotaFactory.createCoupe();
        car1.getMeet();
        var car2 = fordFactory.createCoupe();
        car2.getMeet();
        var car3 = toyotaFactory.creatSedan();
        car3.getMeeting();

    }
}