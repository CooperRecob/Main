package com.apcs.unit2.parallelogram;

public class Parallelogram {
	private int side1;
	private int side2;
	private int perimeter;
	
	public Parallelogram(int side1, int side2) {
		this.side1 = side1;
		this.side2 = side2;
	}
	
	public int getPerimeter() {
		perimeter = (side1 * 2) + (side2 * 2);
		return perimeter;
	}
	
	public String toString() {
		return "" + perimeter;
	}
}
