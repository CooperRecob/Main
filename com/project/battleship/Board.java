package com.project.battleship;

public class Board {
     private Ship[][] board;

     public Board(Ship ship1, Ship ship2, Ship ship3) {
          board[ship1.getX()][ship1.getY()] = ship1;
          board[ship2.getX()][ship2.getY()] = ship2;
          board[ship3.getX()][ship3.getY()] = ship3;

          for(int x = 0; x < 8; x++) {
               for(int y = 0; y < 8; y++) {
                    if(board[x][y] == null) {
                         board[x][y] = null;
                    }
               }
          }
     }

     public int hitCount() {
          int result = 0;

          for(int x = 0; x < 8; x++) {
               for(int y = 0; y < 8; y++) {
                    if(board[x][y] != null) {
                         result++;
                    }
               }
          }
          return result;
     }

     public void shot(int x, int y) {
          if(board[x][y] != null) {
               board[x][y].setHit(true);
          }
     }
}
