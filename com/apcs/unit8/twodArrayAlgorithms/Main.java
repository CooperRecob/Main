package com.apcs.unit8.twodArrayAlgorithms;

public class Main {
    public static void main(String[] args) {
        int[][] numbers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(largestRow(numbers));
        System.out.println(countEvens(numbers));

        Neighborhood fort = new Neighborhood("Fort", 3, 3);
        fort.buildHouse(new House(100000, 4, 3), 0, 0);
        fort.buildHouse(new House(100000, 4, 0), 0, 1);
        fort.buildHouse(new House(100000, 4, 0), 0, 2);
        fort.buildHouse(new House(100000, 4, 0), 1, 0);
        fort.buildHouse(new House(100000, 4, 0), 1, 1);
        fort.buildHouse(new House(100000, 4, 0), 1, 2);
        fort.buildHouse(new House(100000, 4, 0), 2, 0);
        fort.buildHouse(new House(100000, 4, 0), 2, 1);
        fort.buildHouse(new House(100000, 4, 0), 2, 2);

        System.out.println(fort.largestStreet());
    }

    public static int countEvens(int[][] nums) {
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if(nums[i][j] % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int[] largestRow(int[][] nums) {
        int temp = 0;
        int rowCount = 0;
        int rowIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                rowCount += nums[i][j];
            }
            if(rowCount > temp) {
                temp = rowCount;
                rowIndex++;
            }
            rowCount = 0;
        }
        return nums[rowIndex - 1];
    }
}
