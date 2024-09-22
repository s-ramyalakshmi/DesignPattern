package org.example.structural;
//Decorator is a structural design pattern that lets you attach new behaviors
// to objects by placing these objects inside special wrapper objects that contain the behaviors.
public class DecoratorPattern {
    public static interface Car {
        void assemble();
    }

    public static class BasicCar implements Car {
        @Override
        public void assemble() {
            System.out.println("Basic Car");
        }
    }

    public static class CarDecorator implements Car {
        protected Car car;
        public CarDecorator(Car car) {
            this.car = car;
        }

        @Override
        public void assemble() {
            this.car.assemble();
        }
    }

    public static class SportsCar extends CarDecorator {
        public SportsCar(Car car) {
            super(car);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.println("Sports Car");
        }
    }

    public static class LuxuryCar extends CarDecorator {
        public LuxuryCar(Car car) {
            super(car);
        }

        @Override
        public void assemble() {
            super.assemble();
            System.out.println("Luxury Car");
        }
    }

    public static void main(String[] args) {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();

        Car luxuryCar = new LuxuryCar(new BasicCar());
        luxuryCar.assemble();
    }
}
