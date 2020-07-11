package katerinarom.exercises;
import java.util.Scanner;

final class TicTacToeStage3 {
  public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
  String str = scanner.nextLine();
        System.out.println("---------");
        System.out.println("| " + str.charAt(0) + " " + str.charAt(1) + " " + str.charAt(2) + " |" );
        System.out.println("| " + str.charAt(3) + " " + str.charAt(4) + " " + str.charAt(5) + " |" );
        System.out.println("| " + str.charAt(6) + " " + str.charAt(7) + " " + str.charAt(8) + " |" );
        System.out.println("---------");
         System.out.println(check(str));
}

  public static String check(String str){
    char[][] matrix = new char[3][3];
    int offset = 0;

    //Convert string to a char 2D array
    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++){
        matrix[i][j] = str.charAt(offset++);
      }
    }

    int Xcnt = 0, Ocnt = 0, blank = 0;
    boolean Xwin = false, Owin = false;

    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length; j++){
        if(matrix[i][j] == 'X')
          Xcnt++;
        if(matrix[i][j] == 'O')
          Ocnt++;
        if(matrix[i][j] == '_')
          blank++;
      }
    }

    for(int i = 0; i < matrix.length; i++){
      for(int j = 0; j < matrix[i].length - 2; j++){
        //Check horizontal, vertical, and diagonal
        if(matrix[i][j] == 'X' && matrix[i][j + 1] == 'X' && matrix [i][j + 2] == 'X'){
          Xwin = true;
        }
        if(matrix[i][j] == 'O' && matrix[i][j + 1] == 'O' && matrix [i][j + 2] == 'O'){
          Owin = true;
        }
        if(matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix [2][2] == 'X'){
          Xwin = true;
        }
        if(matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix [2][2] == 'O'){
          Owin = true;
        }
        if(matrix[2][0] == 'X' && matrix[1][1] == 'X' && matrix [0][2] == 'X'){
          Xwin = true;
        }
        if(matrix[2][0] == 'O' && matrix[1][1] == 'O' && matrix [0][2] == 'O'){
          Owin = true;
        }

      }

    }

    for(int i = 0; i < matrix.length - 2; i++){
      for(int j = 0; j < matrix[i].length; j++){
        if(matrix[i][j] == 'X' && matrix[i + 1][j] == 'X' && matrix[i + 2][j] == 'X'){
          Xwin = true;
        }
        if(matrix[i][j] == 'O' && matrix[i + 1][j] == 'O' && matrix[i + 2][j] == 'O'){
          Owin = true;
        }
      }
    }

    //Test Cases
    if(Xwin && Owin || Math.abs(Xcnt - Ocnt) >= 2){
      return "Impossible";
    }
    else if(Xwin){
      return "X wins";
    }
    else if(Owin){
      return "O wins";
    }
    else if(!Owin && !Xwin && blank == 0){
      return "Draw";
    }
    else{
      return "Game not finished";
    }

  }

}

