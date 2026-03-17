package org.example.payment;

public class PaymentProcessor {

    private PaymentStrategy strategy;

    public String processPayment(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("error - pick type of payment");
        }
        return strategy.pay(amount);
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}