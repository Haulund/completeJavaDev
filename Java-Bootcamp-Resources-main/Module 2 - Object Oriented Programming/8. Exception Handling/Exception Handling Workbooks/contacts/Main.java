
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.Contact;
import models.ContactManager;

public class Main {
    static ContactManager manager = new ContactManager();
     

    public static void main(String[] args) {
        try{

            loadContacts("contacts.txt");
            System.out.println("CONTACS LOADED \n\n");
            System.out.println(manager);
            manageContacts();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } 
        
        
    }

    /**
     * Name: manageContacts
     *
     * Inside the function:
     *   • 1. Starts a new instance of Scanner;
     *   • 2. In an infinite loop, the user can choose to a) add b) remove a contact c) exit.
     *   •        case a: ask for the name, phone number and birthDate.
     *   •        case b: ask who they'd like to remove.
     *   •        case c: break the loop.
     *   • 3. close Scanner.
     */
    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Do you wanna 'a' add, 'b' remove a contact or 'c' exit");
            System.out.print("Enter choice: ");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("a")){
                System.out.println("creating contact: ");
                System.out.print("\tname: ");
                String nameAdd = scan.nextLine();
                System.out.print("\tphone number: ");
                String phoneNumber = scan.nextLine();
                System.out.print("\tdate of birth: ");
                String dateOfbirth = scan.nextLine();

                if (nameAdd.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5){
                    System.out.println("the input you provided is cannot be blank");
                    continue;
                }

                
                try {
                    manager.addContact(new Contact(nameAdd, dateOfbirth, phoneNumber));
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                
                } finally {
                    System.out.println("\n\nUPDATED CONTACTS\n\n");
                    System.out.println(manager);
                }

            } else if (input.equalsIgnoreCase("b")) {
                System.out.println("Removing contact: ");
                System.out.print("Please enter contact name: ");
                String nameRemove = scan.nextLine();
                manager.removeContact(nameRemove);
                System.out.println("\n\nUPDATED CONTACTS\n\n");
                System.out.println(manager);
                

            } else if (input.equalsIgnoreCase("c")){
                System.out.println("exit!");
                break;
            }
        } 
        scan.close();
    }



    /**
     * Name: loadContacts
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     * Inside the function:
     *   • 1. loads contacts from <fileName>;
     *   • 2. From the manager object, it adds all contacts to the contacts list.
     *        Hint: use scan.next to grab the next String separated by white space.
     */

     public static void loadContacts(String filename) throws FileNotFoundException {
           FileInputStream fis = new FileInputStream(filename);
           Scanner scanFile = new Scanner(fis);
           while (scanFile.hasNextLine()) {
            try {
                Contact contact = new Contact(scanFile.next(), scanFile.next(), scanFile.next());
                manager.addContact(contact);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
           }
           scanFile.close();
        
     }

}
