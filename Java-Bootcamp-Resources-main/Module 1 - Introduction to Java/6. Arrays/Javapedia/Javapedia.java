import java.util.Arrays;
import java.util.Scanner;

public class Javapedia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n**********Javapedia**********");
        System.out.println("How many historical figures will you register?");
        //Task 1 – Ask the user: how many historical figures will you register?
        //       – Store the value.
        int numberOfHistoricalFigures = scan.nextInt();
        
        //Task 2 – Create a 2D array with a variable number of rows, and 3 values per row.     
        String[][] database = new String[numberOfHistoricalFigures][3];
        scan.nextLine();    
         
        //Watch out for the nextLine() pitfall. 
        for (int i = 0; i < database.length; i++) {
            System.out.println("\n\tFigure " + (i+1));
            for (int j = 0; j < 3; j++) {
                switch (j){
                    case 0: 
                        System.out.print(" - Name: ");
                        database[i][0] = scan.nextLine();
                        break;
                    case 1: 
                        System.out.print(" - Date of birth: ");
                        database[i][1] = scan.nextLine();
                        break;
                    case 2: 
                        System.out.print(" - Occupation: ");
                        database[i][2] = scan.nextLine();
                        break;
                    default: break;
                }
            }
            System.out.print("\n");
            
        }
             
        System.out.println("These are the values you stored:"); 
        //Task 4: call print2DArray.
        print2DArray(database); 

        System.out.print("\nWho do you want information on? ");  
        String search = scan.nextLine();

        for (int i = 0; i < database.length; i++) {
            if(database[i][0].equalsIgnoreCase(search)){
                System.out.println("\t " + "Name: "+database[i][0]);
                System.out.println("\t " + "Data of birth: "+database[i][1]);
                System.out.println("\t " + "Occupation: " + database[i][2]);
            }
        }
        /*Task 5: Let the user search the database by name. 
            If there's a match:
              print(    tab of space    Name: <name>)
              print(    tab of space    Date of birth: <date of birth>)
              print(    tab of space    Occupation: <occupation>)

        */  


        scan.close();
    }

    /**
     * Function name: print2DArray
     * @param array (String[][])
     * 
     * Inside the function
     *  1. print the database
     *     • a tab of space precedes each row.
     *     • each value in database has one space from the other value. 
     *     • print a new line.
     */

     public static void print2DArray(String[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print("Figure " + (i+1) + ": \t");
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.print("\n");
        }
     }

}
