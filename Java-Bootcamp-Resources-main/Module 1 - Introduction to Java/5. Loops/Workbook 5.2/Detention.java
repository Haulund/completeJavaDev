import java.util.Scanner;

public class Detention {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hi Bart. I can write lines for you.\nWhat do you want me to write?");
        // See Learn the Part for the instructions.
        String output = scan.nextLine();

        for (int q = 0; q < 99; q++) {
            System.out.println((q+1)+". " + output);
        }
        
    }
}
