package com.projects.casino.craps;

import java.util.Scanner;

public class Craps {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Craps\nYou start with 50 chips");
		System.out.println("");

		// sets base chip count
		int chips = 50;

		boolean playAgain = true;

		while (playAgain) {

			// begining of game
			System.out.println("");
			System.out.println("Okay let\'s begin!");
			System.out.println("");

			System.out.println("What kind of bet do you want to place?");
			System.out.println("1.) Pass Bet");
			System.out.println("2.) Don\'t Pass Bet");

			int passOrNot;

			while (true) {
				passOrNot = myObj.nextInt();

				if (!(passOrNot == 1 || passOrNot == 2)) {
					System.out.println("What kind of bet do you want to place?");
					System.out.println("1.) Pass Bet");
					System.out.println("2.) Don\'t Pass Bet");
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

			boolean win;

			while (true) {
				int min = 1;
				int max = 6;

				int diceRoll1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
				int diceRoll2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

				int diceSum = diceRoll1 + diceRoll2;

				System.out.println("The roll came out as a " + diceSum);

				if (passOrNot == 1) {
					if (diceSum == 7 || diceSum == 11) {
						win = true;
						break;
					} else if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
						win = false;
						break;
					}
				} else if (passOrNot == 2) {
					if (diceSum == 7 || diceSum == 11) {
						win = false;
						break;
					} else if (diceSum == 2 || diceSum == 3 || diceSum == 12) {
						win = true;
						break;
					}
				}
			}

			// winning the game
			if (win == true) {
				System.out.println("You Won!");

				chips += bet;

				System.out.println("You have " + chips + " chips");
			} else {
				System.out.println("You Lose");

				chips -= bet;

				System.out.println("You have " + chips + " chips");
			}

			// ask user if they want to play again
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