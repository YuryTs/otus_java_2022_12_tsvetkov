package cvetkov.homework.creational.abstractfactory.carsfactory;

import cvetkov.homework.creational.abstractfactory.Coupe;
import cvetkov.homework.creational.abstractfactory.ford.FordCoupe;
import cvetkov.homework.creational.abstractfactory.ford.FordSedan;
import cvetkov.homework.creational.abstractfactory.Sedan;

public class FordFactory implements CarsFactry{ //создаем конкректный класс-фактори для создания разных типов данной марки
    @Override
    public Sedan creatSedan() {
        return new FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new FordCoupe();
    }
}
