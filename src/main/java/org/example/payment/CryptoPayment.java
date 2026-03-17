package org.example.payment;

public class CryptoPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "pay with crypto" + " " + amount + "₸";
    }
}