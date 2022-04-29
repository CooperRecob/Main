package edu.apcs.unit9.vehicleTest;

public class MomVan extends Van {
    private int children;

    public MomVan(String color, String manufacturer, int seats, int children) {
        super(color, manufacturer, seats);
        this.children = children;
    }

    public void Drive() {
        System.out.println(
                "Driving a " + getManufacturer() + " van with " + getSeats() + " seats and " + children + " children.");
    }
}
