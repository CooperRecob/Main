package edu.apcs.unit9.vehicleTest;

public class Car extends Vehicle {
    private String manufacturer;

    public Car(String color, int numWheels, String manufacturer) {
        super(color, 4);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void Drive() {
        System.out.println("Driving a " + manufacturer + " car");
    }
}
