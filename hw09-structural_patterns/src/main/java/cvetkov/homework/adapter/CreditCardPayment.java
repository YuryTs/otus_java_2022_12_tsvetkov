package cvetkov.homework.adapter;

public class CreditCardPayment {
    public void pay(PaymentSystem paymentSystem){
        paymentSystem.paySmth();
        System.out.println("\'used CreditCard\'");
    }

}
