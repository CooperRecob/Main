package com.projects.minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);
        Scanner textInput = new Scanner(System.in);

        int size = 15;

        Board board = new Board(size);

        System.out.println("Where do you wanna click?");
        System.out.print("x=");
        int x = intInput.nextInt();

        if (x > size) {
            x = size - 1;
        } else if (x - 1 < 0) {
            x = 1;
        }

        System.out.print("y=");
        int y = intInput.nextInt();
        System.out.println();

        if (y > size) {
            y = size - 1;
        } else if (y - 1 < 0) {
            y = 1;
        }

        board.click(y - 1, x - 1);

        board.displayBoard();

        while (board.getGameoverStatus() != true && board.getWinStatus() != true) {
            System.out.println("What do you wanna do?");
            System.out.println("1.) Click");
            System.out.println("2.) Flag");
            System.out.println("3.) Quit");
            String input = textInput.nextLine();

            if (input.equals("1")) {
                System.out.println("Where do you wanna click?");
                System.out.print("x=");
                x = intInput.nextInt();

                if (x > size) {
                    x = size - 1;
                } else if (x - 1 < 0) {
                    x = 1;
                }

                System.out.print("y=");
                y = intInput.nextInt();
                System.out.println();

                if (y > size) {
                    y = size - 1;
                } else if (y - 1 < 0) {
                    y = 1;
                }

                board.click(y - 1, x - 1);
            } else if (input.equals("2")) {
                System.out.println("Where do you wanna flag?");
                System.out.print("x=");
                x = intInput.nextInt();
                System.out.println();

                if (x > size) {
                    x = size - 1;
                } else if (x - 1 < 0) {
                    x = 1;
                }

                System.out.print("y=");
                y = intInput.nextInt();
                System.out.println();

                if (y > size) {
                    y = size - 1;
                } else if (y - 1 < 0) {
                    y = 1;
                }

                board.flag(y - 1, x - 1);
            } else if (input.equals("3")) {
                break;
            }
            board.displayBoard();
        }

        if (board.getWinStatus() == true) {
            System.out.println("You WIN!!");
        } else if (board.getGameoverStatus() == true) {
            System.out.println("Boohoo you lost :(");
        }

        intInput.close();
        textInput.close();
    }
}
