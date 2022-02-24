package com.apcs.unit7.traversingArrayLists;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] intArray = { 3, 5, 2, 7, 8 };

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        intArrayList.add(3);
        intArrayList.add(5);
        intArrayList.add(2);
        intArrayList.add(7);
        intArrayList.add(8);

        // array prints out memory location while arrayList prints out values within
        // (kind of like a toString)
        System.out.println(intArray);
        System.out.println(intArrayList);

        ArrayList<String> friendsAndFamily = new ArrayList<String>();

        friendsAndFamily.add("Julie");
        friendsAndFamily.add("Randy");
        friendsAndFamily.add("Logan");
        friendsAndFamily.add("Rodgi");
        friendsAndFamily.add("Peyton");

        // prints out ["Julie", "Randy", "Logan", "Rodgi", "Peyton"]
        System.out.println(friendsAndFamily);

        ArrayList<Pets> pets = new ArrayList<Pets>();

        pets.add(new Pets("Norah", "Dog", 2));
        pets.add(new Pets("Norah", "Dog", 2));
        pets.add(new Pets("Norah", "Dog", 2));
        pets.add(new Pets("Norah", "Dog", 2));
        pets.add(new Pets("Campi", "Dog", 4));

        // without a toString it pritns the package and memory adress
        System.out.println(pets);
        System.out.println(pets.toString());

        int answer = intArrayList.get(0);

        for (int i = 0; i < intArrayList.size(); i++) {
            if (answer < intArrayList.get(i)) {
                answer = intArrayList.get(i);
            }
        }

        ArrayList<String> vowel = new ArrayList<String>();

        vowel.add("add");
        vowel.add("cool");
        vowel.add("amogus");

        int vowelCount = 0;

        for (int i = 0; i < vowel.size(); i++) {
            if (hasFirstVowel(vowel.get(i))) {
                vowelCount++;
            }
        }

        System.out.println("The vowel count is " + vowelCount);

        int oldestDogAge = pets.get(0).getAge();
        String oldestDogName = pets.get(0).getName();
        int dogCount = 0;
        double dogAgeTotal = 0;

        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getType().equals("Dog")) {
                dogCount++;
                dogAgeTotal += pets.get(i).getAge();
                if (oldestDogAge < pets.get(i).getAge()) {
                    oldestDogName = pets.get(i).getName();
                }
            }
        }

        double dogAverageAge = dogAgeTotal / dogCount;

        System.out.println("The oldest dog is " + oldestDogName + " and they are " + oldestDogAge + " years old");
        System.out.println("There are " + dogCount + " dogs");
        System.out.println("The average age of dogs is " + dogAverageAge);
    }

    public static boolean hasFirstVowel(String vowel) {
        if (vowel.substring(0, 1).equalsIgnoreCase("a") || vowel.substring(0, 1).equalsIgnoreCase("e")
                || vowel.substring(0, 1).equalsIgnoreCase("i") || vowel.substring(0, 1).equalsIgnoreCase("o")
                || vowel.substring(0, 1).equalsIgnoreCase("u")) {
            return true;
        } else {
            return false;
        }
    }
}
