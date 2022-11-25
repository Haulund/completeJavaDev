public class Airline {
    
    Person[] people; //array that stores Person objects...

    public Airline() {
        people = new Person[11];
    }

    public Person getPerson(int index) {
        return people[index];
    }

    public void setPerson(Person person) {
        people[person.getSeatNumber() - 1] = person;
    }


    
}
