package com.apcs.unit8.traversing2dArrays;

class Main {
    public static void main(String[] args) {

        int[][] m1 = { { 3, 8 }, { 4, 6 } };
        int[][] m2 = { { 4, 0 }, { 1, -9 } };
        int[][] m3 = { { 6, 4, 24 }, { 1, -9, 8 } };

        // Test Addition
        int[][] add = addMatrices(m1, m2);
        displayMatrix(add);

        // Test Subtraction
        int[][] sub = subtractMatrices(m1, m2);
        displayMatrix(sub);

        // Test multiplyConstant
        int[][] multi = multiplyConstant(2, m2);
        displayMatrix(multi);

        // Test transpose
        int[][] trans = transpose(m3);
        displayMatrix(trans);
    }

    public static void displayMatrix(int[][] matrix) {
        for(int[] row : matrix) {
            for(int n : row) {
                System.out.println(n + " ");
            }
            System.out.println();
        }
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyConstant(int k, int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = k * matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

}
