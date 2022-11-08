package edu.uww.cs220.takeHomeLabs.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneNumSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            Scanner reader = new Scanner(new File("edu/uww/cs220/takeHomeLabs/lab5/sampleData.csv"));
            HashMap<String[], Integer[]> phoneNums = new HashMap<String[], Integer[]>();

            while (reader.hasNextLine()) {
                String[] line = reader.nextLine().split(",");
                String[] name = {line[0], line[1]};
                Integer[] phoneNum = {Integer.parseInt(line[2].split("-")[0]), Integer.parseInt(line[2].split("-")[1])};
                phoneNums.put(name, phoneNum);
            }

            reader.close();

            System.out.print("Find Customers: ");
            String search = input.nextLine();
            boolean found = false;

            for (String[] name : phoneNums.keySet()) {
                if (name[0].startsWith(search) || name[1].startsWith(search)) {
                    String number = phoneNums.get(name)[0] + "-" + phoneNums.get(name)[1];
                    System.out.println(name[0] + ", " + name[1] + ": " + number);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Did not find customer with name starts with \"" + search + "\"");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        input.close();
    }
}