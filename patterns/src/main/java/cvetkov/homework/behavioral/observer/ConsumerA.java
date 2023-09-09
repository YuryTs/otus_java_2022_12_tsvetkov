package cvetkov.homework.behavioral.observer;

public class ConsumerA implements Listener { //слушатель (или подписчик)

    @Override
    public void onUpdate(String data) { //его единственный метод
        System.out.println("ConsumerA data:" + data);
    }
}
