package com.apcs.unit9.vehicleTest;

public class Van extends Car {
    private int seats;

    public Van(String color, String manufacturer, int seats) {
        super(color, 4, manufacturer);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void Drive() {
        System.out.println("Driving a " + getManufacturer() + " van with " + seats + " seats.");
    }
}
