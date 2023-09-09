package cvetkov.homework.behavioral.command2;

import java.util.ArrayDeque;
import java.util.Queue;

class Executor { //класс содержащий наш объект и список комманд (список м.б. не обязательно очередь)
    private final SomeObject object; //сам объект
    private final Queue<Command> commands = new ArrayDeque<>(); //список команд

    public Executor(SomeObject object) {
        this.object = object;
    }

    void addCommand(Command command) {
        commands.add(command);
    }

    void executeCommands() {
        Command command;
        while ((command = commands.poll()) != null) { //.pool Извлекает и удаляет первого с головы этой очереди или возвращает значение NULL, если эта очередь пуста.
            var result = command.execute(object);
            System.out.println("command execution result:" + result);
        }
    }
}
