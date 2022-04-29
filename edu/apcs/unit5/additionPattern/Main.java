package edu.apcs.unit5.additionPattern;

public class Main {
	public static void main(String[] args) {
		AdditionPattern plus3 = new AdditionPattern(2, 3);

		plus3.currentNumber();
		plus3.next();
		plus3.currentNumber();
		plus3.next();
		plus3.next();
		plus3.currentNumber();
		plus3.prev();
		plus3.prev();
		plus3.prev();
		plus3.currentNumber();
		plus3.prev();
		plus3.currentNumber();
	}
}
