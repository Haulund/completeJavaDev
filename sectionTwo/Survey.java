import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int counter = 0;

        System.out.println("Welcome. Thank you for taking the survey");
        
        System.out.println("\nWhat is your name?");
        String name = scan.nextLine();
        counter++;
        
        System.out.println("\nHow much money do you spend on Coffee");
        double coffeePrice = scan.nextDouble();
        counter++;

        System.out.println("\nhow much money do you spend on fast food?");
        double foodPrice = scan.nextDouble();
        counter++;

        System.out.println("\nhow many times a week do you buy coffee?");
        int coffeeAmount = scan.nextInt();
        counter++;

        System.out.println("\nhow many times a week do you buy fastfood?");
        int foodAmount = scan.nextInt();
        counter++;

        System.out.println("\nThank you " + name + " for answering all " + counter + " questions.");
        System.out.println("Your fastfood expenses are " + (foodPrice/coffeePrice) + " times you coffee expenses");
        System.out.println("Weekly, you spend $" +(coffeeAmount*coffeePrice) + " on coffee.");
        System.out.println("Weekly, you spend $" +(foodAmount*foodPrice)+ " on food.");
        scan.close();
    }
}
