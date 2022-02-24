package com.apcs.unit2.planet;

public class Main {
	public static void main(String[]args) {
		Planet venus = new Planet("veuns", 10000, false, 0);
		Planet shinkataloon = new Planet("shinkataloon", 812723, true, 2);
		Planet earth = new Planet();
		Planet tatooine = new Planet("tatooine", 947002, true, 17);

		earth.apocolypse();
		
		venus.displayPlanetaryData();
		shinkataloon.displayPlanetaryData();
		earth.displayPlanetaryData();
		tatooine.displayPlanetaryData();
	}
}
