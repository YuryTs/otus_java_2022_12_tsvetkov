package cvetkov.homework.behavioral.strategy2;

public class Car implements Strategy {
    @Override
    public void transportation() {
        System.out.println("доехать на машине");
    }
}
