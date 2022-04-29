package edu.apcs.unit2.car;

public class Car {
	private String name;
	private int year;
	
	public Car(String n, int y) {
		name = n;
		year = y;
	}
	
	public String toString() {
		return year + " " + name;
	}
}
