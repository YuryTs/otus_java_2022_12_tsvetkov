package cvetkov.homework.behavioral.memento1;

import java.util.Arrays;

public class State { //создаем класс состояния
    private final String[] array;

    State(String[] array) {
        this.array = array;
    }

    State(State state) {
        //Не забывайте про "глубокую" копию
        this.array = Arrays.copyOf(state.getArray(), state.getArray().length);
    }

    String[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "State{" +
                "array=" + (array == null ? null : Arrays.asList(array)) +
                '}';
    }
}
