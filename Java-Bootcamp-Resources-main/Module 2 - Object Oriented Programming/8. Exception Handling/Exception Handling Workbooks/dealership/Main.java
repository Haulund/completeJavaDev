import java.util.Scanner;

import models.Car;
import models.Dealership;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        Car[] cars = new Car[] {
            new Car("Nissan", 5000),
            new Car("Dodge", 12000),
        };
        cars[1].setMake("Volvo");
        cars[1].setPrice(8500);

        Dealership dealership = new Dealership(cars);

        System.out.println("\n************* JAVA DEALERSHIP *************");
        while (true) {
            System.out.println(dealership);
            if(dealership.isEmpty()) {
                System.out.println("we are all sold out");
                break;
            }
            System.out.print("Enter the spot number of the car you want to buy: "); 
            if (!scan.hasNextLine()) {
                scan.nextLine();
                System.out.println("INVALID INPUT");
                continue;
            }
            int spot = scan.nextInt();
            scan.nextLine();
            if(spot < 0 || spot > dealership.getLength() - 1) {
                System.out.println("INVALID Index");
                continue;
            } else if (dealership.getCar(spot) == null) {
                System.out.println("Empty Spot");
                continue;
            }
            dealership.sell(spot);  
            System.out.println("Type 'yes' to continue shopping");  
            if(!scan.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }

       //scan.close();

    }
}
