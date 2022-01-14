package staticAssignment;

public class Sarbucks {
	private String size;
	private String drink;
	static double price;
	static String side;
	
	public Sarbucks(String size, String drink) {
		this.size = size;
		this.drink = drink;
		
		if (size.equals("Grande")) {
			price = 7.5;
		} else {
			price = 6.5;
		}
		
		if (drink.equals("Frappachino")) {
			side = "Cookie";
		} else {
			side = "Brownie";
		}
	}
	
	public Sarbucks(String drink) {
		size = "Grande";
		price = 7.5;
		this.drink = drink;
		
		if (drink.equals("Frappachino")) {
			side = "Cookie";
		} else {
			side = "Brownie";
		}
	}
	
	public String getDrink() {
		return drink;
	}
	
	public void changeSize(String size) {
		this.size = size;
	}
	
	public String toString() {
		return "The order for a " + size + " " + drink + " with a " + side + " is $" + price + "0";
	}
}
