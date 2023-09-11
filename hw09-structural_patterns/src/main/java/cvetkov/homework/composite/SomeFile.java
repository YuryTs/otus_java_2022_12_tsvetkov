package cvetkov.homework.composite;

public class SomeFile implements Resource{
    @Override
    public void open() {
        System.out.println("File opened");
    }
}
