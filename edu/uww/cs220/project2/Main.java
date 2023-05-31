package edu.uww.cs220.project2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fileByteStream = new FileInputStream("edu/uww/cs220/project2/WordBank.txt"); // links to a file that contains all the words used for the game
            Scanner file = new Scanner(fileByteStream);
            ArrayList<String> wordList = new ArrayList<>(); // all the words from the word bank file get added to this listarray
            int count = 0;
            while (file.hasNext()) { // while there is more to read
                wordList.add(count, file.next()); // add the next word to the list
                count++;
            }
            Dice dice = new Dice(wordList.size() - 1); // create a new dice object with the number of sides equal to the number of words in the list to be rolled when the word is chosen
            String theWord = wordList.get(dice.roll());

            String theWordToGuess = "";
            for (int i = 0; i < theWord.length(); i++) {
                theWordToGuess += "_";
            }

            Scanner input = new Scanner(System.in);
            int guesses = 0;

            while (guesses < 6) {
                System.out.println("Guess a letter");
                // takes the input from the user (doesnt matter if its a letter or not)
                // if its not a letter then it will still count it as a guess
                char letter = input.next().charAt(0);
                String temp = theWordToGuess;
                // makes the word to guess show correct letters
                for (int i = 0; i < theWord.length(); i++) {
                    if (letter == theWord.charAt(i)) {
                        theWordToGuess = theWordToGuess.substring(0, i) + letter + theWordToGuess.substring(i + 1);
                    }
                }
                // unbuilds the hangman as the user guesses wrong
                if (temp.equals(theWordToGuess)) {
                    guesses++;
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
            }
            file.close();
            input.close();
        } catch (IOException InputMismatchException) { // catches if the file is not found
            System.out.println("Please input a letter");
        }
    }
}