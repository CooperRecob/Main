package dice;

public class Main {
	public static void main (String[]args) {
		Dice dice1 = new Dice();
		dice1.roll();
		
		Dice dice2 = new Dice();
		dice2.roll(8);
		
		Dice dice3 = new Dice();
		dice3.roll(20);
	}
}
