package takeHomeLabs.homeLab3;

import java.util.Scanner;

public class FishingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Die dice = new Die(6);
        int[] fish = new int[6];
        String[] fishNames = { "Small Fish", "Medium Fish", "Large Fish", "Gargantuan Fish", "Old Shoe(s)",
                "Peice(s) of Trash" };
        int points = 0;
        boolean playing = true;

        // Play the game
        while (playing) {
            System.out.println("Rolling the dice...");
            dice.roll();

            System.out.println("You rolled a " + dice.getValue());
            fish[dice.getValue() - 1]++;

            System.out.println("You caught a " + fishNames[dice.getValue() - 1]);

            System.out.println("Roll again? (y/n)");
            String answer = input.nextLine();
            if (answer.equals("n")) {
                playing = false;
            }
        }

        // Calculate the points
        points = fish[0] * 10 + fish[1] * 20 + fish[2] * 40 + fish[3] * 80 + fish[4] * 5;

        // Print out the results
        System.out.println("You have " + points + " points");
        System.out.println("You caught:");
        for (int i = 0; i < fish.length; i++) {
            System.out.println(fish[i] + " " + fishNames[i]);
        }

        input.close();
    }
}
