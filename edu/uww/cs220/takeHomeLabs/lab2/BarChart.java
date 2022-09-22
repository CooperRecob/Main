package edu.uww.cs220.takeHomeLabs.lab2;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class BarChart {
    // opens salesData.txt and reads the data into an array with a length of the number of lines in the file
    // prints a bar graph of the data where each "*" represents $100 to the console and to a file called barChart.txt
    public static void main(String[] args) {
        try {
            File file = new File("edu/uww/cs220/takeHomeLabs/lab2/salesData.txt");
            Scanner input = new Scanner(file);
            int[] data = new int[0];
            while (input.hasNextLine()) {
                int[] temp = new int[data.length + 1];
                for (int i = 0; i < data.length; i++) {
                    temp[i] = data[i];
                }
                temp[temp.length - 1] = Integer.parseInt(input.nextLine());
                data = temp;
            }
            input.close();
            FileWriter writer = new FileWriter("edu/uww/cs220/takeHomeLabs/lab2/SalesBarChart.txt");
            for (int i = 0; i < data.length; i++) {
                System.out.print("Store " + (i + 1) + ": ");
                writer.write("Store " + (i + 1) + ": ");
                for (int j = 0; j < data[i] / 100; j++) {
                    System.out.print("*");
                    writer.write("*");
                }
                System.out.println();
                writer.write("\r");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
