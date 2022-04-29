package edu.apcs.unit9.superClassWarmup;

public class Pen extends WritingUtensil {
    // private boolean isClicked;

    public Pen(boolean isErasable, int amountInkOrLead, boolean isClicked) {
        super(isErasable, amountInkOrLead);
        // this.isClicked = isClicked;
    }

    public void click() {
        System.out.println("Click!");
    }
}
