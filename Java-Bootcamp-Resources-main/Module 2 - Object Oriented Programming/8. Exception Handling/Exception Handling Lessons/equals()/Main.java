import java.util.Scanner;

import javax.swing.SpinnerDateModel;

public class Main {
    public static void main(String[] args) {
        Car car = new Car( "toyota", "blue");
        Car sameCar = car;

        Scanner scan = new Scanner(System.in);

        System.out.println(car.equals(scan));
    }

}
