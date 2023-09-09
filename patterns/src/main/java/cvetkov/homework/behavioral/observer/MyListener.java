package cvetkov.homework.behavioral.observer;

public class MyListener implements Listener{
    @Override
    public void onUpdate(String data) {
        System.out.println("MyListener data:" + data);
    }
}
