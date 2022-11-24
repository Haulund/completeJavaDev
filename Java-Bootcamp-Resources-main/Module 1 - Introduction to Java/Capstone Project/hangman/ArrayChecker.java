import java.util.Arrays;
import java.util.Scanner;

public class ArrayChecker {
    public static void main(String[] args) {
        char[] eagle = {'e', 'a', 'a', 'l', 'e'};

        Scanner scan = new Scanner(System.in);
        System.out.print("gues:");
        char guess = scan.next().charAt(0);
        //is there repeats?
        boolean repeats = hasRepeats(eagle, guess);
        int[] repeatIndexes = repeatIndexes(eagle, guess);

        System.out.println("boolean is: " + repeats);
        System.out.println("repeat indexex: " + Arrays.toString(repeatIndexes));


    }

    public static boolean hasRepeats(char[] array, char guess) {
        int counter = 0;
        int[] repeats = new int[array.length];
        
            char ch = guess; //e
            Character charFromCh = Character.valueOf(ch) ;
            for (int j = 0; j < array.length; j++) {
                Character charFromArray = Character.valueOf(array[j]); //
                if (charFromCh.equals(charFromArray)) {
                    counter++;
                    //System.out.println("counter: " + counter);
                }
                repeats[j] = counter;
            }
            counter = 0;
        

        //System.out.println("repeatsArray: " + Arrays.toString(repeats));
        for (int i : repeats) {
            if(i >= 2){
                return true;
            }
        }
        return false;
    }

    public static int[] repeatIndexes(char[] array, char guess) {
        int counter = 0;
        int[] repeats = new int[array.length];
            char ch = guess; //e
            Character charFromCh = Character.valueOf(ch) ;
            for (int j = 0; j < array.length; j++) {
                Character charFromArray = Character.valueOf(array[j]); //
                if (charFromCh.equals(charFromArray)) {
                    counter++;
                    System.out.println("counter: " + counter);
                }
                repeats[j] = counter;
                counter = 0;
            }
        //System.out.println("repeatsArray: " + Arrays.toString(repeats));
        return repeats;
    }
}
