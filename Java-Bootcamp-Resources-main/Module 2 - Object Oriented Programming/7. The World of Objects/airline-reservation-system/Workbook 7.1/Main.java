import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        Person person = new Person();
        
        person.name = "Muradin";
        person.nationality = "Ironforgian";
        person.dateOfBirth = "09012004";
        person.passport = new String[]{person.name, person.nationality, person.dateOfBirth};
        person.seatNumber = 3;
        
        System.out.println(person.name);
        System.out.println(person.nationality);
        System.out.println(person.dateOfBirth);
        System.out.println(Arrays.toString(person.passport));
        System.out.println(person.seatNumber);
    }
}
