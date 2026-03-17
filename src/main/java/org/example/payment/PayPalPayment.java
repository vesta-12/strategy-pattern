package org.example.payment;

public class PayPalPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "pay with paypal" + " " + amount + "₸";
    }
}