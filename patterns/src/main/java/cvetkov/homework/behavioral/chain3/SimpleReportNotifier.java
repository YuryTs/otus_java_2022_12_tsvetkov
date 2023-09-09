package cvetkov.homework.behavioral.chain3;

public class SimpleReportNotifier extends Notifiere{
    public SimpleReportNotifier(int priority) {
        super(priority);
    }

    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report: " + message);

    }
}
