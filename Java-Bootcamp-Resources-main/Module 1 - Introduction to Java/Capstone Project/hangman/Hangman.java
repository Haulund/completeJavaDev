import java.util.Arrays;
import java.util.Scanner;

import javax.naming.InitialContext;

public class Hangman {
    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        
        
            // Headline
            System.out.println("\n\n");
            System.out.println("\tHANGMAN!\n\n");
            
            //Word
            String hiddenWord = "eagle"; //getHiddenWord(words);
            char[] hiddenWordArray = createCharArray(hiddenWord);
            char[] placeholderArray = createPlaceholderArray(hiddenWordArray);
            
            //Game starts
            //Turns = 6 guesses + hiddenword length
            for (int i = 0; i < placeholderArray.length+6; i++) {
                //Picture
                System.out.println(gallows[0]);

                //print missing word UI
                System.out.print("Word: ");
                for (int j = 0; j < placeholderArray.length; j++) {
                    System.out.print(placeholderArray[j] + " ");
                }
                System.out.print("\n\n");
                
                //Misses
                String missesString = "";
                System.out.print("Misses:\t "+ missesString +"\n\n");
                
                //Guess
                System.out.print("Guess: \t- ");
                char guess = scan.next().charAt(0);

                boolean checkIfMatch = checkIfDuplicateLetters(guess, hiddenWordArray, placeholderArray);
                
                // if placeholder string equals hiddenword player wins
                if(hiddenWordArray.equals(placeholderArray)){
                    System.out.println("You WIN !");
                    System.exit(0);
                } else if (checkIfMatch){
                    // if guess is in the hiddenway array, update placeholderstring and continue
                    System.out.println("UPDATE STRING");
                    // find guess chars index in hiddenwordstring
                    int index = hiddenWord.indexOf(guess);
                    // replace char in placeholder array
                    placeholderArray[index] = guess;
                    
                } else {
                    // else update missesString and update gallows and continue
                    System.out.println("UPDATE MISSSESTRING AND GALLOWS");
                }

                
                // TEMP Code:
                System.out.println("input: " + guess);
                //System.out.println("HIDDEN WORD: " + hiddenWord);
            }
            System.out.println("YOU LOOSE!!!");
            System.exit(0);
        

        //1. user input
        //2. check input
        //3. show correct guess
        //3. show miss
        //4. update hangman
    }

    public static String getHiddenWord(String[] words) {
        int randomNumber = getRandomNumberFromArrayLength(words);
        //return random word
        System.out.println("Random Word: " + words[randomNumber]);
        return words[randomNumber];
    }

    public static int getRandomNumberFromArrayLength(String[] array) {
        // random number between 0 and words.length - 1
        return (int)((Math.random()*words.length)-1);
    }

    public static char[] createCharArray(String word) {
        char[] result = new char[word.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = word.charAt(i);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static char[] createPlaceholderArray(char[] array) {
        char[] placeholderArray = new char[array.length];
        for (int i = 0; i < placeholderArray.length; i++) {
            placeholderArray[i] = '_';
        }
        return placeholderArray;
    }

    public static boolean checkIfMatch(char ch, char[] hiddenWordArray) {
        Character guess = Character.valueOf(ch);
        for (int i = 0; i < hiddenWordArray.length; i++) {
            Character hiddenWordCharacter = Character.valueOf(hiddenWordArray[i]);
            if (guess.equals(hiddenWordCharacter)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkIfDuplicateLetters(char ch, char[] hiddenWordArray, char[] placeholderArray) {
        for (int i = 0; i < placeholderArray.length; i++) {
            Character placeHolderChar = Character.valueOf(placeholderArray[i]);
            Character hiddenChar = Character.valueOf(hiddenWordArray[i]);
            Character chareCharacter = Character.valueOf(ch);
            if(placeHolderChar.equals('_')){
                if(chareCharacter.equals(hiddenChar))
                return true;
            }
        }
        return false;
    }

    public static String updateString(char[] array) {
        return String.valueOf(array);
    }
}





