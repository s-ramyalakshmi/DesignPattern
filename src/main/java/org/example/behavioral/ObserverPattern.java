package org.example.behavioral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//Observer is a behavioral design pattern that lets you define a subscription mechanism
// to notify multiple objects about any events that happen to the object they’re observing.
public class ObserverPattern {
    public ObserverPattern() {
    }

    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.0F);
        Observer investor1 = new Investor("ramya");
        Observer investor2 = new Investor("krithika");
        appleStock.addObserver(investor1);
        appleStock.addObserver(investor2);
        appleStock.updatePrice(155.0F);
    }

    public static class Investor implements Observer {
        private String name;

        public Investor(String name) {
            this.name = name;
        }

        public void update(Subject subject, String message) {
            System.out.println("Investor : " + this.name + ", received update : " + message);
        }
    }

    public interface Observer {
        void update(Subject var1, String var2);
    }

    public static class Stock implements Subject {
        private List<Observer> observers;
        private String stockSymbol;
        private float stockPrice;

        public Stock(String stockSymbol, float stockPrice) {
            this.stockSymbol = stockSymbol;
            this.stockPrice = stockPrice;
            this.observers = new ArrayList();
        }

        public void addObserver(Observer observer) {
            this.observers.add(observer);
        }

        public void removeObserver(Observer observer) {
            this.observers.remove(observer);
        }

        public void notifyObservers() {
            String message = "Stock : " + this.stockSymbol + " Price : " + this.stockPrice;
            Iterator var2 = this.observers.iterator();

            while(var2.hasNext()) {
                Observer observer = (Observer)var2.next();
                observer.update(this, message);
            }

        }

        public void updatePrice(float price) {
            this.stockPrice = price;
            this.notifyObservers();
        }
    }

    public interface Subject {
        void addObserver(Observer var1);

        void removeObserver(Observer var1);

        void notifyObservers();
    }
}