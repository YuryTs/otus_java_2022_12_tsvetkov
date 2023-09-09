package cvetkov.homework.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

class EventProducer { //тот который генерирует события

    public List<Listener> getListeners() {
        return listeners;
    }

    private final List<Listener> listeners = new ArrayList<>(); //у него есть список всех слушателей

    void addListener(Listener listener) {
        listeners.add(listener);
    } //может добавлять слушателей

    void removeListener(Listener listener) {
        listeners.remove(listener);
    } //может удалять слушателей

    void event(String data) { //пораждает события для всех слушателей в списке
        listeners.forEach(listener -> {
            try {
                listener.onUpdate(data);
            } catch (Exception ex) {
                //логирование исключения
            }
        });
    }
}
