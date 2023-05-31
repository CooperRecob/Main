import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of touchdowns: ");
        int touchdowns = input.nextInt();
        System.out.print("Enter the number of yards: ");
        int yards = input.nextInt();
        System.out.print("Enter the number of interceptions: ");
        int interceptions = input.nextInt();
        System.out.print("Enter the number of completions: ");
        int completions = input.nextInt();
        System.out.print("Enter the number of attempts: ");
        int attempts = input.nextInt();
        double a = (completions / attempts - 0.3) * 5;
        double b = (yards / attempts - 3) * 0.25;
        double c = (touchdowns / attempts) * 20;
        double d = 2.375 - (interceptions / attempts * 25);
        double passerRating = ((a + b + c + d) / 6) * 100;
        System.out.println("The passer rating is " + passerRating);
        input.close();
    }
}