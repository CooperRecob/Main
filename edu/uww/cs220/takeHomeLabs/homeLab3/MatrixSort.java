package edu.uww.cs220.takeHomeLabs.homeLab3;

import java.util.Scanner;

public class MatrixSort {
    //sort 3-by-3 matrix. Write a java program to sort the rows and columns in a 
    //3-by-3 matrix. and then display both unsorted matrix and sorted matrixes
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        //display unsorted matrix

        //sort rows

        //sort columns
        
        input.close();
    }
}
