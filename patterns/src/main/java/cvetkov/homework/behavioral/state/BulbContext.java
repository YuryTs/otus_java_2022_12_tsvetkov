package cvetkov.homework.behavioral.state;

class BulbContext { //класс который хранит в себе текущее состояние

    private State state = StateProvider.getOffState(); //в поле сразу задается состояние вызовом СтейтПровайдером

    void performAction() { //это и есть тот переключатель который вызывает изменение состояния
        this.setState(state.action()); // у класса реализующего интерфейс вызывается action и в зависимости какой стейт выл вызван произойдет вкл или выкл
    }

    private void setState(State state) {
        this.state = state;
    }
}
