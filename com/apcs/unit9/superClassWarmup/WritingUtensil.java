package com.apcs.unit9.superClassWarmup;

public class WritingUtensil {
    //private String brand;
    //private boolean isErasable;
    private int amountInkOrLead;

    public WritingUtensil(boolean isErasable, int amountInkOrLead) {
        //this.isErasable = isErasable;
        this.amountInkOrLead = amountInkOrLead;
    }

    public void write(String text) {
        if(amountInkOrLead > 1) {
            System.out.println("The writing utensil wrote " + text);
        } else {
            System.out.println("The writing utensil is out of ink/lead");
        }
    }

    public int getAmountInkOrLead() {
        return amountInkOrLead;
    }

    public void setAmountInkOrLead(int amountInkOrLead) {
        this.amountInkOrLead = amountInkOrLead;
    }
}
