package com.apcs.unit2.calculator;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Calculator");
		System.out.println();
		System.out.println("Enter your operator");
		String operator = input.nextLine();

		System.out.println("Enter your first number");
		double num1 = input.nextInt();

		System.out.println("Enter your second number");
		double num2 = input.nextInt();

		double result = 0;

		if (operator.equals("+"))
			result = num1 + num2;
		else if (operator.equals("-"))
			result = num1 - num2;
		else if (operator.equals("*"))
			result = num1 * num2;
		else if (operator.equals("/"))
			result = num1 / num2;

		System.out.println("The result is " + result);

		input.close();
	}
}