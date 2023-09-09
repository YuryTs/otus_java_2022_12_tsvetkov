package cvetkov.homework.behavioral.command2;

public class Echo implements Command {
    @Override
    public String execute(SomeObject object) {
        return object.getValue();
    }
}
