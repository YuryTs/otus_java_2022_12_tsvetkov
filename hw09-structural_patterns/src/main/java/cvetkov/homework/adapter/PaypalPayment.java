package cvetkov.homework.adapter;

public class PaypalPayment {
    public void pay(PaymentSystem paymentSystem){

        paymentSystem.paySmth();
        System.out.println("\'used PayPal\'");
    }
}
