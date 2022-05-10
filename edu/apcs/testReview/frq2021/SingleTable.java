package edu.apcs.testReview.frq2021;

public class SingleTable {
    private int numSeats;
    private int hight;
    private double viewQuality;

    public SingleTable(int numSeats, int hight, double viewQuality) {
        this.numSeats = numSeats;
        this.hight = hight;
        this.viewQuality = viewQuality;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public int getHight() {
        return hight;
    }

    public double getViewQuality() {
        return viewQuality;
    }

    public void setViewQuality(double value) {
        viewQuality = value;
    }
}
