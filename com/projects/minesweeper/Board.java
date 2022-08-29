package com.projects.minesweeper;

public class Board {
    private int size;
    private boolean gameover;
    private boolean won;
    private int clickCount;
    private Mine[][] board;
    private String[][] boardDisplay;

    public Board(int size) {
        this.size = size;
        gameover = false;
        won = false;
        clickCount = 0;

        board = new Mine[size][size];

        for (int i = 0; i < size; i++) {
            int x = (int) (Math.random() * size);
            int y = (int) (Math.random() * size);

            if (board[x][y] == null) {
                board[x][y] = new Mine();
            }
        }

        boardDisplay = new String[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardDisplay[i][j] = ".";
            }
        }
    }

    public int getCloseMines(int x, int y) {
        int count = 0;

        // check above
        if (x > 0 && board[x - 1][y] != null) {
            count++;
        }
        // check below
        if (x < size - 1 && board[x + 1][y] != null) {
            count++;
        }
        // check left
        if (y > 0 && board[x][y - 1] != null) {
            count++;
        }
        // check right
        if (y < size - 1 && board[x][y + 1] != null) {
            count++;
        }
        // check top left
        if (x > 0 && y > 0 && board[x - 1][y - 1] != null) {
            count++;
        }
        // check top right
        if (x > 0 && y < size - 1 && board[x - 1][y + 1] != null) {
            count++;
        }
        // check bottom left
        if (x < size - 1 && y > 0 && board[x + 1][y - 1] != null) {
            count++;
        }
        // check bottom right
        if (x < size - 1 && y < size - 1 && board[x + 1][y + 1] != null) {
            count++;
        }
        return count;
    }

    public void flag(int x, int y) {
        if (!boardDisplay[x][y].equals("F")) {
            boardDisplay[x][y] = "F";

            if (board[x][y] != null) {
                board[x][y].flag(true);
            }
        } else if (boardDisplay[x][y].equals("F")) {
            boardDisplay[x][y] = ".";
            if (board[x][y] != null) {
                board[x][y].flag(false);
            }
        }

        checkIfWon();
    }

    public boolean checkIfWon() {
        for (Mine[] row : board) {
            for (Mine mine : row) {
                if (mine != null && mine.getFlagStatus() == false) {
                    return false;
                }
            }
        }
        won = true;
        return true;
    }

    public void click(int x, int y) {
        if (clickCount == 0) {
            if (board[x][y] != null) {
                board[x][y] = null;
            }
        }
        update(x, y);
        checkIfWon();
        clickCount++;
    }

    private void update(int x, int y) {
        if (board[x][y] != null) {
            boardDisplay[x][y] = "M";
            gameover();
        }

        if (board[x][y] == null && getCloseMines(x, y) > 0) {
            boardDisplay[x][y] = "" + getCloseMines(x, y);
        }

        if (board[x][y] == null && getCloseMines(x, y) == 0 && !boardDisplay[x][y].equals("0")) {
            boardDisplay[x][y] = "" + getCloseMines(x, y);

            if (x > 0)
                update(x - 1, y);
            if (x < size - 1)
                update(x + 1, y);
            if (y > 0)
                update(x, y - 1);
            if (y < size - 1)
                update(x, y + 1);
            if (x > 0 && y > 0)
                update(x - 1, y - 1);
            if (x > 0 && y < size - 1)
                update(x - 1, y + 1);
            if (x < size - 1 && y > 0)
                update(x + 1, y - 1);
            if (x < size - 1 && y < size - 1)
                update(x + 1, y + 1);
        }
    }

    public void gameover() {
        gameover = true;
    }

    public boolean getGameoverStatus() {
        return gameover;
    }

    public void gameWon() {
        for (String[] row : boardDisplay) {
            for (String s : row) {
                if (!s.equals(".") && !s.equals("M")) {
                    won = true;
                }
            }
        }
    }

    public boolean getWinStatus() {
        return won;
    }

    public void displayBoard() {
        System.out.print("   ");

        for (int i = 0; i < board[0].length; i++) {
            if (i > 8) {
                System.out.print((i + 1) + " ");
            } else {
                System.out.print((i + 1) + "  ");
            }
        }

        System.out.println();

        for (int i = 0; i < boardDisplay.length; i++) {
            if (i < 9) {
                System.out.print((i + 1) + "  ");
            } else {
                System.out.print((i + 1) + " ");
            }
            for (int j = 0; j < boardDisplay[0].length; j++) {
                System.out.print(boardDisplay[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
