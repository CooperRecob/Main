package edu.apcs.unit2.name;

public class Main {
	public static void main(String[] args) {
		Name name1 = new Name("Peter", "Griffen");
		Name name2 = new Name("Cooper", "Recob");

		name1.username(true);

		name2.jediName("Miller", "Fort");

		pigLatin("Qadry");
	}

	public static String pigLatin(String word) {
		word = word.toLowerCase();
		int length = word.length();

		String start = word.substring(1, length);
		String end = word.substring(0, 1);
		String wholeWord = start + end + "ay";

		System.out.println(wholeWord);

		return wholeWord;
	}
}
