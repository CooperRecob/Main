package edu.cs220.practices;

import java.util.Scanner;

public class practice2 {
    Scanner input = new Scanner(System.in);

    //get the average of 2 inputed numbers and print it
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num1 = input.nextInt();

        System.out.println("Enter another number: ");
        int num2 = input.nextInt();

        int sum = num1 + num2;
        System.out.println("The sum of the two numbers is: " + sum);

        double average = (double) sum / 2;
        System.out.println("The average of the two numbers is: " + average);

        input.close();
    }
}
