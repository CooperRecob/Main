package com.apcs.unit5.accessorsAndMutators;

public class Main {
	public static void main(String[] args) {
		Cars civic = new Cars();
		Cars buick = new Cars("Buick Verano", 2010, true);
		Cars jetta = new Cars("Volkswaggen Jetta", 1985, false);
		
		civic.getYear();
		jetta.replaceEngine();
		
		System.out.println(civic.toString());
		System.out.println(buick.toString());
		System.out.println(jetta.toString());
	}
}
