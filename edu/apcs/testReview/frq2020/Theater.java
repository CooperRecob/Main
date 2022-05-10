package edu.apcs.testReview.frq2020;

public class Theater {
    private Seat[][] theaterSeats;

    /**
     * Constructs a Theater object, as described in part (a).
     * 
     * Precondition: seatsPerRow > 0; tier1Rows > 0; tier2Rows >= 0
     * 
     */

    public Theater(int seatsPerRow, int tier1Rows, int tier2Rows) {
        theaterSeats = new Seat[tier1Rows + tier2Rows][seatsPerRow];
        for (int i = 0; i < tier1Rows + tier2Rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                theaterSeats[i][j] = new Seat(true, i + 1);
            }
        }
    }

    /**
     * Returns true if a seat holder was reassigned from the seat at fromRow,
     * fromCol
     * 
     * to the seat at toRow, toCol; otherwise it returns false, as described in part
     * (b).
     * 
     * Precondition: fromRow, fromCol, toRow, and toCol represent valid row and
     * 
     * column positions in the theater.
     * 
     * The seat at fromRow, fromCol is not available.
     * 
     */

    public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol) {
        if (theaterSeats[fromRow - 1][fromCol - 1].isAvailable()) {
            return false;
        }
        if (theaterSeats[toRow - 1][toCol - 1].isAvailable()) {
            theaterSeats[toRow - 1][toCol - 1].setAvailability(false);
            theaterSeats[fromRow - 1][fromCol - 1].setAvailability(true);
            return true;
        }
        return false;
    }

}
