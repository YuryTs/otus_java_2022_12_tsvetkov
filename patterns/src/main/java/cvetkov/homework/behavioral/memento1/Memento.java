package cvetkov.homework.behavioral.memento1;

import java.time.LocalDateTime;

record Memento(State state, LocalDateTime createdAt) { //ячейка в которую мы сохраняем
    Memento(State state, LocalDateTime createdAt) {
        this.state = new State(state);
        this.createdAt = createdAt;
    }
}
