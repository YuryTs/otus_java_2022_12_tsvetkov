package cvetkov.homework.publisher_subscriber.listeners;


import cvetkov.homework.publisher_subscriber.Event;
import cvetkov.homework.publisher_subscriber.EventListener;

public class DeleteListener implements EventListener {
    @Override
    public void accept(Event event) {
        Sleeper.sleep(2000);
        System.out.println("Deleted " + event.getObject());
    }
}
