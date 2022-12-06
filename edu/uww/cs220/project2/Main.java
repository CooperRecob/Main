package edu.uww.cs220.project2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        FileInputStream fileByteStream = new FileInputStream("edu/uww/cs220/project2/WordBank.txt");
        Scanner inFS = new Scanner(fileByteStream);
        ArrayList<String> wordList = new ArrayList<>();
        int count = 0;
        while (inFS.hasNext()) {
            wordList.add(count, inFS.next());
            count++;
        }
        String theWord = wordList.get((int) (Math.random() * wordList.size()));
       

        // instead of printing the word print the word as _ so if word is hello it will
        // print _ _ _ _ _
        // use the word.length() to determine how many _ to print
        // but once you get a letter correct print the letter in the correct spot
        // so if the user guesses h then it will print h _ _ _ _
        // if the user guesses l then it will print h _ l l _
        // once user gets all the letters correct then print the word and say you won
        // if user runs out of guesses then print the word and say you lost

        String theWordToGuess = "";
        for (int i = 0; i < theWord.length(); i++) {
            theWordToGuess += "_";
        }

        Scanner input = new Scanner(System.in);
        int guesses = 0;

        while (guesses < 6) {
            System.out.println("Guess a letter");
            char letter = input.next().charAt(0);
            String temp = theWordToGuess;
            for (int i = 0; i < theWord.length(); i++) {
                if (letter == theWord.charAt(i)) {
                    theWordToGuess = theWordToGuess.substring(0, i) + letter + theWordToGuess.substring(i + 1);
                }
            }
            if (temp.equals(theWordToGuess)) {
                guesses++;
                // unbuild the hangman based on the number of guesses
                // if guesses is 0 then print everything
                // if guesses is 1 then print everything but the right leg
                System.out.println("You have " + (6 - guesses) + " guesses left");
                System.out.println(" _____________");
		        System.out.println(" |          ||");
		        System.out.println(" |          ||");
                if (guesses == 0) {
		            System.out.println(" O          ||");
		            System.out.println("(|)         ||");
		            System.out.println("( )         ||");
                } else if (guesses == 1) {
                    System.out.println(" O          ||");
                    System.out.println("(|)         ||");
                    System.out.println("  )         ||");
                } else if (guesses == 2) {
                    System.out.println(" O          ||");
                    System.out.println("(|)         ||");
                    System.out.println("            ||");
                } else if (guesses == 3) {
                    System.out.println(" O          ||");
                    System.out.println(" |)         ||");
                    System.out.println("            ||");
                } else if (guesses == 4) {
                    System.out.println(" O          ||");
                    System.out.println(" |          ||");
                    System.out.println("            ||");
                } else if (guesses == 5) {
                    System.out.println(" O          ||");
                    System.out.println("            ||");
                    System.out.println("            ||");
                }
		        System.out.println("            ||");
		        System.out.println("          __||__");
                
                if (guesses == 6) {
                    System.out.println("You lose");
                    System.out.println("The word was " + theWord);
                }
            } else if (theWordToGuess.equals(theWord)) {
                System.out.println("You win");
                System.out.println("The word was " + theWord);
                break;
            } else {
                System.out.println(theWordToGuess);
            }

            input.close();
        }

        inFS.close();
    }
}