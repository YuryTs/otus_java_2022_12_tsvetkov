package cvetkov.homework.behavioral.strategy2;

public class Taxi implements Strategy {
    @Override
    public void transportation() {
        System.out.println("доехать на такси");
    }
}
