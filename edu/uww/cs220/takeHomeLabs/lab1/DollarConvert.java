package edu.uww.cs220.takeHomeLabs.lab1;

import java.util.Scanner;

public class DollarConvert {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the amount of dollars: ");
        double dollars = input.nextDouble();

        // convert dollars to cents which is then used to calculate 20's, 10's, 5's, 1's
        int cents = (int) (dollars * 100);
        int twenties = cents / 2000;
        cents = cents % 2000;
        int tens = cents / 1000;
        cents = cents % 1000;
        int fives = cents / 500;
        cents = cents % 500;
        int ones = cents / 100;
        cents = cents % 100;
        System.out.println(dollars + " dollars = " + twenties + " of $20s + " + tens + " of $10s + " + fives + " of $5s + " + ones + " of $1s + " + cents + " cents");

        input.close();
    }
}
