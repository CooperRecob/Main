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

        // make patches of long grass that vary in size

        // make a random number of patches of long grass
        int numberOfPatches = (int) (Math.random() * 5) + 1;

        // make a random starting point for each patch of long grass and make a random
        // size for each patch of long grass
        int[] patchSizes = new int[numberOfPatches];
        int[][] patchMap = new int[15][15];

        for (int i = 0; i < numberOfPatches; i++) {
            int rand = (int) (Math.random() * 3) + 1;
            patchSizes[i] = rand;

            int x = (int) (Math.random() * 15);
            int y = (int) (Math.random() * 15);
            patchMap[x][y] = 1;
        }

        // make the patches of long grass a circle with a radius of the random size
        // aroud all the starting point
        // make sure no index out of bounds
        for (int col = 0; col < 15; col++) {
            for (int row = 0; row < 15; row++) {
                for (int i = 0; i < numberOfPatches; i++) {
                    if (patchMap[col][row] == 1) {
                        // make a circle around the point
                        for (int x = col - patchSizes[i]; x < col + patchSizes[i]; x++) {
                            for (int y = row - patchSizes[i]; y < row + patchSizes[i]; y++) {
                                // make sure no index out of bounds
                                if (x >= 0 && x < 15 && y >= 0 && y < 15) {
                                    map[x][y] = "lggs";
                                }
                            }
                        }
                    }
                }
            }
        }

        // line the edges with trees
        for (int x = 0; x < 15; x++) {
            map[x][0] = "logs";
            map[x][14] = "logs";
        }
        for (int y = 0; y < 15; y++) {
            map[0][y] = "logs";
            map[14][y] = "logs";
        }

        int pathChance = (int) (Math.random() * 2);

        if (pathChance == 1) {
            // make the path start at a random edge
            int startingEdge = (int) (Math.random() * 2);

            // make the path start at a random edge
            if (startingEdge == 0) {
                // start at the top
                for (int x = 0; x < 15; x++) {
                    map[x][6] = "path";
                    map[x][6 + 1] = "path";
                    map[x][6 + 2] = "path";
                }
            } else {
                // start at the left
                for (int y = 0; y < 15; y++) {
                    map[6][y] = "path";
                    map[6 + 1][y] = "path";
                    map[6 + 2][y] = "path";
                }
            }
        }

        // return the map
        return map;
    }
}
