package org.example.payment;

public class ApplePayPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "pay with apple pay" + " " + amount + "₸";
    }
}