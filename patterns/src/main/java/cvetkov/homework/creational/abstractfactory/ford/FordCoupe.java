package cvetkov.homework.creational.abstractfactory.ford;

import cvetkov.homework.creational.abstractfactory.Coupe;

public class FordCoupe implements Coupe {
    @Override
    public void getMeet() {
        System.out.println("FordCoupe создан!");
    }
}
