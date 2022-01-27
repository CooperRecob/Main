package apcs.unit2.mathAndWrapperClasses;
import java.lang.Math;

public class Exponential {
	private int a;
	private int b;

	public Exponential(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int evaluate(int x) {
		return (int) (a * (Math.pow(b, x)));
	}

	public void generateTable() {
		for (int x = -3; x <= 3; x++)
		System.out.println("x=" + x + "\ty=" + evaluate(x)); 
		
	}
}