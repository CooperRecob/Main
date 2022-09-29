package takeHomeLabs.homeLab3;

import java.util.Scanner;

public class Sort2DArray {
    // sort 3-by-3 matrix. Write a java program to sort the rows and columns in a
    // 3-by-3 matrix. and then display both unsorted matrix and sorted matrixes
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] matrix = new double[3][3];
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < matrix.length; i++) {
            String row = input.nextLine();
            String[] rowArray = row.split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Double.parseDouble(rowArray[j]);
            }
        }

        // display unsorted matrix
        System.out.println("The unsorted array is: ");
        displayMatrix(matrix);

        // only sort rows and print sorted rows
        double[][] sortedRows = sortRows(matrix);

        System.out.println("The row-sorted array is: ");
        displayMatrix(sortedRows);

        // only sort columns and print sorted columns
        double[][] sortedColumns = sortColumns(matrix);

        System.out.println("The column-sorted array is: ");
        displayMatrix(sortedColumns);

        input.close();
    }

    private static void displayMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static double[][] sortRows(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                for (int k = 0; k < m[i].length - 1; k++) {
                    if (m[i][k] > m[i][k + 1]) {
                        double temp = m[i][k];
                        m[i][k] = m[i][k + 1];
                        m[i][k + 1] = temp;
                    }
                }
            }
        }
        return m;
    }

    private static double[][] sortColumns(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                for (int k = 0; k < m[i].length - 1; k++) {
                    if (m[k][i] > m[k + 1][i]) {
                        double temp = m[k][i];
                        m[k][i] = m[k + 1][i];
                        m[k + 1][i] = temp;
                    }
                }
            }
        }
        return m;
    }
}
