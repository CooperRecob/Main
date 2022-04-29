package edu.apcs.testReview;

public class GameSpinner {
    public static void main(String[] args) {
        GameSpinner spinner = new GameSpinner(4);
        while(spinner.currentRun() != 4) {
            System.out.println(spinner.spin());
            System.out.println(spinner.currentRun());
        }
    }

    //This question involves the creation and use of a spinner to generate random numbers in a game. A GameSpinner object represents a spinner with a given number of sectors, all equal in size. The GameSpinner class supports the following behaviors.

    //Creating a new spinner with a specified number of sectors
    //Spinning a spinner and reporting the result
    //Reporting the length of the current run, the number of consecutive spins that are the same as the most recent spin

    private int sector;
    private int runCount;
    private int lastSpin;

    public GameSpinner(int sectors) {
        sector = sectors;
        runCount = 0;
    }

    public int spin() {
        int spin = (int) (Math.random() * sector) + 1;
        if (spin == lastSpin) {
            runCount++;
        } else {
            runCount = 0;
        }
        lastSpin = spin;
        return spin;
    }

    public int currentRun() {
        return runCount;
    }
}
