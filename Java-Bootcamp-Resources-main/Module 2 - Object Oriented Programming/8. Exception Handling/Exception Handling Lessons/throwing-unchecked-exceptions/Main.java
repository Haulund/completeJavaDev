import models.*;

public class Main {
    public static void main(String[] args) {
        Employee stocker = new Employee("Poul", "Stocker");
        Employee assisManager = new Employee("Nicholas", "Assistent Manager");
        Employee manager = new Employee("Demian", "Manager");

        Store store = new Store();
        store.setEmployees(0, stocker);
        store.setEmployees(1, assisManager);
        store.setEmployees(2, manager);

        System.out.println(store);
        store.open();
        
    }
}
