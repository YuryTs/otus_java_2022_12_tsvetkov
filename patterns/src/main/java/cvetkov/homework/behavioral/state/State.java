package cvetkov.homework.behavioral.state;


public interface State { //создаем интерфейс с методом действия который возвращает состояние
    State action();
}
