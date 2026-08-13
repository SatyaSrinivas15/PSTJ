package javalab;

import java.util.*;

abstract class Vehicle {
    protected double rate;

    Vehicle(double rate) {
        this.rate = rate;
    }

    abstract double calculateFare(double distance);
}

class Bike extends Vehicle {
    Bike() {
        super(5);
    }

    double calculateFare(double distance) {
        return distance * rate;
    }
}

class Auto extends Vehicle {
    Auto() {
        super(12);
    }

    double calculateFare(double distance) {
        return distance * rate;
    }
}

class Cab extends Vehicle {
    Cab() {
        super(12);
    }

    double calculateFare(double distance) {
        return distance * rate;
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    private Vehicle vehicle;
    private double distance;

    Trip(Vehicle vehicle, double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Invalid distance");
        }

        this.vehicle = vehicle;
        this.distance = distance;
    }

    double getFare() {
        return vehicle.calculateFare(distance);
    }
}

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle;

                switch (type) {
                    case "Bike":
                        vehicle = new Bike();
                        break;

                    case "Auto":
                        vehicle = new Auto();
                        break;

                    case "Cab":
                        vehicle = new Cab();
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid ride type");
                }

                Trip trip = new Trip(vehicle, distance);
                System.out.println((int) trip.getFare());

            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Booking");
            }
        }
        sc.close();
    }
}