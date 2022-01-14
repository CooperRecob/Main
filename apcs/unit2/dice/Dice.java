package dice;

public class Dice {
	public void roll() {
		int diceRoll = (int) (Math.random() * (6) + 1);
		System.out.println(diceRoll);
	}
	
	public void roll(int sides) {
		int diceRoll = (int) (Math.random() * (sides) + 1);
		System.out.println(diceRoll);
	}
}
