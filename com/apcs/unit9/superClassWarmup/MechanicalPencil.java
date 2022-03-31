package com.apcs.unit9.superClassWarmup;

public class MechanicalPencil extends Pencil {
    //private double cost;

    public MechanicalPencil(boolean isErasable, int amountInkOrLead, boolean isNum2, double cost) {
        super(isErasable, amountInkOrLead, isNum2);
        //this.cost = cost;
    }

    public void refilLead(int peices) {
        if(peices > 0) {
            setAmountInkOrLead(getAmountInkOrLead() + peices);
            System.out.println("The mechanical pencil refilled " + peices + " peices of lead");
        } else {
            System.out.println("You didn't put any in");
        }
    }
}