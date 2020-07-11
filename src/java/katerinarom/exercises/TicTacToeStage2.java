package katerinarom.exercises;
import java.util.Scanner;

final class TicTacToeStage2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter cells: ");
    String gameArea = scanner.nextLine();
    System.out.println("---------");
    System.out.println("| " + gameArea.charAt(0) + " " + gameArea.charAt(1) + " " + gameArea.charAt(2) + " |" );
    System.out.println("| " + gameArea.charAt(3) + " " + gameArea.charAt(4) + " " + gameArea.charAt(5) + " |" );
    System.out.println("| " + gameArea.charAt(6) + " " + gameArea.charAt(7) + " " + gameArea.charAt(8) + " |" );
    System.out.println("---------");
  }
}
