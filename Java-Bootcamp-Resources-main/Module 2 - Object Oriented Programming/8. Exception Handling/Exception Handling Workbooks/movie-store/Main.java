import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Movie;
import models.Store;


public class Main {
    static Store store = new Store();
    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {

            loadMovies("movies.txt");
            System.out.println("Movies loaded");
            System.out.println(store);
            manageMovies();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }   

    /**
     * Name: manageMovies
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) purchase b) rent c) return d) exit.
     *   •        case a: ask for the name and sell.
     *   •        case b: ask for the name and rent.
     *   •        case c: ask for the name and return.
     *   • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc)sell");
            String response = scan.nextLine();
            if (response.isBlank() || response == null) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }
            if(!(response.equals("a") || response.equals("b") || response.equals("c"))) {
                scan.close();;
                break;
            }
            System.out.print("Enter the name of the movie: ");
            String name = scan.nextLine();

            switch (response) {
                case "a":
                    if(!store.getMovie(name).isAvailable()){
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                        continue;
                    }
                    store.action(name, "sell"); 
                    break;
                case "b":store.action(name, "rent"); break;
                case "c":store.action(name, "return");break;
                default: break;
            }
            System.out.println("\n\nUPDATED MOVIES\n\n" + store);
        }
    }


    /**
     * Name: loadMovies
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads movies from <fileName>.txt.
     *   • 2. adds all movies to the store object's movie field.
     *        Hint: You will need to 'split' a String into three Strings.
     */

     public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(stream);

        while (scanFile.hasNextLine()) {
            String line = scanFile.nextLine();
            String[] words = line.split("--");
            store.addMovie(new Movie(words[0], words[1], Double.parseDouble(words[2])));
        }
        scanFile.close();
     }

}
