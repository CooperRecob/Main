package edu.apcs.testReview.frq2021;

public class ArrayResizer {
    public static boolean isNonZeroRow(int[][] arr, int row) {
        for (int i = 0; i < arr[row].length; i++) {
            if (arr[row][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static int numNonZeroRows(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isNonZeroRow(arr, i)) {
                count++;
            }
        }
        return count;
    }

    public static int[][] resize(int[][] arr) {
        int[][] newArr = new int[numNonZeroRows(arr)][arr[0].length];
        int newRow = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isNonZeroRow(arr, i)) {
                for (int j = 0; j < arr[i].length; j++) {
                    newArr[newRow][j] = arr[i][j];
                }
                newRow++;
            }
        }
        return newArr;
    }
}
