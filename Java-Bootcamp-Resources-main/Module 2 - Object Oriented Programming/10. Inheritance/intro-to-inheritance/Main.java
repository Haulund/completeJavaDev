public class Main {
    public static void main(String[] args) {
        Person person = new Person("Zack", 29);
        Person person2 = new Person(person);

        System.out.println(person.toString());
    } 
}
