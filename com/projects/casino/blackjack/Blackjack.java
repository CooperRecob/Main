package com.projects.casino.blackjack;

import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("Blackjack\nYou start with 50 chips");
		System.out.println("");

		// sets base chip count, can go + or - from here
		int chips = 50;

		boolean playAgain1 = true;

		while (playAgain1) {
			// begining of game
			System.out.println("");
			System.out.println("Okay let\'s begin!");
			System.out.println("");
			System.out.println("What is your bet?");
			int bet1 = myObj.nextInt();
			System.out.println("");

			if (bet1 > chips) {
				bet1 = chips;
			}

			if (bet1 <= 0) {
				bet1 = 1;
			}

			int splitBet1;
			int splitBet2;

			// defines the min and max of the number generator
			int min1 = 1;
			int max1 = 13;

			int min2 = 1;
			int max2 = 10;

			// dealer card gens
			int dealerCard1 = (int) Math.floor(Math.random() * (max2 - min2 + 1) + min2);
			int dealerCard2 = (int) Math.floor(Math.random() * (max2 - min2 + 1) + min2);

			int dealerSum = dealerCard1 + dealerCard2;

			while (dealerSum <= 17) {
				int dealerCard3 = (int) Math.floor(Math.random() * (max2 - min2 + 1) + min2);
				dealerSum += dealerCard3;
			}

			// variables from the card number generator
			int userCard1 = (int) Math.floor(Math.random() * (max1 - min1 + 1) + min1);

			int card1Value = 0;

			String card1 = "";

			if (userCard1 == 13) {
				card1 = "King";
				card1Value = 10;
			} else if (userCard1 == 12) {
				card1 = "Queen";
				card1Value = 10;
			} else if (userCard1 == 11) {
				card1 = "Jack";
				card1Value = 10;
			} else if (userCard1 == 1) {
				card1 = "Ace";
				card1Value = 11;
			} else {
				card1 += userCard1;
				card1Value = userCard1;
			}

			// tells user their first card
			System.out.println("Your first card is " + card1);

			int cardSum = card1Value;
			int splitCardSum1 = card1Value;

			// variables from the card number generator
			int userCard2 = (int) Math.floor(Math.random() * (max1 - min1 + 1) + min1);

			int card2Value = 0;

			String card2 = "";

			if (userCard2 == 13) {
				card2 = "King";
				card2Value = 10;
			} else if (userCard2 == 12) {
				card2 = "Queen";
				card2Value = 10;
			} else if (userCard2 == 11) {
				card2 = "Jack";
				card2Value = 10;
			} else if (userCard2 == 1) {
				card2 = "Ace";
				card2Value = 11;
			} else {
				card2 += userCard2;
				card2Value = userCard2;
			}

			// checks for splits
			boolean split = false;

			int userCardSum = card1Value + card2Value;
			int splitCardSum2 = card2Value;

			// tells user their cards
			System.out.println("Your second card is " + card2);

			while (card1.equals(card2) && !card1.equals("Ace")) {
				String splitOrNot = myObj.nextLine();
				if (splitOrNot.equals("yes")) {
					split = true;
					break;
				} else if (splitOrNot.equals("no")) {
					break;
				} else {
					System.out.println("Do you want to split?");
				}
			}

			if ((card1.equals("Ace") && card2.equals("Ace"))) {
				splitCardSum1 = 11;
				splitCardSum2 = 11;
				split = true;
			}

			if (split == false) {

				cardSum += card2Value;

				System.out.println("The dealer is showing a " + dealerCard2);

				// ask user if they want to hit or stand
				System.out.println("");

				boolean hitOrStand1;

				System.out.println("Do you want to hit or stand?");

				while (true) {
					String hitOrStand = myObj.nextLine();

					if (hitOrStand.equals("hit")) {
						hitOrStand1 = true;

						// start of bet raising
						if (hitOrStand1 == true) {

							System.out.println("Do you want to raise?");

							while (true) {
								String raiseOrNot = myObj.nextLine();

								if (raiseOrNot.equals("yes")) {
									System.out.println("How much do you want to raise?");
									int raise1 = myObj.nextInt();
									bet1 = bet1 + raise1;
									if (bet1 > chips) {
										bet1 = chips;
									}
									break;
								} else if (raiseOrNot.equals("no")) {
									break;
								} else {
									System.out.println("Do you want to raise?");
								}
							}
						}

						// variables from the card number generator
						int userCard3 = (int) Math.floor(Math.random() * (max1 - min1 + 1) + min1);
						int card3Value = 0;

						String card3 = "";

						if (userCard3 == 13) {
							card3 = "King";
							card3Value = 10;
						} else if (userCard3 == 12) {
							card3 = "Queen";
							card3Value = 10;
						} else if (userCard3 == 11) {
							card3 = "Jack";
							card3Value = 10;
						} else if (userCard3 == 1) {
							card3 = "Ace";
							card3Value = 11;
						} else {
							card3 += userCard3;
							card3Value = userCard3;
						}

						System.out.println("Your hit came out as " + card3);

						cardSum += card3Value;

						// check for ace bust
						if (cardSum > 21 && card1Value == 11) {
							card1Value = 1;
							cardSum = cardSum - 10;
						}

						if (cardSum > 21 && card2Value == 11) {
							card2Value = 1;
							cardSum = cardSum - 10;
						}

						if (cardSum > 21 && card3Value == 11) {
							card2Value = 1;
							cardSum = cardSum - 10;
						}

						// check for bust on nonsplits
						if (cardSum > 21) {
							System.out.println("Bust");
							System.out.println("You bet " + bet1 + " chips");
							chips = chips - bet1;
							System.out.println("Your chip count is " + chips);
							break;
						} else {
							System.out.println("Your total card count is now " + cardSum);
							System.out.println("Do you want to hit or stand?");

						}

					} else if (hitOrStand.equals("stand")) {
						hitOrStand1 = false;

						if ((card1Value + card2Value == 21) && userCardSum == 21) {
							System.out.println("You got a blackjack, your bet is now doubled for the win!");
							bet1 = 2 * bet1;
							System.out.println("You bet " + bet1 + " chips");
							chips = chips + bet1;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum > 21) {
							System.out.println("The dealer\'s total is " + dealerSum + " and they bust");
							System.out.println("You won this round!");
							System.out.println("You bet " + bet1 + " chips");
							chips = chips + bet1;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum > userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You lose this round");
							System.out.println("You bet " + bet1 + " chips");
							chips = chips - bet1;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum < userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You won this round!");
							System.out.println("You bet " + bet1 + " chips");
							chips = chips + bet1;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum == userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You and the dealer tied");
						}
						break;
					}
				}
			} else if (split == true) {
				splitBet1 = bet1;
				splitBet2 = bet1;

				System.out.println("The dealer has a " + dealerCard1 + " and a " + dealerCard2);

				// ask user if they want to hit or stand
				System.out.println("");

				boolean hitOrStand1;

				System.out.println("Do you want to hit or stand on your first card?");

				while (true) {
					String hitOrStand = myObj.nextLine();

					if (hitOrStand.equals("hit")) {
						hitOrStand1 = true;

						// start of bet raising
						if (hitOrStand1 == true) {

							System.out.println("Do you want to raise?");

							while (true) {
								String raiseOrNot = myObj.nextLine();

								if (raiseOrNot.equals("yes")) {
									System.out.println("How much do you want to raise?");
									int raise1 = myObj.nextInt();
									splitBet1 = splitBet1 + raise1;
									if (splitBet1 > chips) {
										splitBet1 = chips;
									}
									break;
								} else if (raiseOrNot.equals("no")) {
									break;
								} else {
									System.out.println("Do you want to raise?");
								}
							}
						}

						// variables from the card number generator
						int userCard3 = (int) Math.floor(Math.random() * (max1 - min1 + 1) + min1);
						int card3Value = 0;

						String card3 = "";

						if (userCard3 == 13) {
							card3 = "King";
							card3Value = 10;
						} else if (userCard3 == 12) {
							card3 = "Queen";
							card3Value = 10;
						} else if (userCard3 == 11) {
							card3 = "Jack";
							card3Value = 10;
						} else if (userCard3 == 1) {
							card3 = "Ace";
							card3Value = 11;
						} else {
							card3 += userCard3;
							card3Value = userCard3;
						}

						System.out.println("Your hit came out as " + card3);

						splitCardSum1 += card3Value;

						// check for ace bust
						if (splitCardSum1 > 21 && card1Value == 11) {
							card1Value = 1;
							splitCardSum1 = splitCardSum1 - 10;
						}

						if (splitCardSum1 > 21 && card2Value == 11) {
							card2Value = 1;
							splitCardSum1 = splitCardSum1 - 10;
						}

						if (splitCardSum1 > 21 && card3Value == 11) {
							card2Value = 1;
							splitCardSum1 = splitCardSum1 - 10;
						}

						// check for bust on nonsplits
						if (splitCardSum1 > 21) {
							System.out.println("Bust");
							System.out.println("You bet " + splitBet1 + " chips");
							chips = chips - splitBet1;
							System.out.println("Your chip count is " + chips);
							break;
						} else {
							System.out.println("Your total card count is now " + splitCardSum1);
							System.out.println("Do you want to hit or stand?");

						}

					} else if (hitOrStand.equals("stand")) {
						hitOrStand1 = false;

						if (dealerSum > 21) {
							System.out.println("The dealer\'s total is " + dealerSum + " and they bust");
							System.out.println("You won this round!");
							System.out.println("You bet " + splitBet1 + " chips");
							chips = chips + splitBet1;
							System.out.println("Your chip count is " + chips);
							break;
						} else if (dealerSum > userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You lose this round");
							System.out.println("You bet " + splitBet1 + " chips");
							chips = chips - splitBet1;
							System.out.println("Your chip count is " + chips);
							break;
						} else if (dealerSum < userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You won this round!");
							System.out.println("You bet " + splitBet1 + " chips");
							chips = chips + splitBet1;
							System.out.println("Your chip count is " + chips);
							break;
						} else if (dealerSum == userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You and the dealer tied");
							break;
						}
					}
				}

				// ask user if they want to hit or stand for the second card
				System.out.println("");

				System.out.println("Do you want to hit or stand on your second card?");

				while (true) {
					String hitOrStand = myObj.nextLine();

					if (hitOrStand.equals("hit")) {
						hitOrStand1 = true;

						// start of bet raising
						if (hitOrStand1 == true) {

							System.out.println("Do you want to raise?");

							while (true) {
								String raiseOrNot = myObj.nextLine();

								if (raiseOrNot.equals("yes")) {
									System.out.println("How much do you want to raise?");
									int raise1 = myObj.nextInt();
									splitBet2 = splitBet2 + raise1;
									if (splitBet2 > chips) {
										splitBet2 = chips;
									}
									break;
								} else if (raiseOrNot.equals("no")) {
									break;
								} else {
									System.out.println("Do you want to raise?");
								}
							}
						}

						// variables from the card number generator
						int userCard4 = (int) Math.floor(Math.random() * (max1 - min1 + 1) + min1);
						int card4Value = 0;

						String card4 = "";

						if (userCard4 == 13) {
							card4 = "King";
							card4Value = 10;
						} else if (userCard4 == 12) {
							card4 = "Queen";
							card4Value = 10;
						} else if (userCard4 == 11) {
							card4 = "Jack";
							card4Value = 10;
						} else if (userCard4 == 1) {
							card4 = "Ace";
							card4Value = 11;
						} else {
							card4 += userCard4;
							card4Value = userCard4;
						}

						System.out.println("Your hit came out as " + card4);

						splitCardSum2 += card4Value;

						// check for ace bust
						if (splitCardSum2 > 21 && card2Value == 11) {
							card1Value = 1;
							splitCardSum2 = splitCardSum2 - 10;
						}

						if (splitCardSum2 > 21 && card2Value == 11) {
							card2Value = 1;
							splitCardSum2 = splitCardSum2 - 10;
						}

						if (splitCardSum2 > 21 && card4Value == 11) {
							card2Value = 1;
							splitCardSum2 = splitCardSum2 - 10;
						}

						// check for bust on nonsplits
						if (splitCardSum2 > 21) {
							System.out.println("Bust");
							System.out.println("You bet " + splitBet2 + " chips");
							chips = chips - splitBet2;
							System.out.println("Your chip count is " + chips);
							break;
						} else {
							System.out.println("Your total card count is now " + splitCardSum2);
							System.out.println("Do you want to hit or stand?");

						}

					} else if (hitOrStand.equals("stand")) {
						hitOrStand1 = false;

						if (dealerSum > 21) {
							System.out.println("The dealer\'s total is " + dealerSum + " and they bust");
							System.out.println("You won this round!");
							System.out.println("You bet " + splitBet2 + " chips");
							chips = chips + splitBet2;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum > userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You lose this round");
							System.out.println("You bet " + splitBet2 + " chips");
							chips = chips - splitBet2;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum < userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You won this round!");
							System.out.println("You bet " + splitBet2 + " chips");
							chips = chips + splitBet2;
							System.out.println("Your chip count is " + chips);
						} else if (dealerSum == userCardSum) {
							System.out.println("The dealer\'s total is " + dealerSum);
							System.out.println("You and the dealer tied");
						}
						break;
					}
				}
			}

			System.out.println("Do you want to play again?");

			while (true) {
				String playAgain = myObj.nextLine();
				if (chips == 0) {
					System.out.println("Nevermind, you don't have enough chips to play again sorry!");
					playAgain1 = false;
					break;
				}
				if (playAgain.equals("yes")) {
					playAgain1 = true;
					break;
				} else if (playAgain.equals("no")) {
					playAgain1 = false;
					break;
				} else {
					System.out.println("Do you want to play again?");
				}
			}
		}
		myObj.close();
	}
}