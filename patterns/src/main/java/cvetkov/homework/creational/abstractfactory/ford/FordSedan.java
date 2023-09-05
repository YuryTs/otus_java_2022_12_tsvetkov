package cvetkov.homework.creational.abstractfactory.ford;

import cvetkov.homework.creational.abstractfactory.Sedan;

public class FordSedan implements Sedan {
    @Override
    public void getMeeting() {
        System.out.println("FordSedan создан!");
    }
}
