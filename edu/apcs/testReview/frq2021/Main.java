package edu.apcs.testReview.frq2021;

public class Main {
    public static void main(String[] args) {
        SingleTable t1 = new SingleTable(4, 74, 60);
        SingleTable t2 = new SingleTable(8, 74, 70);
        SingleTable t3 = new SingleTable(12, 76, 75);

        CombinedTable c1 = new CombinedTable(t1, t2);
        System.out.println(c1.canSeat(9));
        System.out.println(c1.canSeat(11));
        System.out.println(c1.getDesirablity());
        CombinedTable c2 = new CombinedTable(t2, t3);
        System.out.println(c2.canSeat(18));
        System.out.println(c2.getDesirablity());
        t2.setViewQuality(80);
        System.out.println(c2.getDesirablity());

        int[][] arr = {{2, 1, 0},
                       {1, 3, 2},
                       {0, 0, 0},
                       {4, 5, 6}};
        int[][] smaller = ArrayResizer.resize(arr);

        for (int i = 0; i < smaller.length; i++) {
            for (int j = 0; j < smaller[i].length; j++) {
                System.out.print(smaller[i][j] + " ");
            }
            System.out.println();
        }
    }
}
