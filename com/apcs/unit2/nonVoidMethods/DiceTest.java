package com.apcs.unit2.nonVoidMethods;

public class DiceTest {
	public int roll1() {
		int roll = (int)(Math.random() *6 + 1);
		return roll; 
	}

	public void roll2() {
		int roll = (int)(Math.random() *6 + 1);
		System.out.println( roll );
	}
}