package edu.apcs.unit2.planet;

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
		name = "earth";
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
}
