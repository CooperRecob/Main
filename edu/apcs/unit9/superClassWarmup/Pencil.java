package edu.apcs.unit9.superClassWarmup;

public class Pencil extends WritingUtensil {
    // private boolean isNum2;

    public Pencil(boolean isErasable, int amountInkOrLead, boolean isNum2) {
        super(isErasable, amountInkOrLead);
        // this.isNum2 = isNum2;
    }

    public void drawAmongUs() {
        if (getAmountInkOrLead() > 1) {
            System.out.println("ඞ");
        } else {
            System.out.println("The pencil is out of ink/lead");
        }
    }
}
