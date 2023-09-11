package cvetkov.homework.adapter;

public class SolutionAdapter {
    public static void main(String[] args) {
        var payment = new Payment();

        var payPal = new PaypalPayment();
        var creditCar = new CreditCardPayment();


        payPal.pay(new PayAdapter(payment));
        creditCar.pay(new PayAdapter(payment));
    }
}
