package edu.project.chess;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Peice[][] board = new Peice[8][8];
        initializeBoard(board);
        boolean p1moved = false;
        boolean p2moved = true;

        // game loop with scanners while each team has more than 0 peices
        while (checkBoard(board, true) && checkBoard(board, false)) {
            printBoard(board);

            while (!p1moved && p2moved) {
                // player 1 turn
                System.out.println("Player 1, what peice would you like to move? \nx:");
                int x = input.nextInt();
                System.out.println("y:");
                int y = input.nextInt();

                System.out.println("Where would you like to move it?\nx:");
                int x2 = input.nextInt();
                System.out.println("y:");
                int y2 = input.nextInt();

                Cordinate initPos = new Cordinate(y - 1, x - 1);
                Cordinate newPos = new Cordinate(y2 - 1, x2 - 1);
                System.out.println(board[initPos.x()][initPos.y()].getName() + " " + board[initPos.x()][initPos.y()].getTeam());

                if (checkVailidity(board, initPos, newPos, true)) {
                    p1moved = true;
                    p2moved = false;
                    board = move(board, initPos, newPos);
                } else {
                    System.out.println("Invalid move");
                    System.out.println(checkVailidity(board, initPos, newPos, true));
                    break;
                }
            }

            printBoard(board);

            while (!p2moved && p1moved) {
                // player 2 turn
                System.out.println("Player 2, what peice would you like to move? \nx:");
                int x = input.nextInt();
                System.out.println("y:");
                int y = input.nextInt();

                System.out.println("Where would you like to move it?\nx:");
                int x2 = input.nextInt();
                System.out.println("y:");
                int y2 = input.nextInt();

                Cordinate initPos = new Cordinate(x - 1, y - 1);
                Cordinate newPos = new Cordinate(x2 - 1, y2 - 1);

                if (checkVailidity(board, initPos, newPos, false)) {
                    p1moved = false;
                    p2moved = true;
                    board = move(board, initPos, newPos);
                } else {
                    System.out.println("Invalid move");
                    System.out.println(checkVailidity(board, initPos, newPos, false));
                    break;
                }
            }
        }
        input.close();
    }

    public static Peice[][] move(Peice[][] board, Cordinate initPos, Cordinate newPos) {
        // moves a peice from oldX, oldY to newX, newY
        // move the peice
        // if the move is upon an enemy peice, capture it
        // store the move in a txt file
        // return the board with the new move

        // write the move to a txt file
        /*
         * With the exception of the knight, each piece is represented by the first
         * letter of its name, capitalised. Knight starts with the same letter as king,
         * so for the knights we use the letter N instead. When we record a move, we
         * record the piece that is being moved, and the square that the piece is being
         * moved to. For example:
         * 
         * Bc4 - Bishop moves to the c4 square.
         * Nf3 - Knight moves to the f3 square.
         * Qc7 - Queen moves to the c7 square.
         * The only exception to this is pawn moves. When a pawn moves, we don't
         * normally bother to record the P, just the square that the pawn is moving to.
         * For example:
         * 
         * e4 - pawn moves to the e4 square.
         * g6 - pawn moves to the g6 square.
         * If the pawn has reached the far side of the board and promoted, use an '='
         * sign to show which piece it was promoted to. For example:
         * 
         * b8=Q - pawn moves to the b8 square and promotes to a queen.
         * h1=N - pawn moves to the h1 square and promotes to a knight.
         * Simple enough so far. There are also a couple of extra symbols used to
         * indicate certain things about a move. To indicate a capture, we place an 'x'
         * symbol beween the piece and the square, for example:
         * 
         * Rxf5 - Rook captures a piece on the f5 square.
         * Kxd2 - King captures a piece on the d2 square.
         * When a pawn is capturing, we use the letter of the file it is moving from,
         * then the x, then the square it is moving to. For example:
         * 
         * gxf6 - Pawn on the g-file captures a piece on the f6 square.
         * exd5 - Pawn on the e-file captures a piece on the d5 square.
         * If the pawn is making an en passant capture, we record the square that the
         * pawn finished on, not the square of the captured pawn. You can also add
         * 'e.p.' after the move to indicate en passant if you want, but this isn't
         * mandatory. For example:
         * 
         * exd6 - Pawn captures a pawn on d5 en passant. The pawn finishes its move on
         * d6.
         * gxh6 e.p. - Pawn captures a pawn on h5 en passant. The pawn finishes its move
         * on h6.
         * To indicate that a move is check, just add a '+' symbol on the end. If it's a
         * double check, you can add ++ if you like, but just one will do. If the it's a
         * checkmate, use the '#' symbol instead. Here are some examples:
         * 
         * Ba3+ - Bishop moves to a3 and gives check.
         * Qxh7# - Queen captures a piece on h7 and checkmates the black king.
         * f3+ - Pawn moves to f3 and gives check.
         */

        String str = "";
        if (board[initPos.x()][initPos.y()].getName().equals("Knight")) {
            str = "N";
        } else if (!board[initPos.x()][initPos.y()].getName().equals("Pawn")) {
            str = board[initPos.x()][initPos.y()].getName().substring(0, 1);
        }

        str += (char) newPos.x();
        if (newPos.y() == 0) {
            str += "1";
        }
        if (newPos.y() == 1) {
            str += "2";
        }
        if (newPos.y() == 2) {
            str += "3";
        }
        if (newPos.y() == 3) {
            str += "4";
        }
        if (newPos.y() == 4) {
            str += "5";
        }
        if (newPos.y() == 5) {
            str += "6";
        }
        if (newPos.y() == 6) {
            str += "7";
        }
        if (newPos.y() == 7) {
            str += "8";
        }

        try {
            FileWriter writer = new FileWriter("edu/apcs/finalProject/moveHistory.txt");
            writer.write(str);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        board[newPos.x()][newPos.y()] = board[initPos.x()][initPos.y()];
        board[initPos.x()][initPos.y()] = null;
        return board;
    }

    public static boolean checkVailidity(Peice[][] board, Cordinate initPos, Cordinate newPos, boolean team) {
        // checks if the move is valid
        // checks that there is not peices in the path of the move
        // exception to this rule is the knight which can hop over pieces
        // if the move is a capture then it is valid
        // pawns (peicenum 0) can move two spaces if they are on the starting row
        // pawns can capture diagonally
        // pawns can move forward if they are not on the starting row
        // rooks (peicenum 1) can move horizontally and vertically
        // bishops (peicenum 3) can move diagonally
        // queens (peicenum 4) can move diagonally and horizontally and vertically
        // kings (peicenum 5) can move one space in any direction
        // kights (peicenum 2) move in an L shape
        // if the move is a capture, the peice being captured must be an enemy peice
        // if the move is invalid, print the reason why it is invalid and return false
        // if the move is valid, return true

        int peiceNum = board[initPos.x()][initPos.y()].getPeiceNum();

        if (initPos.x() == newPos.x() && initPos.y() == newPos.y()) {
            System.out.println("You can't move to the same square");
            return false;
        }

        if (peiceNum == 0) {}
        return true;
    }

    public static boolean checkBoard(Peice[][] board, boolean team) {
        // checks to make sure the entire team isn't dead
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j].getTeam() == team) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void printBoard(Peice[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == null) {
                    System.out.print("-- ");
                } else {
                    if (board[i][j].getTeam()) {
                        System.out.print("W");
                    } else {
                        System.out.print("B");
                    }
                    System.out.print(board[i][j].getPeiceNum() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void initializeBoard(Peice[][] board) {
        // creates a default chess board where white peices team is true and black
        // peices team is false
        // pawns are represented by 0, rooks are represented by 1, knights are
        // represented by 2, bishops are represented by 3, queens are represented by 4,
        // kings are represented by 5

        // initialize pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Peice(false, "Pawn", 0);
            board[6][i] = new Peice(true, "Pawn", 0);
        }

        // initialize rooks
        board[0][0] = new Peice(false, "Rook", 1);
        board[0][7] = new Peice(false, "Rook", 1);
        board[7][0] = new Peice(true, "Rook", 1);
        board[7][7] = new Peice(true, "Rook", 1);

        // initialize knights
        board[0][1] = new Peice(false, "Knight", 2);
        board[0][6] = new Peice(false, "Knight", 2);
        board[7][1] = new Peice(true, "Knight", 2);
        board[7][6] = new Peice(true, "Knight", 2);

        // initialize bishops
        board[0][2] = new Peice(false, "Bishop", 3);
        board[0][5] = new Peice(false, "Bishop", 3);
        board[7][2] = new Peice(true, "Bishop", 3);
        board[7][5] = new Peice(true, "Bishop", 3);

        // initialize queens
        board[0][4] = new Peice(false, "Queen", 4);
        board[7][3] = new Peice(true, "Queen", 4);

        // initialize kings
        board[0][3] = new Peice(false, "King", 5);
        board[7][4] = new Peice(true, "King", 5);
    }
}
