package edu.uww.cs220.takeHomeLabs.lab2;

import javax.swing.JOptionPane;

public class ESPGame {
    public static void main(String[] args) {
        int totalGames = 0;
        int correctGuesses = 0;
        String[] colors = {"Red", "Green", "Blue", "Yellow", "Purple"};
        while (true) {
            String guess = JOptionPane.showInputDialog(null, "Enter a color (r, g, b, y, p) or q to quit");
            if (guess.equals("q")) {
                break;
            }
            int random = (int) (Math.random() * 5);
            String color = colors[random];
            System.out.println("The color is " + color);
            if (guess.equals("r") && color.equals("Red")) {
                correctGuesses++;
            } else if (guess.equals("g") && color.equals("Green")) {
                correctGuesses++;
            } else if (guess.equals("b") && color.equals("Blue")) {
                correctGuesses++;
            } else if (guess.equals("y") && color.equals("Yellow")) {
                correctGuesses++;
            } else if (guess.equals("p") && color.equals("Purple")) {
                correctGuesses++;
            }
            totalGames++;
        }
        System.out.println("Total games: " + totalGames);
        System.out.println("Correct guesses: " + correctGuesses);
    }
}