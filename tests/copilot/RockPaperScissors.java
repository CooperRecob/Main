package tests.copilot;
//input scanner
import java.util.Scanner;

public class RockPaperScissors {
    //rock, paper, scissors with scanner
    public static void main(String[] args) {
        try (//create scanner
        Scanner scanner = new Scanner(System.in)) {
            //create random number
            int random = (int) (Math.random() * 3);
            //if random number is 0
            if (random == 0) {
                //rock
                System.out.println("Rock");
                //ask user for input
                System.out.println("Enter your choice: ");
                //create user input
                String userInput = scanner.nextLine();
                //if user input is rock
                if (userInput.equals("rock")) {
                    //tie
                    System.out.println("Tie");
                }
                //if user input is paper
                else if (userInput.equals("paper")) {
                    //lose
                    System.out.println("Lose");
                }
                //if user input is scissors
                else if (userInput.equals("scissors")) {
                    //win
                    System.out.println("Win");
                }
                //if user input is not rock, paper, or scissors
                else {
                    //invalid
                    System.out.println("Invalid");
                }
            }
            //if random number is 1
            else if (random == 1) {
                //paper
                System.out.println("Paper");
                //ask user for input
                System.out.println("Enter your choice: ");
                //create user input
                String userInput = scanner.nextLine();
                //if user input is rock
                if (userInput.equals("rock")) {
                    //win
                    System.out.println("Win");
                }
                //if user input is paper
                else if (userInput.equals("paper")) {
                    //tie
                    System.out.println("Tie");
                }
                //if user input is scissors
                else if (userInput.equals("scissors")) {
                    //lose
                    System.out.println("Lose");
                }
                //if user input is not rock, paper, or scissors
                else {
                    //invalid
                    System.out.println("invalid");
                }
            }
        }
    }
}
