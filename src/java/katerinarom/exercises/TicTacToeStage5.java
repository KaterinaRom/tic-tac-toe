package katerinarom.exercises;
import java.util.Scanner;

final class TicTacToeStage5 {
     static Scanner sc = new Scanner(System.in);
     static char[][] output = new char[3][3];
     static String statue = "";
     static boolean gameOver = false;
     static int count = 1;

    public static void main(String[] args) {
      freshGame();
      while (!gameOver) {
        printField(output);
        getCoordinates();
        checkState(output);
        getResult(statue);
      }
    }

    // turn arr[] to a 3x3 output[][]
    public static char[][] freshGame() {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          output[i][j] = ' ';
        }
      }
      return output;
    }

    // Method to print the board
    public static void printField(char[][] output) {
      System.out.println("---------");
      for (char[] x : output) {
        System.out.print("| ");
        for (char y : x) {
          System.out.printf("%s ", y);
        }
        System.out.println("|");
      }
      System.out.println("---------");
    }

    // Get user move
    public static void getCoordinates() {
      int x = -1;
      int y = -1;
      boolean isInt = false;
      System.out.print("Enter the coordinates: ");
      String userCo = sc.nextLine();
      String[] move = userCo.split(" ");
      if (move.length < 2) {
        System.out.println("You should enter numbers!");
        getCoordinates();
      } else {
        try {
          x = Integer.parseInt(move[0]);
          y = Integer.parseInt(move[1]);
          isInt = true;
        } catch (Exception e) {
          System.out.println("You should enter numbers!");
          getCoordinates();
        }
        if (x > 0 && x <= 3 && y > 0 && y <= 3) {
          int c = x - 1;
          int r = Math.abs(y - 3);
          if (output[r][c] == ' ' && count % 2 == 1) {
            output[r][c] = 'X';
            count++;
          } else if (output[r][c] == ' ' && count % 2 == 0) {
            output[r][c] = 'O';
            count++;
          } else if (output[r][c] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            getCoordinates();
          }
        } else if (isInt) {
          System.out.println("Coordinates should be from 1 to 3!");
          getCoordinates();
        }
      }
    }

    // check stage
    static String checkState(char[][] output) {
      int xCount = 0;
      int oCount = 0;
      int xBackDiagonal = 0;
      int oBackDiagonal = 0;
      int xDiagonal = 0;
      int oDiagonal = 0;

      for (int i = 0; i < 3; i++) {
        int xRow = 0;
        int oRow = 0;
        int xColumn = 0;
        int oColumn = 0;
        for (int j = 0; j < 3; j++) {
          //check row
          if (output[i][j] == 'X') {
            xRow++;
            xCount++; // total X
          }
          if (output[i][j] == 'O') {
            oRow++;
            oCount++; // total O
          }
          //check column
          if (output[j][i] == 'X') {
            xColumn++;
          } else if (output[j][i] == 'O') {
            oColumn++;
          }
        }
        //check diagonal
        if (output[i][i] == 'X') {
          xBackDiagonal++;
        }
        if (output[i][i] == 'O') {
          oBackDiagonal++;
        }
        if (output[i][2 - i] == 'X') {
          xDiagonal++;
        }
        if (output[i][2 - i] == 'O') {
          oDiagonal++;
        }
        //check winning stage
        if (xRow == 3 || xColumn == 3 || xBackDiagonal == 3 || xDiagonal == 3) {
          return statue = "X";
        }
        if (oRow == 3 || oColumn == 3 || oBackDiagonal == 3 || oDiagonal == 3) {
          return statue = "O";
        }
      }
      if (Math.abs(xCount - oCount) > 1) {
        return statue = "Impossible";
      }
      if (xCount + oCount == 9) {
        return statue = "Draw";
      }
      return statue = "Not finish";
    }

    //check game result after every moves and stop the while loop in main if Game Over
    static void getResult(String statue) {
      switch (statue) {
        case "Impossible":
          gameOver = true;
          printField(output);
          System.out.println("Impossible");
          break;
        case "X":
          gameOver = true;
          printField(output);
          System.out.println("X wins");
          break;
        case "O":
          gameOver = true;
          printField(output);
          System.out.println("O wins");
          break;
        case "Draw":
          gameOver = true;
          printField(output);
          System.out.println("Draw");
          break;
      }
    }
  }

