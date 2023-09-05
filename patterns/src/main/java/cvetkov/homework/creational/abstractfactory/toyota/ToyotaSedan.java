package cvetkov.homework.creational.abstractfactory.toyota;

import cvetkov.homework.creational.abstractfactory.Sedan;

public class ToyotaSedan implements Sedan {
    @Override
    public void getMeeting() {
        System.out.println("ToyotaSedan создан!");
    }
}
