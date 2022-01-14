package additionPattern;

public class AdditionPattern {
	private int addend;
	private int currentValue;
	private int startValue;

	public AdditionPattern(int startValue, int addend) {
		this.startValue = startValue;
		currentValue = startValue;
		this.addend = addend;
	}

	public void next() {
		currentValue += addend;
	}

	public void prev() {
		if (currentValue <= startValue) {
			currentValue = startValue;
		} else {
			currentValue -= addend;
		}
	}

	public int currentNumber() {
		System.out.println(currentValue);
		return currentValue;
	}
}
