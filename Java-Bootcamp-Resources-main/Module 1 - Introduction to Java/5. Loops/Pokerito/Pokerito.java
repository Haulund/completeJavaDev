import java.util.Scanner;

public class Pokerito {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*Task 2: Explain the rules*/

        System.out.println("Let's play Pokerito. Type anything when you're ready.");
        System.out.println("It's like Poker, but a lot simpler.\n");
        System.out.println("• There are two players, you and the computer.");
        System.out.println("• The dealer will give each player one card.");
        System.out.println("• Then, the dealer will draw five cards (the river)");
        System.out.println("• The player with the most river matches wins!");
        System.out.println("• If the matches are equal, everyone's a winner!");
        System.out.println("• If the matches are equal, everyone's a winner!\n");
        System.out.println("• Ready? Type anything if you are.");
        scan.nextLine();

        

        /*Task 3: Present the user with a card */
        System.out.println("Here's your card: ");
        String userCard = randomCard();
        System.out.println("\nHere's the computer's card: ");
        String computerCard = randomCard();

        int yourMatches = 0;
        int computerMatches =0;

        /** Task 4 - Draw five cards
         * 
         * • print:  Now, the dealer will draw five cards. Press enter to continue.
         * • The dealer will draw a card every time the user presses enter.
         * • Before you draw a card, print the order it was drawn in:
         *      Card 1 
         *      <2 new lines>
         *      <print card>
         *      Card 2
         *      <2 new lines>
         *      <print card>
         *      ...
         */
        System.out.println("Now, the dealer will draw five cards. Press enter to continue.");
        for (int i = 1; i <= 5; i++) {
            scan.nextLine();
            System.out.println("Card: " + i);
            String riverCard = randomCard();

            if(userCard.equals(riverCard)){
                yourMatches++;
            }
            if (computerCard.equals(riverCard)){
                computerMatches++;
            }
        }

        System.out.println("Your number of matches: " + yourMatches);
        System.out.println("Computer number of matches: " + computerMatches);

        if(yourMatches>computerMatches){
            System.out.println("\n You Win!");
        } else if(computerMatches>yourMatches){
            System.out.println("The computer wins!");
        } else {
            System.out.println("everyone wins!");
        }

        /** Task 5 - Get the winner
         * 
         * • Count your number of matches.
         * • Count the computer's number of matches.
         * • print: Your number of matches: <yourMatches>
         * • print: Computer number of matches:  <computerMatches>
         * 
         * • If you have more matches, print: You win!. 
         * • If the computer has more matches, print: The computer wins! 
         * • If the matches are equal, print: everyone wins!.
         */

         scan.close();
    }

    /** Task 1
     * 
     * Function name – randomCard
     * @return (String)
     * 
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card that matches the random number (get the String values from cards.text).   
     */
    public static String randomCard() {
        int randomNumber = (int)(Math.random()*13)+1;
        String card = "";
        switch (randomNumber) {
            case 1:
                card = "   _____\n"+
                "  |A _  |\n"+ 
                "  | ( ) |\n"+
                "  |(_'_)|\n"+
                "  |  |  |\n"+
                "  |____V|\n";
                
                System.out.println(card);
                break;
            case 2:
            card = "   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";
            System.out.println(card);
                break;
            case 3:
            card = "   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            System.out.println(card);
                break;
            case 4:
            card = "   _____\n" +
            "  |4    |\n"+  
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";
            System.out.println(card);
            break;
            case 5:
            card = "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";
            System.out.println(card);
            break;
            case 6:
            card = 
            "   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n";
            System.out.println(card);
            break;
            case 7:
            card =
            "   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n";
            System.out.println(card);
            break;
            case 8:
            card = 
            "   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";
            System.out.println(card);
            break;
            case 9:
            card = 
            "   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n";
            System.out.println(card);
            break;
            case 10:
            card = 
            "   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n";
            System.out.println(card);
            break;
            case 11:
            card =
            "   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";
            System.out.println(card);
            break;
            case 12:
            card = 
            "   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            System.out.println(card);
            break;
            case 13:
            card = 
            "   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n";
            System.out.println(card);
            default:
                break;
        }
        return card;
    }

}
