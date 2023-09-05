package cvetkov.homework.creational.abstractfactory.toyota;

import cvetkov.homework.creational.abstractfactory.Coupe;

public class ToyotaCoupe implements Coupe {
    @Override
    public void getMeet() {
        System.out.println("ToyotaCoupe создан!");
    }
}
