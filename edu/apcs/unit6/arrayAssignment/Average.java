package edu.apcs.unit6.arrayAssignment;

public class Average {
	private int[] array;
	private String[] stringArray;

	public Average(int[] array) {
		this.array = array;
	}

	public Average(String[] stringArray) {
		this.stringArray = stringArray;
	}

	public double numAverage() {
		double total = 0.0;

		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}

		double average = total / array.length;

		return average;
	}

	public double stringLengthAverage() {
		double total = 0.0;

		for (int i = 0; i < stringArray.length; i++) {
			total += stringArray[i].length();
		}

		double average = total / stringArray.length;

		return average;
	}
}
