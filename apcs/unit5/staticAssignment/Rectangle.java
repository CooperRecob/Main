package apcs.unit5.staticAssignment;

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}
	
	public int getArea() {
		return length * width;
	}
	
	public static int getArea(int length, int width) {
		return length * width;
	}
}
