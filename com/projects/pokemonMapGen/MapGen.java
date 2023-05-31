package com.projects.pokemonMapGen;

public class MapGen {
    // generate a 15x15 map using the following rules:
    // 1. the map must use the following characters to represent the following
    // terrain:
    // a. long grass = lggs
    // b. short grass = shgs
    // c. tree = logs
    // d. path = path
    // 2. the map must be traversable by path or short grass
    // 3. the path must be at least 3 tiles wide
    // 4. you must be able to get from one side of the map to the other either top
    // to bottom or left to right
    // 5. you cant move through trees so they must be placed in a way that you cant
    // move through them
    // 6. the edges must be tree
    // make there be twists and turns in the path
    public static String[][] generateMap() {
        String[][] map = new String[15][15];
        // fill the map with short grass
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                map[x][y] = "shgs";
            }
        }
        // file the edges with trees
        for (int x = 0; x < 15; x++) {
            map[x][0] = "logs";
            map[x][14] = "logs";
        }
        for (int y = 0; y < 15; y++) {
            map[0][y] = "logs";
            map[14][y] = "logs";
        }

        // make the path using these rules:
        // 1. the path must be at least 3 tiles wide
        // 2. you must be able to get from one side of the map to the other either top
        // to bottom or left to right

        // make the path start at a random edge
        int startingEdge = (int) (Math.random() * 2);

        // make the path start at a value between 2 and 9
        int startingValue = (int) (Math.random() * 7) + 2;

        // make the path start at a random edge
        if (startingEdge == 0) {
            // start at the top
            for (int x = 0; x < 15; x++) {
                map[x][startingValue] = "path";
                map[x][startingValue + 1] = "path";
                map[x][startingValue + 2] = "path";
            }
        } else {
            // start at the left
            for (int y = 0; y < 15; y++) {
                map[startingValue][y] = "path";
                map[startingValue + 1][y] = "path";
                map[startingValue + 2][y] = "path";
            }
        }

        //make patches of long grass
        



        // return the map
        return map;
    }
}
