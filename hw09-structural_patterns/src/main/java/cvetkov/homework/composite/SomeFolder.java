package cvetkov.homework.composite;

public class SomeFolder implements Resource{
    @Override
    public void open() {
        System.out.println("Folder opened");
    }
}
