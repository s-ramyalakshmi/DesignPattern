package org.example.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Strategy is a behavioral design pattern that lets you define a family of algorithms,
// put each of them into a separate class, and make their objects interchangeable.
public class StrategyPattern {
    public StrategyPattern() {
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("item1", 120.0));
        cart.addItem(new Item("item2", 100.0));
        cart.pay(new CreditCardStrategy("Ramya", "12345", "11/25", "123"));
        cart.pay(new PayPalStrategy("ramya@gmail.com", "12345"));
    }

    public static class ShoppingCart {
        List<Item> items = new ArrayList();

        public ShoppingCart() {
        }

        public void addItem(Item item) {
            this.items.add(item);
        }

        public void removeItem(Item item) {
            this.items.remove(item);
        }

        public double calculateTotal() {
            double total = 0.0;

            Item item;
            for(Iterator var3 = this.items.iterator(); var3.hasNext(); total += item.getPrice()) {
                item = (Item)var3.next();
            }

            return total;
        }

        public void pay(PaymentStrategy paymentStrategy) {
            double amount = this.calculateTotal();
            paymentStrategy.pay(amount);
        }
    }

    public static class Item {
        private String code;
        private double price;

        public Item(String code, double price) {
            this.code = code;
            this.price = price;
        }

        public double getPrice() {
            return this.price;
        }
    }

    public static class PayPalStrategy implements PaymentStrategy {
        private String emailId;
        private String password;

        public PayPalStrategy(String emailId, String password) {
            this.emailId = emailId;
            this.password = password;
        }

        public void pay(double amount) {
            System.out.println("$" + amount + " paid successfully with Paypal");
        }
    }

    public static class CreditCardStrategy implements PaymentStrategy {
        private String name;
        private String cardNumber;
        private String dateOfExpiry;
        private String cvv;

        public CreditCardStrategy(String name, String cardNumber, String dateOfExpiry, String cvv) {
            this.name = name;
            this.cardNumber = cardNumber;
            this.dateOfExpiry = dateOfExpiry;
            this.cvv = cvv;
        }

        public void pay(double amount) {
            System.out.println("$" + amount + " paid successfully with debit/credit card");
        }
    }

    public interface PaymentStrategy {
        void pay(double var1);
    }
}
