package com.project.battleship;

public class Main {
    public static void main(String[] args) {
        Ship ship1 = new Ship(3, 4);
        Ship ship2 = new Ship(4, 7);
        Ship ship3 = new Ship(6, 2);

        Board board = new Board(ship1, ship2, ship3);
    }
}
