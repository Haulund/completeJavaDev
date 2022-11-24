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
            String hiddenWord = getHiddenWord(words);
            char[] hiddenWordArray = createCharArray(hiddenWord);
            char[] placeholderArray = createPlaceholderArray(hiddenWordArray);
            char[] missesArray = new char[6];
            int correctGuesses = 0;
            int misses = 0;

            //Game starts
            //Turns = 6 guesses + hiddenword length
            for (int i = 0; i < placeholderArray.length+6; i++) {
                //Picture
                System.out.println(gallows[misses]);

                //print missing word UI
                System.out.print("Word: ");
                for (int j = 0; j < placeholderArray.length; j++) {
                    System.out.print(placeholderArray[j] + " ");
                }
                System.out.print("\n\n");
                
                //Misses
                System.out.print("Misses:\t ");
                for (char c : missesArray) {
                    System.out.print(c + "");
                }
                System.out.print("\n\n");
                
                if(misses == 6) {
                    System.out.println("YOU LOOSE!!!");
                    System.exit(0);
                }
                
                if(correctGuesses == hiddenWordArray.length){
                    System.out.println("You WIN !");
                    System.exit(0);
                } 
                
                //Guess
                System.out.print("Guess: \t ");
                char guess = scan.next().charAt(0);

                boolean checkIfMatch = checkIfMatch(guess, hiddenWordArray);
                boolean checkIfCharRepeat = checkIfCharRepeat(hiddenWordArray, guess);

                // if placeholder string equals hiddenword player wins
                if(checkIfCharRepeat && checkIfMatch) {
                    correctGuesses++;
                    
                    //getting repeat indexes
                    int[] repeatIndexes = repeatIndexes(hiddenWordArray, guess);
                    
                    //replace the correct value in placeholder array
                    updatePlaceholderArray(repeatIndexes, placeholderArray, guess);
                    
                } else if (checkIfMatch){
                    correctGuesses++;
                    
                    // find guess chars index in hiddenwordstring
                    int index = hiddenWord.indexOf(guess);
                    // replace char in placeholder array
                    placeholderArray[index] = guess;
                    
                } else {
                    misses++;
                    
                    // missesArray update
                    missesArray[misses - 1] = guess;
                }
            }
            System.out.println("YOU LOOSE!!!");
            System.exit(0);
    }

    public static String getHiddenWord(String[] words) {
        int randomNumber = getRandomNumberFromArrayLength(words);
        return words[randomNumber];
    }

    public static int getRandomNumberFromArrayLength(String[] array) {
        return (int)((Math.random()*words.length)-1);
    }

    public static char[] createCharArray(String word) {
        char[] result = new char[word.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = word.charAt(i);
        }
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
    
    public static boolean checkIfCharRepeat(char[] array, char guess) {
        int counter = 0;
        int[] repeats = new int[array.length];
        
            char ch = guess;
            Character charFromCh = Character.valueOf(ch) ;
            for (int j = 0; j < array.length; j++) {
                Character charFromArray = Character.valueOf(array[j]); 
                if (charFromCh.equals(charFromArray)) {
                    counter++;
                }
                repeats[j] = counter;
            }
            counter = 0;
        
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
            char ch = guess;
            Character charFromCh = Character.valueOf(ch) ;
            for (int j = 0; j < array.length; j++) {
                Character charFromArray = Character.valueOf(array[j]); 
                if (charFromCh.equals(charFromArray)) {
                    counter++;
                    System.out.println("counter: " + counter);
                }
                repeats[j] = counter;
                counter = 0;
            }
        return repeats;
    }

    public static String updateString(char[] array) {
        return String.valueOf(array);
    }

    public static void updatePlaceholderArray(int []repeatIndexes, char[] placeholderArray, char guess) {
        for (int j = 0; j < repeatIndexes.length; j++) {
            if(repeatIndexes[j] == 1) {
                Character placeHolderChar = Character.valueOf(placeholderArray[j]);
                //update
                if (placeHolderChar.equals('_')) {
                    placeholderArray[j] = guess;
                    break;
                }
            }
        }
    }
}





