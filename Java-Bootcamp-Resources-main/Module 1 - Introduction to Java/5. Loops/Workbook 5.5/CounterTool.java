import java.util.Scanner;

public class CounterTool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("I hear you like to count by threes\n");
        System.out.println("Jimmy: It depends.");
        System.out.println("Oh, ok...");

       // See detailed instructions on Learn the Part.
       System.out.print("Pick a number to count by: ");
       int counterBy = scan.nextInt();
       System.out.print("Pick a number to start counting from: ");
       int startNumber = scan.nextInt();
       System.out.print("pick a number to count to: ");
       int endNumber = scan.nextInt();

       for (int i = startNumber; i <= endNumber; i += counterBy) {
        System.out.print(i + " ");
       }

        scan.close();
    }
}
