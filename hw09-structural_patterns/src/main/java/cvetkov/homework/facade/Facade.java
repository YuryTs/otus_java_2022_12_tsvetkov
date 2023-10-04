package cvetkov.homework.facade;

public class Facade {
    private final PushNotification pushNotification;
    private final SMSNotification smsNotification;

    public Facade(PushNotification pushNotification, SMSNotification smsNotification) {
        this.pushNotification = pushNotification;
        this.smsNotification = smsNotification;
    }

    public void simpleNotify(){
        pushNotification.sendPushNotification();
        smsNotification.sendSMSNotification();
    }
}
