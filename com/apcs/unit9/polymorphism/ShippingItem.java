package com.apcs.unit9.polymorphism;

public class ShippingItem {
    private double weight;
    private static double COST_PER_OZ = 1.5;

    public ShippingItem(double weight) {
        this.weight = weight;
    }

    public double getCost() {
        return weight * COST_PER_OZ;
    }
}
