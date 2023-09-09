package cvetkov.homework.behavioral.chain3;

public class EmailNotifier extends Notifiere{
    public EmailNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending email: " + message);
    }
}
