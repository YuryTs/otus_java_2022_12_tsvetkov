package cvetkov.homework.behavioral.strategy2;

public class Bus implements Strategy {
    @Override
    public void transportation() {
        System.out.println("доехать на автобусе");
    }
}
