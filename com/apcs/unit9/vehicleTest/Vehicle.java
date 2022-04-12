package com.apcs.unit9.vehicleTest;

public class Vehicle {
    private String color;
    private int numWheels;

    public Vehicle(String color, int numWheels) {
        this.color = color;
        this.numWheels = numWheels;
    }

    public void Drive() {
        System.out.println("Driving a " + color + " vehicle with " + numWheels + " wheels.");
    }
}
