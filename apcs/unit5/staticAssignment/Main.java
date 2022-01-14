package staticAssignment;

public class Main {
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle(10, 12);
		
		rect1.getArea();
		Rectangle.getArea(12, 14);
		
		Sarbucks frap = new Sarbucks("Frappachino");
		
		frap.changeSize("Small");
		frap.getDrink();
		
		System.out.println(frap.toString());
	}
}
