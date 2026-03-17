package com.example.payment;

import org.example.payment.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorTest {

    @Test
    void processCreditCardPayment() {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setStrategy(new CreditCardPayment());

        String result = processor.processPayment(10560);

        assertEquals("pay with credit card 10560₸", result);
    }

    @Test
    void processPayPalPayment() {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setStrategy(new PayPalPayment());

        String result = processor.processPayment(150000);

        assertEquals("pay with paypal 150000₸", result);
    }

    @Test
    void processCryptoPayment() {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setStrategy(new CryptoPayment());

        String result = processor.processPayment(25000);

        assertEquals("pay with crypto 25000₸", result);
    }

    @Test
    void switchStrategiesAtRuntime() {
        PaymentProcessor processor = new PaymentProcessor();

        processor.setStrategy(new CreditCardPayment());
        String firstResult = processor.processPayment(10000);

        processor.setStrategy(new PayPalPayment());
        String secondResult = processor.processPayment(12000);

        assertEquals("pay with credit card 10000₸", firstResult);
        assertEquals("pay with paypal 12000₸", secondResult);
        assertNotEquals(firstResult, secondResult);
    }

    @Test
    void throwExceptionWhenStrategyIsNotSet() {
        PaymentProcessor processor = new PaymentProcessor();

        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> processor.processPayment(8600)
        );

        assertEquals("error - pick type of payment", exception.getMessage());
    }

    @Test
    void processApplePayPayment() {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setStrategy(new ApplePayPayment());

        String result = processor.processPayment(5780);

        assertEquals("pay with apple pay 5780₸", result);
    }
}