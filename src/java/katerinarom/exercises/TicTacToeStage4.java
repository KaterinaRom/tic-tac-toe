package katerinarom.exercises;
import java.util.Scanner;

final class TicTacToeStage4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter cells: ");
    char[] chars = scanner.nextLine().toCharArray();
    char[][] matrix = new char[3][3];
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        matrix[i][j] = chars[j + 3 * i];
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
    while (true) {
      int x;
      int y;
      System.out.println("Enter the coordinates: ");
      String[] inputs = scanner.nextLine().split(" ");
      try {
        x = Integer.parseInt(inputs[0]);
        y = Integer.parseInt(inputs[1]);
      } catch (Exception e) {
        System.out.println("You should enter numbers!");
        continue;
      }
      if (x < 1 || x > 3 || y < 1 || y > 3) {
        System.out.println("Coordinates should be from 1 to 3!");
        continue;
      } else if (matrix[3 - y][x - 1] == 79 || matrix[3 - y][x - 1] == 88) {
        System.out.println("This cell is occupied! Choose another one!");
        continue;
      } else {
        matrix[3 - y][x - 1] = 'X';
        break;
      }
    }
    System.out.println("---------");
    for (int i = 0; i < 3; i++) {
      System.out.print("| ");
      for (int j = 0; j < 3; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println("|");
    }
    System.out.println("---------");
  }
}
