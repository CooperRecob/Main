package com.apcs.unit2.name;

public class Name {
	private String firstName;
	private String lastName;
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String username(boolean taken) {
		String username = lastName + firstName;

		if (taken = true) {
			username += 1;
		}
		System.out.println(username);
		return username;
	}
	
	public String jediName(String maidenName, String city) {
		String jediFirstName = firstName.substring(0, 3) + "-" + lastName.substring(0, 3); 
		String jediLastName = maidenName.substring(0, 3) + city.toLowerCase().substring(0, 3);
		String jediName = jediFirstName + " " + jediLastName;
		
		System.out.println(jediName);
		return jediName;
	}
}
