package cvetkov.homework.creational.abstractfactory.carsfactory;

import cvetkov.homework.creational.abstractfactory.Coupe;
import cvetkov.homework.creational.abstractfactory.Sedan;

public interface CarsFactry { //создается абстракная фабрика которая содержит методы создания того или иного типа
    Sedan creatSedan();
    Coupe createCoupe();

}
