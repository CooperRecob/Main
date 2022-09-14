package com.projects.battleship;

public class Main {
    public static void main(String[] args) {
        Ship ship1 = new Ship(3, 4);
        Ship ship2 = new Ship(4, 7);
        Ship ship3 = new Ship(6, 2);

        Board board1 = new Board(ship1, ship2, ship3);
        Board board2 = new Board(new Ship(5, 2), new Ship(6, 4), new Ship(7, 3));

        int turns = 0;
        while (true) {
            int x1 = (int) (Math.random() * 8);
            int x2 = (int) (Math.random() * 8);
            int y1 = (int) (Math.random() * 8);
            int y2 = (int) (Math.random() * 8);

            board2.shot(x1, y1);
            if (board2.hitCount() == 3) {
                System.out.println("Player 1 Wins!!!");
                System.out.println("It took " + turns + " turns");
                break;
            }

            board1.shot(x2, y2);
            if (board1.hitCount() == 3) {
                System.out.println("Player 2 Wins!!");
                System.out.println("It took " + turns + " turns");
                break;
            }
            turns++;
        }
    }
}
