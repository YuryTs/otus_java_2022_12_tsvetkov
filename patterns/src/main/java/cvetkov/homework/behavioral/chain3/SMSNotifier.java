package cvetkov.homework.behavioral.chain3;

public class SMSNotifier extends Notifiere{
    public SMSNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Sending SMS to manager: " + message);
    }
}
