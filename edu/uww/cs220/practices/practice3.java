package edu.uww.cs220.practices;

import java.util.Scanner;

public class practice3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a zip code or q to quit: ");
            String zip = input.nextLine();
            if (zip.equals("q")) {
                break;
            }
            if (zip.length() != 5) {
                System.out.println("Invalid zip code");
                continue;
            }
            boolean valid = true;
            for (int i = 0; i < zip.length(); i++) {
                if (zip.charAt(i) < '0' || zip.charAt(i) > '9') {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                System.out.println("Valid zip code");
                break;
            } else {
                System.out.println("Invalid zip code");
            }
        }
        input.close();
    }
}
