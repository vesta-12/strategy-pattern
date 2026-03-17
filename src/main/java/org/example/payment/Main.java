package org.example.payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();
        int amount = 12600;
        System.out.println("total amount is: " + amount + "₸");
        System.out.println("\npick payment method:");
        System.out.println("1. credit card");
        System.out.println("2. paypal");
        System.out.println("3. crypto");
        System.out.println("4. apple pay");
        System.out.print("your choice? ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                processor.setStrategy(new CreditCardPayment());
                break;
            case 2:
                processor.setStrategy(new PayPalPayment());
                break;
            case 3:
                processor.setStrategy(new CryptoPayment());
                break;
            case 4:
                processor.setStrategy(new ApplePayPayment());
                break;
            default:
                System.out.println("error");
                scanner.close();
                return;
        }

        String result = processor.processPayment(amount);

        System.out.println("\npayment result:");
        System.out.println(result);

        scanner.close();
    }
}