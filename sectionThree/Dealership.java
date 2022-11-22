import java.util.Scanner;

public class Dealership {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the Java dealership");
        System.out.println(" - Select option 'a' to buy a car");
        System.out.println(" - Select option 'b' to buy a car");
        String option = scan.nextLine();

        switch (option) {
            case "a":
                System.out.println("What is your budget?");
                int budget = scan.nextInt();
                if(budget >= 10000){
                    System.out.println("Great a Nissan Altima is available");
                    System.out.println("\nDo you have insurance? Write yes or no");
                    scan.nextLine();
                    String insurance = scan.nextLine();
                    System.out.println("\nDo you have a drivers license");
                    String license = scan.nextLine();
                    System.out.println("\nWhat is your credit score?");
                    int creditScore = scan.nextInt();
                    if(insurance.equals("yes") && license.equals("yes") && creditScore >= 660) {
                        System.out.println("Sold! pleasure doing business with you");
                    } else {
                        System.out.println("We're sorry you are not eligible");
                    }
                } else {
                    System.out.println("We don't sell cars under $10.000. Sorry");
                }

                break;
            case "b":
                System.out.println("What is your car valued at?");
                int value = scan.nextInt();
                System.out.println("\nWhat is your selling price?");
                int price = scan.nextInt();
                if( value > price && price < 30000) {
                    System.out.println("\npleasure doing business with you");
                } else {
                    System.out.println("\nSorry, we are not interested!");
                }
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        scan.close();

        if (option == "a") {
            
        }

    }
}
