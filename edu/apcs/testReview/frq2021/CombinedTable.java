package edu.apcs.testReview.frq2021;

public class CombinedTable {
    private SingleTable table1;
    private SingleTable table2;
    private int numSeats;

    public CombinedTable(SingleTable table1, SingleTable table2) {
        this.table1 = table1;
        this.table2 = table2;

        numSeats = table1.getNumSeats() + table2.getNumSeats() - 2;
    }

    public boolean canSeat(int count) {
        if(count <= numSeats){
            return true;
        } else{
            return false;
        }
    }

    public double getDesirablity() {
        if(table1.getHight() == table2.getHight()){
            return (table1.getViewQuality() + table2.getViewQuality()) / 2;
        } else{
            return (table1.getViewQuality() + table2.getViewQuality()) / 2 - 10;
        }
    }
}
