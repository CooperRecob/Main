package com.projects.casino.roulette;

import java.util.Scanner;

public class Roulette {

	static int betType;
	static int betTypeInside;
	static int betTypeOutside;

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Roulette\nYou start with 50 chips");
		System.out.println("");

		// sets base chip count
		int chips = 50;

		boolean playAgain = true;

		while (playAgain) {

			// begining of game
			System.out.println("");
			System.out.println("Okay let\'s begin!");
			System.out.println("");

			// betting
			int singleBet;

			while (true) {
				System.out.println("What number do you want to bet on?");
				singleBet = myObj.nextInt();

				if (singleBet > 36) {
					System.out.println("That is not a valid single");
				} else {
					break;
				}
			}

			// asks for a chip bet
			System.out.println("How much do you want to bet?");
			int bet = myObj.nextInt();

			// makes sure user doesn't cheat by betting 0, negative, or more than they have
			if (bet > chips) {
				bet = chips;
			}

			if (bet <= 0) {
				bet = 1;
			}

			// randomizes the where the ball falls
			int min = 0;
			int max = 36;

			int ballLand = (int) Math.floor(Math.random() * (max - min + 1) + min);

			// winning the game
			if (ballLand == singleBet) {
				System.out.println("You Won!");

				chips += bet;

				System.out.println("You have " + chips + "chips");
			} else {
				System.out.println("You Lose");
				System.out.println("The ball landed on space " + ballLand);

				chips -= bet;

				System.out.println("You have " + chips + " chips");
			}

			System.out.println("Do you want to play again?");
			while (true) {
				String playAgainYesNo = myObj.nextLine();

				if (playAgainYesNo.equals("no")) {
					playAgain = false;
					break;
				} else if (playAgainYesNo.equals("yes")) {
					break;
				}
			}
		}
		myObj.close();
	}
}