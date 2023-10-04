package cvetkov.homework.adapter;

public class PayAdapter implements PaymentSystem{
    private final Payment payment;


    public PayAdapter(Payment payment) {
        this.payment = payment;
    }

    @Override
    public void paySmth() {
        System.out.print(this.payment);
    }
}
