package com.apcs.unit6.arrayAssignment;

public class Main {
	public static void main(String[] args) {
		int [] array = {10, 50, 70, 99, 80, 30};
		String [] stringArray = {"hello", "for", "rodgiiiiiiiii"};
		
		Average test = new Average(array);
		test.numAverage();
		
		Average stringLength = new Average(stringArray);
		stringLength.stringLengthAverage();
		
		GolfCourse gc1 = new GolfCourse();
		gc1.displayCourseInfo();
		gc1.playRound();
	}
}
