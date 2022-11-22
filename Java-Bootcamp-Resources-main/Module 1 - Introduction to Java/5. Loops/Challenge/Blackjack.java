import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        //Task 3 – Wait for the user to press enter.
        scan.nextLine();
        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        int userCardNumber1 = drawRandomCard();
        int userCardNumber2 = drawRandomCard();
        String userCard1 = cardString(userCardNumber1);
        String userCard2 = cardString(userCardNumber2);
        System.out.println("\n You get a \n" + userCard1 + "\n and a \n" + userCard2);


        //Task 5 – Print the sum of your hand value.
        //       – print: your total is: <hand value>
        int score =  Math.min(userCardNumber1, 10) + Math.min(userCardNumber2, 10);
        System.out.println("you total value is: " + score);

        //Task 6 – Get two random cards for the dealer.
        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //       – Print: \nThe dealer's total is hidden
        int computerCardNumber1 = drawRandomCard();
        int computerCardNumber2 = drawRandomCard();
        String computerCard1 = cardString(computerCardNumber1);
        String computerCard2 = cardString(computerCardNumber2);
        System.out.println("\n You get a \n" + computerCard1 + "\n and a \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");
        int dealerScore = Math.min(computerCardNumber1, 10) + Math.min(computerCardNumber2, 10); 

        
       
        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 

        while (true) {
            String action = hitOrStay();
            if(action.equals("hit")){
                int newCardNumber = drawRandomCard();
                String newCard = cardString(newCardNumber);
                score += newCardNumber;
                System.out.println("\nYou get a \n" + newCard);
                System.out.println("your new total is: " + score);
                if(score > 21) {
                    System.out.println("Bust! player looses");
                    System.exit(0);
                }
            } else if (action.equals("stay")) {
                break;
            }
            
        }

        
        //For tasks 9 to 13, see the article: Blackjack Part II. 
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n" + computerCard1 + "\n and a \n " + computerCard2);
        System.out.println("The dealers total is: " + dealerScore);
        
        while (true) {
            if(dealerScore > 21) {
                System.out.println("Bust! player wins!");
                System.exit(0);
            }
            if (dealerScore >= 17) {
                System.out.println("The dealer stays.");
                break;
            }
            System.out.println("The dealer hits");
            int newCardNumber = drawRandomCard();
            String newCard = cardString(newCardNumber);
            dealerScore += newCardNumber;
            System.out.println("The dealer gets a: \n" + newCard);
            System.out.println("The dealer's score is: " + dealerScore);
        } 

        if (score>dealerScore) {
            System.out.println("The Player Wins!!!");
        } else {
            System.out.println("The Dealer Wins!");
        }


        scan.close();

    }

    /** Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */
    public static int drawRandomCard() {
        return (int)(Math.random()*13)+1;
    }

    /** Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */
    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1: return  
            "   _____\n"+
            "  |A _  |\n"+ 
            "  | ( ) |\n"+
            "  |(_'_)|\n"+
            "  |  |  |\n"+
            "  |____V|\n";
            case 2:return 
            "   _____\n"+              
            "  |2    |\n"+ 
            "  |  o  |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____Z|\n";
            case 3:return
            "   _____\n" +
            "  |3    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  |  o  |\n"+
            "  |____E|\n";
            case 4:return
            "   _____\n" +
            "  |4    |\n"+
            "  | o o |\n"+
            "  |     |\n"+
            "  | o o |\n"+
            "  |____h|\n";
            case 5:return
            "   _____ \n" +
            "  |5    |\n" +
            "  | o o |\n" +
            "  |  o  |\n" +
            "  | o o |\n" +
            "  |____S|\n";
            case 6:return
            "   _____ \n" +
            "  |6    |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  | o o |\n" +
            "  |____6|\n";
            case 7:return
            "   _____ \n" +
            "  |7    |\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |____7|\n";
            case 8:return
            "   _____ \n" +
            "  |8    |\n" +
            "  |o o o|\n" +
            "  | o o |\n" +
            "  |o o o|\n" +
            "  |____8|\n";
            case 9:return
            "   _____ \n" +
            "  |9    |\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |____9|\n";
            case 10:return
            "   _____ \n" +
            "  |10  o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |o o o|\n" +
            "  |___10|\n";
            case 11:return
            "   _____\n" +
            "  |J  ww|\n"+ 
            "  | o {)|\n"+ 
            "  |o o% |\n"+ 
            "  | | % |\n"+ 
            "  |__%%[|\n";
            case 12:return 
            "   _____\n" +
            "  |Q  ww|\n"+ 
            "  | o {(|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%O|\n";
            case 13:return
            "   _____\n" +
            "  |K  WW|\n"+ 
            "  | o {)|\n"+ 
            "  |o o%%|\n"+ 
            "  | |%%%|\n"+ 
            "  |_%%%>|\n";
            default: return "";
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
    public static String hitOrStay() {
        System.out.println("Please write hit or stay:");
        String action = scan.nextLine();
        if(action.equals("hit") || action.equals("stay")) {
            return action;
        } 
        while (true) {
            System.out.println("Wrong entry - please write 'hit' or 'stay'");
            action = scan.nextLine();
            if (action.equals("hit") || action.equals("Stay")) {
                break;
            }
        }
        return action;
    }
}

