import java.net.SocketTimeoutException;
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            //Task 1: Create an array with three rows of '_' characters.
            String[][] board = {
              {"_", "_", "_"},
              {"_", "_", "_"},
              {"_", "_", "_"}
            };

            //Task 2: Call the function printBoard();
            printBoard(board);
            for (int i = 0; i < 9; i++) {
              // turn X
              if (i%2 == 0) {
                
                int[] turn = {0,0};

                System.out.println("Turn: X");

                while (true){
                  turn = askUser(board);
                  if (board[turn[0]][turn[1]].equals("X")) {
                    System.out.println(" this is your own spot try again");
                    turn = askUser(board);
                  }
                  if (board[turn[0]][turn[1]].equals("O")) {
                    System.out.println(" this is your oponent spot try again");
                    turn = askUser(board);
                  }
                  if(board[turn[0]][turn[1]].equals("_")){
                    break;
                  }
                }

                board[turn[0]][turn[1]] = "X";
                printBoard(board);
                checkWin(board);
              } else {
                //Turn O
                int[] turn;
                System.out.println("Turn: O");
                while (true){
                  turn = askUser(board);
                  if (board[turn[0]][turn[1]].equals("O")) {
                    System.out.println(" this is your own spot try again");
                    turn = askUser(board);
                  }
                  if (board[turn[0]][turn[1]].equals("X")) {
                    System.out.println(" this is your oponent spot try again");
                    turn = askUser(board);
                  }
                  if(board[turn[0]][turn[1]].equals("_")){
                    break;
                  }
                }
                board[turn[0]][turn[1]] = "O";
                printBoard(board);
                checkWin(board);

              }
            }
              /*
              

                Task 6 - Call the function.
                   if return value == 3 {
                     print: X wins and break the loop
                  } else if return value == -3 {
                     print: O wins and break the loop
                  }

              } 
              */
            
            scan.close();
        }

    public static void printBoard(String[][] board) {
      for (int i = 0; i < board.length; i++) {
        System.out.print("\n\t");
        for (int j = 0; j < board[i].length; j++) {
          System.out.print(board[i][j]+" ");
        }
        System.out.print("\n\n");
      }
     }

   /** Task 4 - Write a function that lets the user choose a spot
     * Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */
    public static int[] askUser(String[][] board) {
      System.out.print("pick a row and a column number: ");
      int row = scan.nextInt();
      int column = scan.nextInt();
      int[] output = {row, column};
      
      
      
      return output;
    }

    /** Task 6 - Write a function that determines the winner
     * Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */

     public static int checkWin(String[][] board) {
      int count = 0;

      //row check
      for (int i = 0; i < board.length; i++) {
        count = 0;
        for (int j = 0; j < board[i].length; j++) {
          if(board[i][j].equals("X")){
            count++;
          }
          if(board[i][j].equals("O")){
            count--;
          }
        }
        
        if(count == 3) {
          System.out.println("X Wins");
          System.exit(0);
          break;
        } else if(count == -3){
          System.out.println("O Wins");
          System.exit(0);
          break;
        } else {
          continue;
        }
      }
      

      // column check
      count = 0;
      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          
          if(board[j][i].equals("X")){
            count++;
          }
          if(board[j][i].equals("O")){
            count--;
          }
        }
        if(count == 3) {
          System.out.println("X Wins");
          System.exit(0);
          break;
        } else if(count == -3){
          System.out.println("O Wins");
          System.exit(0);
          break;
        } else {
          //System.out.println("no clomun winner");
          continue;
        }
      }

      // left diagonal
      count = 0;
      for (int i = 0; i < board.length; i++) {
        if(board[i][i].equals("X")){
          count++;
        }
        if(board[i][i].equals("O")){
          count--;
        }
        
        if(count == 3) {
          System.out.println("X Wins");
          System.exit(0);
          break;
        } else if(count == -3){
          System.out.println("O Wins");
          System.exit(0);
          break;
        } else {
          //System.out.println("no left diagonal winner");
          continue;
        }
      }

      count = 0;
      // right diagonal
      for (int i = 0; i < board.length; i++) {
        if(board[i][2-i].equals("X")){
          count++;
        }
        if(board[i][2-i].equals("O")){
          count--;
        }

        if(count == 3) {
          System.out.println("X Wins");
          System.exit(0);
          break;
        } else if(count == -3){
          System.out.println("O Wins");
          System.exit(0);
          break;
        } else {
          //System.out.println("no right diagonal winner");
          continue;
        }
      }

      
      
      return count;
     }


}
