package cvetkov.homework.behavioral.state;

public class OnState implements State { //создаем конкретные классы реализуюшие интерфейс
    @Override
    public State action() {
        System.out.println("лампа светит");
        return StateProvider.getOffState(); //вызывает у провайдера метод изменения состояния объекта
    }
}
