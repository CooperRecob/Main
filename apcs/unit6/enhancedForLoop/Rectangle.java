package apcs.unit6.enhancedForLoop;

public class Rectangle {
	private int length;
	private int width;
	private int area;
	private int perimiter;
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public Rectangle(int side) {
		length = side;
		width = side;
	}

	public Rectangle() {
		length = 10;
		width = 10;
	}
	
	public void displayArea() {
		area = length * width;
		System.out.println("The Area is " + area);
	}
	
	public void displayPerimiter() {
		perimiter = (2 * length) + (2 * width);
		System.out.println("The Perimiter is " + perimiter);
	}
	
	public void displayRectangleInfo() {
		area = length * width;
		perimiter = (2 * length) + (2 * width);
		System.out.println("The Perimiter is " + perimiter);
		System.out.println("The Area is " + area);
		System.out.println(); 
	}
}
