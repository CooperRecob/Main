package com.apcs.unit8.twodArrayAlgorithms;

public class Neighborhood {
    //private String name;
    private House[][] neighborhood;

    public Neighborhood(String name, int r, int c) {
        //this.name = name;
        neighborhood = new House[r][c];
    }

    public void buildHouse(House house, int x, int y) {
        neighborhood[x][y] = house;
    }

    public int countResidents() {
        int count = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[0].length; j++) {
                count += neighborhood[i][j].getResidents();
            }
        }
        return count;
    }

    public int countVacant() {
        int count = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[0].length; j++) {
                if(neighborhood[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    public House mostExpensiveHouse() {
        double temp = neighborhood[0][0].getCost();
        int x = 0;
        int y = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[0].length; j++) {
                if(neighborhood[i][j].getCost() > temp) {
                    temp = neighborhood[i][j].getCost();
                    x = i;
                    y = j;
                }
            }
        }
        return neighborhood[x][y];
    }

    public void meetOSHA() {
        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[0].length; j++) {
                if(neighborhood[i][j].getRooms() < 3) {
                    neighborhood[i][j].addRoom();
                    j--;
                }
            }
        }
    }

    public House[] largestStreet() {
        int temp = 0;
        int roomCount = 0;
        int rowIndex = 0;

        for (int i = 0; i < neighborhood.length; i++) {
            for (int j = 0; j < neighborhood[0].length; j++) {
                roomCount += neighborhood[i][j].getRooms();
            }
            if(roomCount > temp) {
                temp = roomCount;
                rowIndex++;
            }
            roomCount = 0;
        }
        return neighborhood[rowIndex - 1];
    }
}
