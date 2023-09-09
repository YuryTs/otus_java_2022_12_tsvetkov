package cvetkov.homework.behavioral.command2;

@FunctionalInterface
public interface Command {
    String execute(SomeObject object);
}
