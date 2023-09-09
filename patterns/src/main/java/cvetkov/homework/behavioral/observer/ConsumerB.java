package cvetkov.homework.behavioral.observer;

public class ConsumerB {

    /*
     * Большой и жирный класс со множеством полей
     *
     */

    //может в себе другого листнера хранить
    private static final Listener listener = data -> System.out.println("ConsumerB data:" + data);


    public Listener getListener() {
        return listener;
    }
}
