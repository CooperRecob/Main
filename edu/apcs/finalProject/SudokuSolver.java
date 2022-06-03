package edu.apcs.finalProject;

public class SudokuSolver{
    private int[][] solution;

    public SudokuSolver(int[][] board){
        solution = board;
    }

    // solve method uses recursion to solve the board
    // it will go through all blank spaces in board[][] and try to fill the space on solution[][] with a number
    // if it can't, it will backtrack and try the next number
    // if it can, it will continue to the next blank space
    // if it reaches the end of the board, it will return the solution
    // use recursion to solve the board
    public int[][] solve(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(solution[i][j] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(isValid(i, j, k)){
                            solution[i][j] = k;
                            if(solve() != null){
                                return solution;
                            }
                        }
                    }
                    solution[i][j] = 0;
                    return null;
                }
            }
        }
        return solution;
    }

    // check if the number is valid in the row, column, and 3x3 box
    public boolean isValid(int row, int col, int num){
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        //check row
        for(int i = 0; i < 9; i++){
            if(solution[row][i] == num){
                return false;
            }
        }
        //check column
        for(int i = 0; i < 9; i++){
            if(solution[i][col] == num){
                return false;
            }
        }
        //check 3x3 box
        for(int i = boxRow; i < boxRow + 3; i++){
            for(int j = boxCol; j < boxCol + 3; j++){
                if(solution[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}