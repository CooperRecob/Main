package enhancedForLoop;

public class Planet {
	private String name;
	private int radius;
	private boolean isLivable;
	private int moonCount;
	
	public Planet(String n, int r, boolean live, int mc) {
		name = n;
		radius = r;
		isLivable = live;
		moonCount = mc;
	}
	
	public Planet() {
		name = "Earth";
		radius = 3959;
		isLivable = true;
		moonCount = 1;
	}
	
	public void apocolypse() {
		isLivable = false;
	}
	
	public void displayPlanetaryData() {
		System.out.println("Planet Name: " + name);
		System.out.println("Planet Radius: " + radius);
		System.out.println("Moons: " + moonCount);
		System.out.println("Habitable: " + isLivable);
		System.out.println();
	}

	public String toString() {
		if (moonCount > 1) {
			if (isLivable = true) {
				return name + " is a habitable planet with a radius of " + radius + " and " + moonCount + " moons";
			} else {
				return name + " is a non-habitable planet with a radius of " + radius + " and " + moonCount + " moons";
			}
		} else {
			if (isLivable = true) {
				return name + " is a habitable planet with a radius of " + radius + " and " + moonCount + " moon";
			} else {
				return name + " is a non-habitable planet with a radius of " + radius + " and " + moonCount + " moon";
			}
		}
	}
}