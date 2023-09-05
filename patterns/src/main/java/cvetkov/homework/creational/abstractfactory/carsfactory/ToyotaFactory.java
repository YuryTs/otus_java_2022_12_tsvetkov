package cvetkov.homework.creational.abstractfactory.carsfactory;

import cvetkov.homework.creational.abstractfactory.Coupe;
import cvetkov.homework.creational.abstractfactory.Sedan;
import cvetkov.homework.creational.abstractfactory.toyota.ToyotaCoupe;
import cvetkov.homework.creational.abstractfactory.toyota.ToyotaSedan;

public class ToyotaFactory implements CarsFactry {//создаем конкректный класс-фактори для создания разных типов данной марки
    @Override
    public Sedan creatSedan() {
        return new ToyotaSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new ToyotaCoupe();
    }
}
