package com.apcs.unit9.polymorphism;

public class InsuredShippingItem extends ShippingItem {
    private double insuranceCost;

    public InsuredShippingItem(double weight, double insuranceCost) {
        super(weight);
        this.insuranceCost = insuranceCost;
    }

    public double getCost() {
        return super.getCost() + insuranceCost;
    }
}