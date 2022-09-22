package edu.uww.cs220.practices;

import java.util.Scanner;

public class practice2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int sum = x + y;
        double avg = (double) sum / 2;
        System.out.println("The sum is " + sum + " and the average is " + avg);
        System.out.printf("The sum is %d and the average is %.2f\n", sum, avg);
        input.close();
    }
}
