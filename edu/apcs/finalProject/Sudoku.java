package edu.apcs.finalProject;

import java.util.Scanner;

public class Sudoku {
    private static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean win = false;

        initializeBoard(.9);
        printBoard();

        while (!win) {
            System.out.println("Enter a row and column to change: ");
            int row = input.nextInt();
            System.out.println();
            int col = input.nextInt();
            System.out.println("Enter a number to change it to: ");
            int num = input.nextInt();

            board[row][col] = num;
            printBoard();

            if(boardCheck()) {
                boolean boardCheck = true;

                for(int i = 0; i < 9; i++) {
                    for(int j = 0; j < 9; j++) {
                        if(board[i][j] == 0) {
                            boardCheck = false;
                        }
                    }
                }
                
                if(boardCheck) {
                    win = true;
                    System.out.println("You win!");
                }
            }
        }
        input.close();
    }

    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.print("------+-------+------");
                System.out.println();
            }
            for (int j = 0; j < board[i].length; j++) {
                if(j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeBoard(double difficulty) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(Math.random() > difficulty) {
                    board[i][j] = 0;
                } else {
                    int randomValue = (int) (Math.random() * 9) + 1;
                    while (true) {
                        randomValue = (int) (Math.random() * 9) + 1;
                        System.out.println("fail");
                        if (columnCheck(j, randomValue) && rowCheck(i, randomValue)) {
                            if (boxCheck(i, j, randomValue)) {
                                break;
                            }
                        }
                    }
                    board[i][j] = randomValue;
                }
            }
        }
    }

    public static boolean boardCheck() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!rowCheck(i, board[i][j]) || !columnCheck(j, board[i][j]) || !boxCheck(i, j, board[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean rowCheck(int x, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean columnCheck(int y, int value) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == value) {
                return false;
            }
        }
        return true;
    }

    public static boolean boxCheck(int x, int y, int value) {
        int xStart = x - (x % 3);
        int yStart = y - (y % 3);
        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
