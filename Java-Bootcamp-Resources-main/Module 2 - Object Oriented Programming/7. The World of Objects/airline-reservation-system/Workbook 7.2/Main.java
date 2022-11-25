import java.util.Arrays;
 
public class Main {
  
    public static void main(String[] args) {
        Person person = new Person("Mura", "Azeroth", "02029384", 5);
 
        
        person.passport = new String[]{person.name, person.nationality, person.dateOfBirth};
        
       System.out.println("Name: " + person.name + "\n" + "Nationality: " + person.nationality + "\n" + "Date of Birth: " + person.dateOfBirth + "\n" + "Seat Number: " + person.seatNumber + "\n");

    }
  
  
}
