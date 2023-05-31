package com.projects.pokemonMapGen;

//import scanner to read from file and printwriter to write to file
import java.io.*;
import java.util.Scanner;

public class FileIO {
    //save map to txt file using saveMap method since map is a 2d array of strings just save it in the file as each column of the array seperated by a space and each row seperated by a new line
    public static void saveMap(String[][] map, String name) {
        try {
            PrintWriter pw = new PrintWriter(new File(name + ".txt"));
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    pw.print(map[x][y] + " ");
                }
                pw.println();
            }
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    //load map from txt file using loadMap method since map is a 2d array of strings just load it in the file as each column of the array seperated by a space and each row seperated by a new line
    public static String[][] loadMap(String name) {
        String[][] map = new String[15][15];
        try {
            Scanner sc = new Scanner(new File(name + ".txt"));
            for (int x = 0; x < 15; x++) {
                for (int y = 0; y < 15; y++) {
                    map[x][y] = sc.next();
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return map;
    }
}
