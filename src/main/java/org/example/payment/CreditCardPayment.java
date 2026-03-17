package org.example.payment;

public class CreditCardPayment implements PaymentStrategy {

    @Override
    public String pay(int amount) {
        return "pay with credit card" + " " + amount + "₸";
    }
}