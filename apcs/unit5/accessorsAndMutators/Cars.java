package accessorsAndMutators;

public class Cars {
	private String make;
	private int year;
	private boolean newEngine;

	public Cars(String make, int year, boolean newEngine) {
		this.make = make;
		this.year = year;
		this.newEngine = newEngine;
	}

	public Cars() {
		make = "Honda Civic";
		year = 2012;
		newEngine = false;
	}
	
	public int getYear() {
		return year;
	}
	
	public void replaceEngine() {
		newEngine = true;
	}

	public String toString() {
		if (newEngine == true) {
			return "Refurbished " + year + " " + make;
		} else {
			return year + " " + make;
		}
	}
}
