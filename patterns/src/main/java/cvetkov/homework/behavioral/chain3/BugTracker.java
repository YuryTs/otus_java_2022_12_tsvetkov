package cvetkov.homework.behavioral.chain3;

public class BugTracker { //клиентский класс
    public static void main(String[] args) {

        Notifiere reportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifiere emailNotifier = new EmailNotifier(Priority.IMPORTANT);
        Notifiere smsNotifier = new SMSNotifier(Priority.ASAP);

        reportNotifier.setNextNotifier(emailNotifier);
        emailNotifier.setNextNotifier(smsNotifier);

        reportNotifier.notifyManager("Everything is OK", Priority.ROUTINE);
        reportNotifier.notifyManager("Something is WRONG", Priority.IMPORTANT);
        reportNotifier.notifyManager("Huston we have a problem", Priority.ASAP);

    }
}
