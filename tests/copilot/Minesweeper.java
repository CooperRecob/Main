package tests.copilot;

public class Minesweeper {
    //create and all in one game of basic minesweeper
    public static void main(String[] args) {
        //create board
        int[][] board = new int[10][10];
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }

        System.out.println(board);
    }

    //create hit method
    public static void hit() {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }

    //create stay method
    public static void stay() {
        //create random number
        int random = (int) (Math.random() * 2);
        //if random number is 0
        if (random == 0) {
            //hit
            hit();
        }
        //if random number is 1
        else if (random == 1) {
            //stay
            stay();
        }
    }
}
