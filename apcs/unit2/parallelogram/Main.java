package apcs.unit2.parallelogram;

public class Main {
	public static void main(String[] args) {
		Parallelogram square = new Parallelogram(5, 5);
		square.getPerimeter();
		Parallelogram rectangle = new Parallelogram(10, 5);
		rectangle.getPerimeter();
		
		System.out.println(square);
		System.out.println(rectangle);
	}
}
