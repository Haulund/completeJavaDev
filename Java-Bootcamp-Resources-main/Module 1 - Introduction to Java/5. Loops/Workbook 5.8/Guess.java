import java.util.Scanner;

public class Guess  {
    public static void main(String[] args) {
        int secretNumber = (int)(Math.random() * 5) + 1;
        
        System.out.print("I chose a number between 1 and 5. Try to guess it: ");
        
        Scanner scan = new Scanner(System.in);
        //See Learn the Part for detailed instructions.
        int userGuess = scan.nextInt();       
        
        while (userGuess != secretNumber){
            System.out.print("Guess again: ");
            userGuess = scan.nextInt();
        }
        System.out.println("You got it!");
            scan.close();
    }

}
